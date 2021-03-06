package io.github.nkrusch.spacelaunchone.features.launches;

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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.OnItemClickListener;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import io.github.nkrusch.spacelaunchone.features.launchdetails.DetailsLaunchActivity;
import local.Launch;
import viewmodels.AgencyDetailsViewModel;


public class AgencyLaunchRecyclerView extends RecyclerViewFragment{

    private LinearLayout mEmptyState;

    public static Fragment newInstance() {
        return new AgencyLaunchRecyclerView();
    }

    protected void setupViewModel() {
        if (getActivity() != null) {
            AgencyDetailsViewModel vm = new ViewModelProvider(getActivity())
                    .get(AgencyDetailsViewModel.class);
            vm.get().observe(getActivity(), locationDetails -> {
                if(locationDetails!=null && locationDetails.getLaunches()!=null)
                    handleDataChange(locationDetails.getLaunches());
            });
        }
    }

    /**
     * When user clicks on recyclerview items launch details view
     */
    private OnItemClickListener onItemClick() {
        return (id, name) -> startActivity(DetailsLaunchActivity
                .launchDetails(getContext(), id, name));
    }

    /**
     * When viewModel state changes, update the adapter
     */
    @SuppressWarnings("unchecked")
    private void handleDataChange(@Nullable List<Launch> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            ListAdapter<Launch> adapter = (ListAdapter<Launch>) mRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.updateData(entries);
                adapter.notifyDataSetChanged();
            }
        } else {
            mRecyclerView.setVisibility(View.GONE);
            mEmptyState.setVisibility(View.VISIBLE);
        }
    }

    /**
     * initialize recyclerview and bind adapter; bind item click listener;
     * restore previous recyclerview state (if any)
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        int columns = getResources().getInteger(R.integer.list_column_count);

        List<Launch> data = new LinkedList<>();
        ListAdapter<Launch> la = new ListAdapter<>(data, false);
        la.SetOnItemClickListener(this.onItemClick());
        GridLayoutManager glm = new GridLayoutManager(getContext(), columns);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(la);
        mEmptyState = view.findViewById(R.id.empty_state);
        TextView mEmptyStateText = view.findViewById(R.id.list_empty_state_text);
        mEmptyStateText.setText(R.string.agency_launches_empty_state);
        restoreRecyclerViewState(savedInstanceState);
        return view;
    }
}
