package io.github.nkrusch.spacelaunchone.features.pads;

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
import io.github.nkrusch.spacelaunchone.app.OnItemListener;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.Pad;


/**
 * This adapter renders list of launchpads
 */
public class PadsAdapter extends RecyclerView.Adapter<PadsAdapter.ItemViewHolder> {

    private List<Pad> dataSource;
    private OnItemListener mItemClickListener;

    PadsAdapter(List<Pad> dataArgs) {
        updateData(dataArgs);
    }

    public void updateData(List<Pad> dataArgs) {
        dataSource = dataArgs;
    }

    /**
     * bind onclick listener to handle adapter item clicks
     */
    void SetOnItemClickListener(final OnItemListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pad, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final PadsAdapter.ItemViewHolder holder, int position) {

        Pad item = dataSource.get(position);
        final Context context = holder.mImageView.getContext();

        holder.mTextView.setText(Utilities.getLocationShortName(item.getName()));
        holder.mSubText1.setText(item.isRetired() ? "Retired" : "Active");
        holder.mNumber.setText(String.format(Locale.getDefault(), "%02d", position + 1));
        holder.mImageView.setImageResource(R.drawable.ic_map_marker);
        holder.mImageView.setContentDescription(item.getName());
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
                Pad item = dataSource.get(getAdapterPosition());
                if (item != null) mItemClickListener.onItemClick(item.getPid(), item.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
