package io.github.nkrusch.spacelaunchone.features.launchdetails;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.AppImage;
import local.LaunchDetails;
import utilities.Logger;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * This fragment contains horizontally scrolling recyclerView with videos
 */
public class VideosFragment extends HorizontalRecyclerViewFragment<VideosFragment.VideoAdapter, String> {

    private TextView mVideoLabel;
    private ConstraintLayout mContainer;

    public VideosFragment() {
    }

    @Override
    int getPageSize() {
        return 1;
    }

    @Override
    VideoAdapter getAdapter() {
        return new VideoAdapter(new LinkedList<>());
    }

    @Override
    int layoutRes() {
        return R.layout.fragment_videos;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view != null) {
            mVideoLabel = view.findViewById(R.id.video_subtitle);
            mContainer = view.findViewById(R.id.video_container);
        }
        return view;
    }

    @Override
    protected void PopulateViews(LaunchDetails launch) {
        if (launch == null || launch.getVidURLs() == null) return;
        handleDataChange(Arrays.asList(launch.getVidURLs()));
        int numVideos = launch.getVidURLs().length;
        mVideoLabel.setText(getResources().getQuantityString(R.plurals.video_label, numVideos, numVideos));
        mContainer.setVisibility(numVideos > 0 ? VISIBLE : GONE);
    }

    public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ItemViewHolder>
            implements BaseRecyclerViewAdapter<String> {

        private List<String> dataSource;

        VideoAdapter(List<String> dataArgs) {
            dataSource = dataArgs;
        }

        public void updateData(List<String> dataArgs) {
            dataSource = dataArgs;
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        @NonNull
        @Override
        public VideoAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new VideoAdapter.ItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_video_list, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final VideoAdapter.ItemViewHolder holder, int position) {
            String videoUrl = dataSource.get(position);
            if (videoUrl.indexOf("youtube") > 0 && videoUrl.indexOf("watch?v=") > 0) {
                String videoId = videoUrl.split("=", 2)[1];
                String YOUTUBE_IMG = "https://i.ytimg.com/vi/{:id}/sddefault.jpg";
                String imageUrl = YOUTUBE_IMG.replace("{:id}", videoId);
                AppImage.LoadImageFromURL(imageUrl, holder.mVideoImage);
            }
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private final ImageView mVideoImage;

            ItemViewHolder(View v) {
                super(v);
                mVideoImage = v.findViewById(R.id.video_image);
                mVideoImage.setOnClickListener(this);
            }

            public String extractYTId(String ytUrl) {
                String vId = null;
                Pattern pattern = Pattern.compile(
                        "^https?://.*(?:youtu.be/|v/|u/\\w/|embed/|watch?v=)([^#&?]*).*$",
                        Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(ytUrl);
                if (matcher.matches()) {
                    vId = matcher.group(1);
                }
                return vId;
            }

            @Override
            public void onClick(View v) {
                try {
                    String url = dataSource.get(getAdapterPosition());
                    String ytId = extractYTId(url);
                    if (ytId != null) {
                        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + ytId));
                        try {
                            startActivity(appIntent);
                            return;
                        } catch (ActivityNotFoundException ex) {
                            Logger.displayError(ex);
                        }
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                  startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
