package io.github.nkrusch.spacelaunchone.features.map;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import androidx.appcompat.widget.GridLayoutManager;
import androidx.appcompat.widget.LinearLayoutManager;
import androidx.appcompat.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBufferResponse;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.LinkedList;
import java.util.List;

import io.github.nkrusch.spacelaunchone.R;

/**
 * Place fragment is a bottom sheet dialog that opens when user clicks a place of interest in the map.
 * The map identifies the placeId of the clicked location and provides it to this fragment.
 * This fragment can then display images about the selected place (if any)
 */
public class PlacesFragment extends BottomSheetDialogFragment {

    private final String EXTRA_RVSTATE = "recyclerview_state";
    private static final String EXTRA_PLACENAME = "place_name";
    private static final String EXTRA_PLACEID = "place_id";
    private GeoDataClient mGeoDataClient;
    private String placeId;
    private String placeName;
    private RecyclerView mRecyclerView;
    private TextView mHeading;

    /**
     * @param id   placeId of interest
     * @param name place name if known (this fragment will recover name if not known by parent)
     */
    public static PlacesFragment newInstance(String id, String name) {
        PlacesFragment f = new PlacesFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_PLACEID, id);
        args.putString(EXTRA_PLACENAME, name);
        f.setArguments(args);
        return f;
    }

    /**
     * Parent of this fragment must provide the placeId of interest
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            placeId = bundle.getString(EXTRA_PLACEID);
            placeName = bundle.getString(EXTRA_PLACENAME);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog psf = super.onCreateDialog(savedInstanceState);
        psf.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                BottomSheetDialog d = (BottomSheetDialog) dialog;
                FrameLayout bottomSheet = d.findViewById(android.support.design.R.id.design_bottom_sheet);
                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        return psf;
    }

    /**
     * Setup RecyclerView and initialize place loopup
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        mHeading = view.findViewById(R.id.places_heading);
        if (placeName != null && !placeName.isEmpty()) mHeading.setText(placeName);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,
                LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(new PlacesImageAdapter(new LinkedList()));
        if (savedInstanceState != null && savedInstanceState.containsKey(EXTRA_RVSTATE))
            mRecyclerView.scrollToPosition(savedInstanceState.getInt(EXTRA_RVSTATE));

        placeLookup();
        return view;
    }

    /**
     * Restore RecyclerView state
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        int scrollPosition = 0;
        if (mRecyclerView.getLayoutManager() != null) {
            LinearLayoutManager lm =
                    ((LinearLayoutManager) mRecyclerView.getLayoutManager());
            scrollPosition = lm.findFirstCompletelyVisibleItemPosition();
        }
        outState.putInt(EXTRA_RVSTATE, scrollPosition);
        super.onSaveInstanceState(outState);
    }

    /**
     * Check that provided placeId exists; if true try loading images for it
     */
    private void placeLookup() {
        if (getContext() == null) return;
        mGeoDataClient = Places.getGeoDataClient(getContext());
        mGeoDataClient.getPlaceById(placeId).addOnCompleteListener(new OnCompleteListener<PlaceBufferResponse>() {
            @Override
            public void onComplete(@NonNull Task<PlaceBufferResponse> task) {
                if (task.isSuccessful()) {
                    PlaceBufferResponse places = task.getResult();
                    Place myPlace = places.get(0);
                    mHeading.setText(myPlace.getName());
                    getPhotos(placeId);
                    places.release();
                } else {
                    mHeading.setText(R.string.place_not_found);
                }
            }
        });
    }

    /**
     * Load images about selected place
     * This method first gets image metadata to find out if there are images;
     * If there are some imager, first update adapter to show placeholder images until
     * image loading has completed. Once image bitmaps have loaded update the adapter to show images.
     */
    private void getPhotos(final String placeId) {
        final Task<PlacePhotoMetadataResponse> photoMetadataResponse = mGeoDataClient.getPlacePhotos(placeId);
        photoMetadataResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoMetadataResponse>() {
            @Override
            public void onComplete(@NonNull Task<PlacePhotoMetadataResponse> task) {
                PlacePhotoMetadataResponse photos = task.getResult();
                final PlacePhotoMetadataBuffer photoMetadataBuffer = photos.getPhotoMetadata();
                final List<Bitmap> tmp = new LinkedList();
                final List<Bitmap> images = new LinkedList();
                final List<Integer> progressCounter = new LinkedList<>();

                for (PlacePhotoMetadata ppmd : photoMetadataBuffer) {
                    tmp.add(null);
                    final Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(ppmd);
                    photoResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoResponse>() {
                        @Override
                        public void onComplete(@NonNull Task<PlacePhotoResponse> task) {
                            PlacePhotoResponse photo = task.getResult();
                            if (task.isSuccessful()) images.add(photo.getBitmap());
                            progressCounter.add(1);
                            if (progressCounter.size() == photoMetadataBuffer.getCount())
                                handleDataChange(images);
                        }
                    });
                }
                handleDataChange(tmp);
            }
        });
    }

    /**
     * Update adapter image data or change the drawer header to say there are no images
     */
    private void handleDataChange(List<Bitmap> data) {
        PlacesImageAdapter adapter = (PlacesImageAdapter) mRecyclerView.getAdapter();
        adapter.updateData(data);
        adapter.notifyDataSetChanged();
        if (data == null || data.size() == 0)
            mHeading.setText(R.string.no_place_images);
    }

    /**
     * This adapter shows images with place photos
     */
    public class PlacesImageAdapter extends RecyclerView.Adapter<PlacesImageAdapter.ItemViewHolder> {

        private List<Bitmap> dataSource;

        PlacesImageAdapter(List<Bitmap> dataArgs) {
            dataSource = dataArgs;
        }

        void updateData(List<Bitmap> dataArgs) {
            dataSource = dataArgs;
        }

        @NonNull
        @Override
        public PlacesImageAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PlacesImageAdapter.ItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_places_list, parent, false));
        }

        /**
         * Display images; the image may be null if it is still loading
         */
        @Override
        public void onBindViewHolder(@NonNull final PlacesImageAdapter.ItemViewHolder holder, int position) {
            Bitmap photo = dataSource.get(position);
            if (photo != null) holder.mImage.setImageBitmap(photo);
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private final ImageView mImage;

            ItemViewHolder(View v) {
                super(v);
                mImage = v.findViewById(R.id.place_image);
                mImage.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
            }
        }
    }
}