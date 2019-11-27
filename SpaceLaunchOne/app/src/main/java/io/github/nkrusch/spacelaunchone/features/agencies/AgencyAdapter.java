package io.github.nkrusch.spacelaunchone.features.agencies;

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
import local.AgencyLookup;


/**
 * This adapter renders list of launches
 */
public class AgencyAdapter extends RecyclerView.Adapter<AgencyAdapter.ItemViewHolder> {

    private List<AgencyLookup> dataSource;
    private OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int id, String name);
    }

    AgencyAdapter(List<AgencyLookup> dataArgs) {
        updateData(dataArgs);
    }

    public void updateData(List<AgencyLookup> dataArgs) {
        dataSource = dataArgs;
    }


    /**
     * bind onclick listener to handle adapter item clicks
     *
     * @param mItemClickListener call this method to override the default click handler which
     *                           is to launch details activity on list item click
     */
    void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_agency, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final AgencyAdapter.ItemViewHolder holder, int position) {

        AgencyLookup item = dataSource.get(position);
        final Context context = holder.mImageView.getContext();

        holder.mTextView.setText(item.getName());
        holder.mSubText1.setText(item.getAgencyCountryCode());
        holder.mNumber.setText(String.format(Locale.getDefault(), "%02d", position + 1));

        int imgRes = Utilities.countryIcon(item.getAgencyCountryCode());
        holder.mImageView.setImageResource(imgRes);
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
                AgencyLookup item = dataSource.get(getAdapterPosition());
                if (item != null) mItemClickListener.onItemClick(item.getId(), item.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
