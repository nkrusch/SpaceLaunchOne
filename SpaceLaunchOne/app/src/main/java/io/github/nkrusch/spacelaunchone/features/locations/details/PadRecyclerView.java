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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.RecyclerViewFragment;
import io.github.nkrusch.spacelaunchone.features.launches.ListAdapter;
import io.github.nkrusch.spacelaunchone.features.locations.LocationAdapter;
import local.Pad;
import viewmodels.LocationDetailsViewModel;


public class PadRecyclerView extends RecyclerViewFragment  implements IListClickHandler {

    public static PadRecyclerView newInstance() {
        return new PadRecyclerView();
    }

    private LinearLayout mEmptyState;
    private TextView mEmptyStateText;

    protected void setupViewModel() {
        if (getActivity() != null) {
            LocationDetailsViewModel vm = ViewModelProviders.of(getActivity())
                    .get(LocationDetailsViewModel.class);
            vm.get().observe(getActivity(), new Observer<local.LocationDetails>() {
                @Override
                public void onChanged(local.LocationDetails locationDetails) {
                    if(locationDetails!=null && locationDetails.getLaunches()!=null)
                        handleDataChange(locationDetails.getPads());
                }
            });
        }
    }

    /**
     * When user clicks on recyclerview items launch details view
     */
    PadAdapter.OnItemClickListener onItemClick() {
        return new PadAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int id, String name) {
                // do something on pad click
            }
        };
    }

    /**
     * When viewmodel state changes, update the adapter
     */
    private void handleDataChange(@Nullable List<Pad> entries) {
        if (mRecyclerView == null || entries == null) return;
        boolean hasEntries = entries.size() > 0;
        if (hasEntries) {
            mEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            PadAdapter adapter = (PadAdapter) mRecyclerView.getAdapter();
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

        List<Pad> data = new LinkedList<>();
        PadAdapter la = new PadAdapter(data);
        la.SetOnItemClickListener(this.onItemClick());
        GridLayoutManager glm = new GridLayoutManager(getContext(), columns);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setAdapter(la);
        mEmptyState = view.findViewById(R.id.empty_state);
        mEmptyStateText = view.findViewById(R.id.list_empty_state_text);
        mEmptyStateText.setText(R.string.pads_empty_state);
        restoreRecyclerViewState(savedInstanceState);
        return view;
    }

    @Override
    public void setOnItemClickHandler(ListAdapter.OnItemClickListener handler) {

    }
}
