package io.github.nkrusch.spacelaunchone.features.agencies;

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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.OnItemListener;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import local.Agency;
import viewmodels.AgencyListViewModel;

public class AgencyRecyclerView extends RecyclerViewFragment {

    private LinearLayout mEmptyState;

    public static AgencyRecyclerView newInstance() {
        return new AgencyRecyclerView();
    }

    protected void setupViewModel() {
        if (getActivity() != null) {
            AgencyListViewModel vm = new ViewModelProvider(getActivity()).get(AgencyListViewModel.class);
            vm.getAll().observe(getActivity(), this::handleDataChange);
        }
    }

    OnItemListener onItemClick() {
        return (id, name) -> startActivity(DetailsAgencyActivity.getIntent(getContext(), id, name));
    }

    /**
     * When viewModel state changes, update the adapter
     */
    private void handleDataChange(@Nullable List<Agency> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            AgencyAdapter adapter = (AgencyAdapter) mRecyclerView.getAdapter();
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

        List<Agency> data = new LinkedList<>();
        AgencyAdapter la = new AgencyAdapter(data);
        la.SetOnItemClickListener(this.onItemClick());
        GridLayoutManager glm = new GridLayoutManager(getContext(), columns);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(la);
        mEmptyState = view.findViewById(R.id.empty_state);
        TextView mEmptyStateText = view.findViewById(R.id.list_empty_state_text);
        mEmptyStateText.setText(R.string.agency_empty_state);
        restoreRecyclerViewState(savedInstanceState);
        return view;
    }
}
