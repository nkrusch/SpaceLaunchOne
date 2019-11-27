package io.github.nkrusch.spacelaunchone.features.launchpads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.LocationLookup;


/**
 * This adapter renders list of launchpads
 */
public class PadAdapter extends RecyclerView.Adapter<PadAdapter.ItemViewHolder> {

    private List<LocationLookup> dataSource;
    private OnItemClickListener mItemClickListener;
    private int thumbnailWidth;

    public interface OnItemClickListener {
        void onItemClick(int id, String name);
    }

    PadAdapter(List<LocationLookup> dataArgs) {
        updateData(dataArgs);
    }

    public void updateData(List<LocationLookup> dataArgs) {
        dataSource = dataArgs;
    }

    /**
     * bind onclick listener to handle adapter item clicks
     */
    void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        thumbnailWidth = Utilities.dpToPixel(parent.getContext().getResources().getInteger(
                R.integer.list_image_width_int), parent.getContext().getResources());
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_location, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PadAdapter.ItemViewHolder holder, int position) {

        LocationLookup item = dataSource.get(position);
        final Context context = holder.mImageView.getContext();
        holder.mTextView.setText(item.getShortName());
        holder.mSubText1.setText(item.getPlaceName());
        holder.mNumber.setText(String.format(Locale.getDefault(), "%02d", position + 1));

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mImageView;
        private final TextView mTextView;
        private final TextView mSubText1;
        private final TextView mNumber;


        ItemViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.thumbnail);
            mTextView = v.findViewById(R.id.title);
            mSubText1 = v.findViewById(R.id.sub_line_1);
            mNumber = v.findViewById(R.id.list_number);
            ConstraintLayout layout = (v.findViewById(R.id.list_item_container));
            if (layout != null) layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            try {
                LocationLookup item = dataSource.get(getAdapterPosition());
                if (item != null) mItemClickListener.onItemClick(item.getId(), item.getShortName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
