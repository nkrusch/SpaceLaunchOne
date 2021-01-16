package io.github.nkrusch.spacelaunchone.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * This is an abstract base class for a fragment that contains a recyclerview,
 * users viewModel to load its data and needs to restore it's state over fragment lifecycle
 */
public abstract class RecyclerViewFragment extends Fragment {

    private final String EXTRA_RV_STATE = "recyclerview_state";
    protected RecyclerView mRecyclerView;

    protected abstract void setupViewModel();

    @Override
    public void onStart() {
        super.onStart();
        setupViewModel();
    }

    protected void restoreRecyclerViewState(Bundle savedInstanceState) {
        if (savedInstanceState != null && mRecyclerView != null && savedInstanceState.containsKey(EXTRA_RV_STATE))
            mRecyclerView.scrollToPosition(savedInstanceState.getInt(EXTRA_RV_STATE));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        int scrollPosition = 0;
        if (mRecyclerView.getLayoutManager() != null) {
            LinearLayoutManager lm =
                    ((LinearLayoutManager) mRecyclerView.getLayoutManager());
            scrollPosition = lm.findFirstCompletelyVisibleItemPosition();
        }
        outState.putInt(EXTRA_RV_STATE, scrollPosition);
        super.onSaveInstanceState(outState);
    }
}
