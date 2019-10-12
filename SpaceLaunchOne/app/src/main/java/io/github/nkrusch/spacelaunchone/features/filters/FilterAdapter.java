package io.github.nkrusch.spacelaunchone.features.filters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import io.github.nkrusch.spacelaunchone.R;
import local.IFilter;

public class FilterAdapter<T extends IFilter> extends RecyclerView.Adapter<FilterAdapter.ItemViewHolder> {

    private List<T> dataSource;
    private OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(IFilter item);
    }

    public FilterAdapter(List<T> dataArgs) {
        updateData(dataArgs);
    }

    public void updateData(List<T> dataArgs) {
        dataSource = dataArgs;
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filter_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final FilterAdapter.ItemViewHolder holder, int position) {
        IFilter item = dataSource.get(position);
        holder.mName.setText(item.getName());
        holder.mCheck.setChecked(item.isFiltered());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mName;
        private final CheckBox mCheck;

        ItemViewHolder(View v) {
            super(v);
            mName = v.findViewById(R.id.name);
            mCheck = v.findViewById(R.id.checkbox);
            mCheck.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            try {
                IFilter item = dataSource.get(getAdapterPosition());
                Log.d("FILTER", "fired click on item " + item.getName());
                mItemClickListener.onItemClick(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
