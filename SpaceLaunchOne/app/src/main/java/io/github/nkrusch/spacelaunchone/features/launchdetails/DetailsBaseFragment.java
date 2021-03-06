package io.github.nkrusch.spacelaunchone.features.launchdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.LaunchDetails;
import viewmodels.LaunchDetailsViewModel;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

abstract class DetailsBaseFragment extends Fragment {

    String none;
    String unknown;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        none = getString(R.string.none);
        unknown = getString(R.string.unknown);
        if (getActivity() == null) return;
        new ViewModelProvider(getActivity())
                .get(LaunchDetailsViewModel.class)
                .get().observe(this, result -> {
            if (result != null) PopulateViews(result);
        });
    }

    protected abstract void PopulateViews(LaunchDetails launch);

    String coalesce(String... values) {
        return Utilities.coalesce(values);
    }
}

/**
 * Base class for fragment with horizontally scrolling recycler view and bullets
 *
 * @param <S> adapter data type
 * @param <T> adapter type
 */
abstract class HorizontalRecyclerViewFragment<T extends RecyclerView.Adapter<?> & BaseRecyclerViewAdapter<S>, S> extends DetailsBaseFragment {

    private final String EXTRA_RV_STATE = "recyclerview_state";
    private BaseRecyclerViewAdapter<S> mAdapter;
    private RecyclerView.SmoothScroller smoothScroller;
    private RecyclerView mRecyclerView;
    private LinearLayout mBullets;
    private TextView mBullet1;
    private TextView mBullet2;
    private TextView mBullet3;
    private TextView mBullet4;
    private TextView mBullet5;

    /**
     * return number of items per page; if not using bullets this value does not matter
     */
    abstract int getPageSize();

    abstract T getAdapter();

    abstract int layoutRes();

    void setGridLayoutManager() {
        final GridLayoutManager lm = new GridLayoutManager(getContext(), getPageSize(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(lm);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutRes(), container, false);

        //noinspection ConstantConditions
        smoothScroller = new LinearSmoothScroller(getActivity()) {
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mAdapter = getAdapter();
        setGridLayoutManager();
        mRecyclerView.setAdapter((RecyclerView.Adapter<?>) mAdapter);
        mRecyclerView.addOnScrollListener(scrollHandler());
        mBullets = view.findViewById(R.id.bullets);
        mBullet1 = view.findViewById(R.id.bullet_1);
        mBullet2 = view.findViewById(R.id.bullet_2);
        mBullet3 = view.findViewById(R.id.bullet_3);
        mBullet4 = view.findViewById(R.id.bullet_4);
        mBullet5 = view.findViewById(R.id.bullet_5);

        if (savedInstanceState != null && savedInstanceState.containsKey(EXTRA_RV_STATE))
            mRecyclerView.scrollToPosition(savedInstanceState.getInt(EXTRA_RV_STATE));

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        int scrollPosition = 0;
        if (mRecyclerView.getLayoutManager() != null) {
            GridLayoutManager lm =
                    ((GridLayoutManager) mRecyclerView.getLayoutManager());
            scrollPosition = lm.findFirstCompletelyVisibleItemPosition();
        }
        outState.putInt(EXTRA_RV_STATE, scrollPosition);
        super.onSaveInstanceState(outState);
    }

    private RecyclerView.OnScrollListener scrollHandler() {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                GridLayoutManager lm = ((GridLayoutManager) mRecyclerView.getLayoutManager());
                if (lm != null) {
                    setupBullets(lm.findFirstVisibleItemPosition());
                }
            }
        };
    }

    private void setupBullets(int selected) {
        if (mBullets == null) return;
        final double pageSize = getPageSize();
        int pageCount = (int) Math.ceil((float)
                Objects.requireNonNull(mRecyclerView.getAdapter()).getItemCount() / pageSize);
        final int total = Utilities.clamp(0, 5, pageCount);
        TextView[] bullets = new TextView[]{mBullet1, mBullet2, mBullet3, mBullet4, mBullet5};
        int inactive = getResources().getColor(R.color.bullet_inactive);
        int active = getResources().getColor(R.color.bullet_active);
        int activeBullet = Math.min(bullets.length - 1,
                Math.max(0, (int) Math.floor(selected / pageSize)));

        mBullets.setVisibility(total > 1 ? VISIBLE : GONE);
        for (int n = 0; n < bullets.length; n++) {
            bullets[n].setVisibility(total > 1 && n < total ? VISIBLE : GONE);
            bullets[n].setTextColor(n == activeBullet ? active : inactive);
            final int currentIndex = n;
            if (!bullets[n].hasOnClickListeners())
                bullets[n].setOnClickListener(v -> {
                    smoothScroller.setTargetPosition((currentIndex * (int) pageSize));
                    (Objects.requireNonNull(mRecyclerView.getLayoutManager()))
                            .startSmoothScroll(smoothScroller);
                    setupBullets(currentIndex);
                });
        }
    }

    void handleDataChange(@Nullable List<S> entries) {
        if (mRecyclerView == null || mAdapter == null) return;
        boolean hasEntries = entries != null && entries.size() > 0;
        if (hasEntries) {
            mRecyclerView.setVisibility(VISIBLE);
            mAdapter.updateData(entries);
            ((RecyclerView.Adapter<?>) mAdapter).notifyDataSetChanged();
        } else {
            mRecyclerView.setVisibility(GONE);
        }
        setupBullets(0);
    }
}

interface BaseRecyclerViewAdapter<S> {
    void updateData(List<S> entries);
}