package io.github.nkrusch.spacelaunchone.features.missions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.OnItemClickListener;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.Mission;


/**
 * This adapter renders list of launchpads
 */
public class MissionsAdapter extends RecyclerView.Adapter<MissionsAdapter.ItemViewHolder> {

    private List<Mission> dataSource;
    private OnItemClickListener mItemClickListener;

    MissionsAdapter(List<Mission> dataArgs) {
        updateData(dataArgs);
    }

    public void updateData(List<Mission> dataArgs) {
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
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mission, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MissionsAdapter.ItemViewHolder holder, int position) {

        Mission item = dataSource.get(position);
        final Context context = holder.mImageView.getContext();
        holder.mTextView.setText(Utilities.getLocationShortName(item.getName()));
        holder.mSubText1.setText(String.format("%s %s", item.getCategory(), item.getIcon()));
        holder.mNumber.setText(String.format(Locale.getDefault(), "%02d", position + 1));

        holder.mImageView.setVisibility(View.VISIBLE);
        Picasso.with(context).load(item.getMissionImage()).into(holder.mImageView, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
                holder.mImageView.setImageResource(R.drawable.ic_information_outline);
            }
        });
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
                Mission item = dataSource.get(getAdapterPosition());
                if (item != null) mItemClickListener.onItemClick(item.getMid(), item.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
