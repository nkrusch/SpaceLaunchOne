package io.github.nkrusch.spacelaunchone.features.locations.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import io.github.nkrusch.spacelaunchone.features.DetailActivity;
import io.github.nkrusch.spacelaunchone.features.launches.ListAdapter;
import local.Launch;
import local.LocationDetails;
import viewmodels.LocationDetailsViewModel;

/**
 * This is a base class for a fragment that contains
 * list of launches. This fragment takes care of initializing and
 * saving state of the recyclerview.
 */
public class LocationLaunchRecyclerView extends RecyclerViewFragment implements IListClickHandler {

    private ListAdapter.OnItemClickListener mCustomHandler;
    private LinearLayout mEmptyState;
    private TextView mEmptyStateText;

    public static Fragment newInstance() {
        return new LocationLaunchRecyclerView();
    }

    protected void setupViewModel() {
        if (getActivity() != null) {
            LocationDetailsViewModel vm = ViewModelProviders.of(getActivity()).get(LocationDetailsViewModel.class);
            vm.get().observe(getActivity(), new Observer<LocationDetails>() {
                @Override
                public void onChanged(LocationDetails locationDetails) {
                    if(locationDetails!=null && locationDetails.getLaunches()!=null)
                        handleDataChange(locationDetails.getLaunches());
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
        int columns = getResources().getInteger(R.integer.list_column_count);

        List<Launch> data = new LinkedList<>();
        ListAdapter la = new ListAdapter(data, false);
        la.SetOnItemClickListener(mCustomHandler == null ? this.onItemClick() : mCustomHandler);
        GridLayoutManager glm = new GridLayoutManager(getContext(), columns);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(la);
        mEmptyState = view.findViewById(R.id.empty_state);
        mEmptyStateText = view.findViewById(R.id.list_empty_state_text);
        mEmptyStateText.setText(R.string.launches_empty_state);
        restoreRecyclerViewState(savedInstanceState);
        return view;
    }
}