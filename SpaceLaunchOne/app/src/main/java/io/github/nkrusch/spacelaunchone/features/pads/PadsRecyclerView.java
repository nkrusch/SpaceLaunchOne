package io.github.nkrusch.spacelaunchone.features.pads;

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
import local.Pad;
import viewmodels.LocationDetailsViewModel;


public class PadsRecyclerView extends RecyclerViewFragment {

    public static PadsRecyclerView newInstance() {
        return new PadsRecyclerView();
    }

    private LinearLayout mEmptyState;

    protected void setupViewModel() {
        if (getActivity() != null) {
            LocationDetailsViewModel vm = new ViewModelProvider(getActivity())
                    .get(LocationDetailsViewModel.class);
            vm.get().observe(getActivity(), locationDetails -> {
                if (locationDetails != null && locationDetails.getLaunches() != null)
                    handleDataChange(locationDetails.getPads());
            });
        }
    }

    /**
     * When user clicks on pad item in a list
     */
    private OnItemListener onItemClick() {
        return (id, name) -> {
            // do something on pad click
        };
    }

    /**
     * When viewModel state changes, update the adapter
     */
    private void handleDataChange(@Nullable List<Pad> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            PadsAdapter adapter = (PadsAdapter) mRecyclerView.getAdapter();
            if(adapter!=null) {
                adapter.updateData(entries);
                adapter.notifyDataSetChanged();
            }
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

        List<Pad> data = new LinkedList<>();
        PadsAdapter la = new PadsAdapter(data);
        la.SetOnItemClickListener(this.onItemClick());
        GridLayoutManager glm = new GridLayoutManager(getContext(), columns);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(la);
        mEmptyState = view.findViewById(R.id.empty_state);
        TextView mEmptyStateText = view.findViewById(R.id.list_empty_state_text);
        mEmptyStateText.setText(R.string.pads_empty_state);
        restoreRecyclerViewState(savedInstanceState);
        return view;
    }
}
