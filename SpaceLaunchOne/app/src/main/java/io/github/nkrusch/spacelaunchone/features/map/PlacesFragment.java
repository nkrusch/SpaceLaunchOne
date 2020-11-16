package io.github.nkrusch.spacelaunchone.features.map;

// @Deprecated
//public class PlacesFragment extends BottomSheetDialogFragment {
//
//    private final String EXTRA_RV_STATE = "recyclerview_state";
//    private static final String EXTRA_PLACE_NAME = "place_name";
//    private static final String EXTRA_PLACE_ID = "place_id";
//    private GeoDataClient mGeoDataClient;
//    private String placeId;
//    private String placeName;
//    private RecyclerView mRecyclerView;
//    private TextView mHeading;
//
//    /**
//     * @param id   placeId of interest
//     * @param name place name if known (this fragment will recover name if not known by parent)
//     */
//    public static PlacesFragment newInstance(String id, String name) {
//        PlacesFragment f = new PlacesFragment();
//        Bundle args = new Bundle();
//        args.putString(EXTRA_PLACE_ID, id);
//        args.putString(EXTRA_PLACE_NAME, name);
//        f.setArguments(args);
//        return f;
//    }
//
//    /**
//     * Parent of this fragment must provide the placeId of interest
//     */
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            placeId = bundle.getString(EXTRA_PLACE_ID);
//            placeName = bundle.getString(EXTRA_PLACE_NAME);
//        }
//    }
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Dialog psf = super.onCreateDialog(savedInstanceState);
//        psf.setOnShowListener(dialog -> {
//            BottomSheetDialog d = (BottomSheetDialog) dialog;
//            FrameLayout bottomSheet = d.findViewById(R.id.design_bottom_sheet);
//            if (bottomSheet != null) {
//                BottomSheetBehavior.from(bottomSheet)
//                        .setState(BottomSheetBehavior.STATE_EXPANDED);
//            }
//        });
//        return psf;
//    }
//
//    /**
//     * Setup RecyclerView and initialize place lookup
//     */
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_places, container, false);
//        mHeading = view.findViewById(R.id.places_heading);
//        if (placeName != null && !placeName.isEmpty()) mHeading.setText(placeName);
//
//        mRecyclerView = view.findViewById(R.id.recyclerView);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1,
//                LinearLayoutManager.HORIZONTAL, false));
//        mRecyclerView.setAdapter(new PlacesImageAdapter(new LinkedList()));
//        if (savedInstanceState != null && savedInstanceState.containsKey(EXTRA_RV_STATE))
//            mRecyclerView.scrollToPosition(savedInstanceState.getInt(EXTRA_RV_STATE));
//
//        placeLookup();
//        return view;
//    }
//
//    /**
//     * Restore RecyclerView state
//     */
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        int scrollPosition = 0;
//        if (mRecyclerView.getLayoutManager() != null) {
//            LinearLayoutManager lm =
//                    ((LinearLayoutManager) mRecyclerView.getLayoutManager());
//            scrollPosition = lm.findFirstCompletelyVisibleItemPosition();
//        }
//        outState.putInt(EXTRA_RV_STATE, scrollPosition);
//        super.onSaveInstanceState(outState);
//    }
//
//    /**
//     * Check that provided placeId exists; if true try loading images for it
//     */
//    private void placeLookup() {
//        if (getContext() == null) return;
//        mGeoDataClient = Places.getGeoDataClient(getContext());
//        mGeoDataClient.getPlaceById(placeId).addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                PlaceBufferResponse places = task.getResult();
//                if (places == null) return;
//                Place myPlace = places.get(0);
//                mHeading.setText(myPlace.getName());
//                getPhotos(placeId);
//                places.release();
//            } else {
//                mHeading.setText(R.string.place_not_found);
//            }
//        });
//    }
//
//    /**
//     * Load images about selected place
//     * This method first gets image metadata to find out if there are images;
//     * If there are some images, first update adapter to show placeholder images until
//     * image loading has completed. Once image bitmaps have loaded update the adapter to show images.
//     */
//    private void getPhotos(final String placeId) {
//        final Task<PlacePhotoMetadataResponse> photoMetadataResponse = mGeoDataClient.getPlacePhotos(placeId);
//        photoMetadataResponse.addOnCompleteListener(task -> {
//            PlacePhotoMetadataResponse photos = task.getResult();
//            if (photos == null) return;
//            final PlacePhotoMetadataBuffer photoMetadataBuffer = photos.getPhotoMetadata();
//            final List<Bitmap> tmp = new LinkedList();
//            final List<Bitmap> images = new LinkedList();
//            final List<Integer> progressCounter = new LinkedList<>();
//
//            for (PlacePhotoMetadata meta : photoMetadataBuffer) {
//                tmp.add(null);
//                final Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(meta);
//                photoResponse.addOnCompleteListener(task1 -> {
//                    PlacePhotoResponse photo = task1.getResult();
//                    if (task1.isSuccessful() && photo != null)
//                        images.add(photo.getBitmap());
//                    progressCounter.add(1);
//                    if (progressCounter.size() == photoMetadataBuffer.getCount())
//                        handleDataChange(images);
//                });
//            }
//            handleDataChange(tmp);
//        });
//    }
//
//    /**
//     * Update adapter image data or change the drawer header to say there are no images
//     */
//    private void handleDataChange(List<Bitmap> data) {
//        PlacesImageAdapter adapter = (PlacesImageAdapter) mRecyclerView.getAdapter();
//        if (adapter != null) {
//            adapter.updateData(data);
//            adapter.notifyDataSetChanged();
//        }
//        if (data == null || data.size() == 0)
//            mHeading.setText(R.string.no_place_images);
//    }
//
//    /**
//     * This adapter shows images with place photos
//     */
//    public static class PlacesImageAdapter extends RecyclerView.Adapter<PlacesImageAdapter.ItemViewHolder> {
//
//        private List<Bitmap> dataSource;
//
//        PlacesImageAdapter(List<Bitmap> dataArgs) {
//            dataSource = dataArgs;
//        }
//
//        void updateData(List<Bitmap> dataArgs) {
//            dataSource = dataArgs;
//        }
//
//        @NonNull
//        @Override
//        public PlacesImageAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            return new ItemViewHolder(LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.item_places_list, parent, false));
//        }
//
//        /**
//         * Display images; the image may be null if it is still loading
//         */
//        @Override
//        public void onBindViewHolder(@NonNull final PlacesImageAdapter.ItemViewHolder holder, int position) {
//            Bitmap photo = dataSource.get(position);
//            if (photo != null) holder.mImage.setImageBitmap(photo);
//        }
//
//        @Override
//        public int getItemCount() {
//            return dataSource.size();
//        }
//
//        public static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//            private final ImageView mImage;
//
//            ItemViewHolder(View v) {
//                super(v);
//                mImage = v.findViewById(R.id.place_image);
//                mImage.setOnClickListener(this);
//            }
//
//            @Override
//            public void onClick(View v) {
//            }
//        }
//    }
//}