package io.github.nkrusch.spacelaunchone.features.launches;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudinary.utils.StringUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.AppImage;
import io.github.nkrusch.spacelaunchone.app.OnItemClickListener;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.Launch;


/**
 * This adapter renders list of launches
 */
public class ListAdapter<T extends Launch> extends
        RecyclerView.Adapter<ListAdapter.ItemViewHolder> {

    private List<T> dataSource;
    private OnItemClickListener mItemClickListener;
    private int thumbnailWidth;
    private final boolean customFirstItem;
    private final int customFirstItemType = 1;

    public ListAdapter(List<T> dataArgs, boolean customFirstItem) {
        updateData(dataArgs);
        this.customFirstItem = customFirstItem;
    }

    public void updateData(List<T> dataArgs) {
        dataSource = dataArgs;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0 && customFirstItem) ? customFirstItemType : -1;
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
        thumbnailWidth = Utilities.dpToPixel(parent.getContext().getResources().getInteger(
                R.integer.list_image_width_int), parent.getContext().getResources());
        int layoutRes = (viewType == customFirstItemType ? R.layout.item_launch_first : R.layout.item_launch_list);
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ItemViewHolder holder, int position) {
        if (customFirstItem && position == 0) return;

        T item = dataSource.get(position);
        final Context context = holder.mImageView.getContext();
        String timeLabel = Utilities.timeLabel(item.getLaunchDateUTC());
        String timeDiff = Utilities.shortTimeDiff(item.getLaunchDateUTC(), context.getResources());

        holder.mTextView.setText(item.getName());
        holder.mSubText1.setText(String.format("%s · %s", timeLabel, timeDiff));
        holder.mSubText2.setText(Utilities.getLocationShortName(item.getLocationName()));
        holder.mNumber.setText(String.format(Locale.getDefault(), "%02d", position + 1));
        holder.mStatus.setText(context.getString(R.string.bullet));
        holder.mStatus.setTextColor(Color.parseColor(item.getStatusColor()));

        holder.mImageView.setVisibility(View.VISIBLE);
        holder.mImageView.setImageResource(R.drawable.ic_rocket_background);

        if (item.getImage() != null) {
            AppImage.LoadSquareImageFromURL(
                    item.getImage(),
                    thumbnailWidth,
                    holder.mImageView,
                    R.drawable.ic_rocket_background
            );
        }
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView mImageView;
        private final TextView mTextView;
        private final TextView mSubText1;
        private final TextView mSubText2;
        private final TextView mNumber;
        private final TextView mStatus;

        ItemViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.thumbnail);
            mTextView = v.findViewById(R.id.title);
            mSubText1 = v.findViewById(R.id.sub_line_1);
            mSubText2 = v.findViewById(R.id.sub_line_2);
            mNumber = v.findViewById(R.id.list_number);
            mStatus = v.findViewById(R.id.status);

            ConstraintLayout layout = (v.findViewById(R.id.list_item_container));
            if (layout != null) layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            try {
                T item = dataSource.get(getAdapterPosition());
                if (item != null) mItemClickListener.onItemClick(item.getId(), item.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
