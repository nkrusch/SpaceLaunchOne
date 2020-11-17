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
import io.github.nkrusch.spacelaunchone.app.AppImage;
import io.github.nkrusch.spacelaunchone.app.OnItemListener;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.Agency;


/**
 * This adapter renders list of launches
 */
public class AgencyAdapter extends RecyclerView.Adapter<AgencyAdapter.ItemViewHolder> {

    private List<Agency> dataSource;
    private OnItemListener mItemClickListener;

    public AgencyAdapter(List<Agency> dataArgs) {
        updateData(dataArgs);
    }

    public void updateData(List<Agency> dataArgs) {
        dataSource = dataArgs;
    }

    public void SetOnItemClickListener(final OnItemListener mItemClickListener) {
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

        final Agency item = dataSource.get(position);
        final Context context = holder.mImageView.getContext();

        holder.mTextView.setText(item.getAbbrev() == null ? item.getName() : String
                .format(Locale.getDefault(), "%s (%s)", item.getName(), item.getAbbrev()));
        holder.mSubText1.setText(item.getIslsp() == 1 ? String.format("%s · %s", item.getAgencyType(),
                holder.mImageView.getContext().getResources().getString(R.string.label_is_lsp)) : item.getAgencyType());
        holder.mSubText2.setText(Utilities.getAgencyCountries(item.getCountryCode(), 5, context.getResources()));
        holder.mNumber.setText(String.format(Locale.getDefault(), "%02d", position + 1));

        holder.mImageView.setVisibility(View.VISIBLE);
        holder.mImageView.setContentDescription(item.getName());
        AppImage.LoadImageFromURL(item.getImage(), holder.mImageView, R.drawable.ic_office_building);
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

        ItemViewHolder(View v) {
            super(v);

            mImageView = v.findViewById(R.id.thumbnail);
            mTextView = v.findViewById(R.id.title);
            mSubText1 = v.findViewById(R.id.sub_line_1);
            mSubText2 = v.findViewById(R.id.sub_line_2);
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
