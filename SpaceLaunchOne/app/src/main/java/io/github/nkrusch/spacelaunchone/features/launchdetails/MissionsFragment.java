package io.github.nkrusch.spacelaunchone.features.launchdetails;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import io.github.nkrusch.spacelaunchone.BuildConfig;
import io.github.nkrusch.spacelaunchone.R;
import local.LaunchDetails;
import local.Mission;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class MissionsFragment extends HorizontalRecyclerViewFragment
        <MissionsFragment.MissionAdapter, Mission> {

    public MissionsFragment() {
    }

    @Override
    MissionAdapter getAdapter() {
        return new MissionAdapter(new LinkedList<Mission>());
    }

    @Override
    int layoutRes() {
        return R.layout.fragment_missions;
    }

    @Override
    int getPageSize() {
        return 1;
    }

    @Override
    protected void PopulateViews(LaunchDetails launch) {
        if (launch == null || launch.getMissions() == null) return;
        handleDataChange(launch.getMissions());
    }

    public class MissionAdapter
            extends RecyclerView.Adapter<MissionAdapter.ItemViewHolder>
            implements BaseRecyclerViewAdapter<Mission> {

        private List<Mission> dataSource;

        MissionAdapter(List<Mission> dataArgs) {
            dataSource = dataArgs;
        }

        @Override
        public void updateData(List<Mission> dataArgs) {
            dataSource = dataArgs;
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        @NonNull
        @Override
        public MissionAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MissionAdapter.ItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_mission_single, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final MissionAdapter.ItemViewHolder holder, int position) {
            Mission mission = dataSource.get(position);
            Resources res = holder.mMissionNo.getResources();
            holder.mMissionNo.setText(res.getQuantityString(R.plurals.mission_no, dataSource.size(),
                    dataSource.size() < 2 ? "" : position + 1, mission.getCategory()));
            holder.mCategory.setText(mission.getIcon());
            holder.mDescription.setText(mission.getDescription());
            final int missionTextLen = mission.getDescription().length();

            toggleExpandState(holder, missionTextLen);
            holder.mExpandButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.isExpanded = !holder.isExpanded;
                    toggleExpandState(holder, missionTextLen);
                    if (getActivity() != null) {
                        NestedScrollView mScrollView = getActivity().findViewById(R.id.scrollview);
                        if (mScrollView != null && !holder.isExpanded) {
                            int[] pos = new int[2];
                            (holder.mMissionNo).getLocationOnScreen(pos);
                            mScrollView.scrollTo(0, Math.max(400, pos[1]));
                        }
                    }
                }
            });
        }

        private void toggleExpandState(@NonNull final MissionAdapter.ItemViewHolder holder, int missionTextLen) {
            int TEXT_CLIP_LENGTH = BuildConfig.MissionTextClipLength;
            boolean showToggleButton = missionTextLen > TEXT_CLIP_LENGTH;
            holder.mExpandButton.setVisibility(showToggleButton ? VISIBLE : GONE);
            if (showToggleButton) {
                holder.mExpandButton.setText(holder.isExpanded ? R.string.show_less : R.string.show_more);
                int SNIPPET_LINES = 3;
                holder.mDescription.setMaxLines(holder.isExpanded ? Integer.MAX_VALUE : SNIPPET_LINES);
            }
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder {

            private final TextView mCategory;
            private final TextView mMissionNo;
            private final TextView mDescription;
            private final Button mExpandButton;
            private boolean isExpanded;

            ItemViewHolder(View v) {
                super(v);
                mMissionNo = v.findViewById(R.id.mission_no);
                mCategory = v.findViewById(R.id.mission_icon);
                mDescription = v.findViewById(R.id.mission_description);
                mExpandButton = v.findViewById(R.id.mission_expand_text_button);
            }
        }
    }
}
