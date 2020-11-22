package io.github.nkrusch.spacelaunchone.features.filters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import local.IFilter;
import viewmodels.IFilterViewModel;

abstract class FilterRecyclerView<T extends IFilter, S extends
        AndroidViewModel & IFilterViewModel<T>> extends RecyclerViewFragment {

    private S vm;

    abstract Class<S> getType();

    abstract int columnCount();

    @Override
    protected void setupViewModel() {
        if (getActivity() != null) {
            vm = new ViewModelProvider(getActivity()).get(getType());
            vm.getAll().observe(getActivity(), this::handleDataChange);
        }
    }

    private FilterAdapter.OnItemClickListener onItemClick() {
        return item -> vm.toggle(item);
    }

    private View.OnClickListener onCheckAllClick() {
        return v -> {
            boolean value = ((CheckBox) v).isChecked();
            vm.setAll(!value);
        };
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        FilterAdapter<T> la = new FilterAdapter<>(new LinkedList<>());
        la.SetOnItemClickListener(onItemClick());

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), columnCount()));
        mRecyclerView.setAdapter(la);
        restoreRecyclerViewState(savedInstanceState);
        view.findViewById(R.id.check_all).setOnClickListener(onCheckAllClick());
        return view;
    }

    @SuppressWarnings("unchecked")
    private void handleDataChange(@Nullable List<T> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mRecyclerView.setVisibility(View.VISIBLE);
            FilterAdapter<T> adapter = (FilterAdapter<T>) mRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.updateData(entries);
                adapter.notifyDataSetChanged();
            }
        } else {
            mRecyclerView.setVisibility(View.GONE);
        }
    }
}
