package io.github.nkrusch.spacelaunchone.features.launches;

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
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.List;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import io.github.nkrusch.spacelaunchone.features.DetailActivity;
import local.Launch;
import viewmodels.ILaunchesViewModel;

/**
 * This is a base class for a fragment that contains
 * list of launches. This fragment takes care of initializing and
 * saving state of the recyclerview.
 */
abstract class LaunchRecyclerView<S extends AndroidViewModel & ILaunchesViewModel>
        extends RecyclerViewFragment
        implements IListClickHandler {

    private ListAdapter.OnItemClickListener mCustomHandler;
    private LinearLayout mEmptyState;
    private boolean customFirstItem;

    abstract Class<S> getType();

    abstract boolean showNextLaunch();

    /**
     * This method binds viewmodel observer.
     * When observer detects a change it calls {@link LaunchRecyclerView<Launch>{@link #handleDataChange}}
     */
    protected void setupViewModel() {
        if (getActivity() != null) {
            S vm = ViewModelProviders.of(getActivity()).get(getType());
            vm.getLaunches().observe(getActivity(), new Observer<List<Launch>>() {
                @Override
                public void onChanged(@Nullable List<Launch> launches) {
                    handleDataChange(launches);
                }
            });
        }
    }

    /**
     * When user clicks on recyclerview items launch details view
     */
    ListAdapter.OnItemClickListener onItemClick() {
        return new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id, String name) {
                startActivity(DetailActivity.launchDetails(getContext(), id, name));
            }
        };
    }

    /**
     * Override the default click handler
     */
    public void setOnItemClickHandler(ListAdapter.OnItemClickListener handler) {
        mCustomHandler = handler;
    }

    /**
     * When viewmodel state changes, update the adapter
     */
    private void handleDataChange(@Nullable List<Launch> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            ListAdapter adapter = (ListAdapter) mRecyclerView.getAdapter();
            if (customFirstItem && entries.get(0) != null)
                entries.add(0, null);
            adapter.updateData(entries);
            adapter.notifyDataSetChanged();
        } else {
            mRecyclerView.setVisibility(View.GONE);
            mEmptyState.setVisibility(View.VISIBLE);
        }
    }

    /**
     * initialize recyclerview and bind adapter; bind item click listener; restore previous recyclerview state (if any)
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        customFirstItem = getResources().getBoolean(R.bool.is_large_device) && showNextLaunch();
        int columns = getResources().getInteger(R.integer.list_column_count);

        List<Launch> data = new LinkedList<>();
        ListAdapter la = new ListAdapter(data, customFirstItem);
        la.SetOnItemClickListener(mCustomHandler == null ? this.onItemClick() : mCustomHandler);
        GridLayoutManager glm = new GridLayoutManager(getContext(), columns);

        if (customFirstItem) glm.setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return position == 0 ? 2 : 1;
                    }
                }
        );

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(la);
        mEmptyState = view.findViewById(R.id.empty_state);
        restoreRecyclerViewState(savedInstanceState);
        return view;
    }
}
