package io.github.nkrusch.spacelaunchone.features.locations.details;

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
import local.Agency;


/**
 * This adapter renders list of launches
 */
public class LocationAgencyAdapter extends RecyclerView.Adapter<LocationAgencyAdapter.ItemViewHolder> {

    private List<Agency> dataSource;
    private OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int id, String name);
    }

    public LocationAgencyAdapter(List<Agency> dataArgs) {
        updateData(dataArgs);
    }

    public void updateData(List<Agency> dataArgs) {
        dataSource = dataArgs;
    }

    /**
     * bind onclick listener to handle adapter item clicks
     *
     * @param mItemClickListener call this method to override the default click handler which
     *                           is to launch details activity on list item click
     */
    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_location_agency, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final LocationAgencyAdapter.ItemViewHolder holder, int position) {
        final Agency item = dataSource.get(position);
        holder.mTextView.setText(String.format(Locale.getDefault(), "%s%s",
                item.getName(), item.getAbbrev() == null || item.getName().equals(item.getAbbrev()) ?
                        "" : " (" + item.getAbbrev() + ")"));
        if (item.getIslsp() == 1) {
            holder.mSubText1.setText(String.format("%s · %s", item.getAgencyType(),
                    holder.mImageView.getContext().getResources().getString(R.string.label_is_lsp)));
        } else holder.mSubText1.setText(item.getAgencyType());
        holder.mNumber.setText(String.format(Locale.getDefault(), "%02d", position + 1));
        holder.mImageView.setVisibility(View.VISIBLE);
        holder.mImageView.setImageResource(Utilities.countryIcon(item.getCountryCode()));
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
                Agency item = dataSource.get(getAdapterPosition());
                if (item != null) mItemClickListener.onItemClick(item.getAid(), item.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
