package io.github.nkrusch.spacelaunchone.features.filters;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.LinkedList;
import java.util.List;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import local.IFilter;
import viewmodels.IFilterViewModel;

@SuppressWarnings("SpellCheckingInspection")
abstract class FilterRecyclerView<T extends IFilter, S extends AndroidViewModel & IFilterViewModel> extends RecyclerViewFragment {

    private S vm;

    abstract Class<S> getType();

    abstract int columnCount();

    @Override
    protected void setupViewModel() {
        if (getActivity() != null) {
            vm = ViewModelProviders.of(getActivity()).get(getType());
            vm.getAll().observe(getActivity(), new Observer<List<T>>() {
                @Override
                public void onChanged(@Nullable List<T> launches) {
                    handleDataChange(launches);
                }
            });
        }
    }

    private FilterAdapter.OnItemClickListener onItemClick() {
        return new FilterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(IFilter item) {
                vm.toggle(item);
            }
        };
    }

    private View.OnClickListener onCheckAllClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean value = ((CheckBox) v).isChecked();
                vm.setAll(value);
            }
        };
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        FilterAdapter la = new FilterAdapter(new LinkedList<>());
        la.SetOnItemClickListener(onItemClick());

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), columnCount()));
        mRecyclerView.setAdapter(la);
        restoreRecyclerViewState(savedInstanceState);
        view.findViewById(R.id.check_all).setOnClickListener(onCheckAllClick());
        return view;
    }

    private void handleDataChange(@Nullable List<T> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mRecyclerView.setVisibility(View.VISIBLE);
            FilterAdapter adapter = (FilterAdapter) mRecyclerView.getAdapter();
            adapter.updateData(entries);
            adapter.notifyDataSetChanged();
        } else {
            mRecyclerView.setVisibility(View.GONE);
        }
    }
}
