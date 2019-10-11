package io.github.nkrusch.spacelaunchone.features.details;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudinary.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

import io.github.nkrusch.spacelaunchone.R;
import local.LaunchDetails;
import local.Mission;

import static io.github.nkrusch.spacelaunchone.app.Utilities.merge;

@SuppressWarnings("SpellCheckingInspection")
public class LinksFragment extends HorizontalRecyclerViewFragment<LinksFragment.ExternalLinksAdapter, LinksFragment.LinkItem> {

    private LinearLayout mContainer;
    private TextView mFragmentTitle;
    private int columnCount = 1;
    private int pagesize = 5;

    public LinksFragment() {
    }

    @Override
    int getPageSize() {
        return pagesize;
    }

    @Override
    ExternalLinksAdapter getAdapter() {
        return new ExternalLinksAdapter(new LinkedList<LinkItem>());
    }

    @Override
    int layoutRes() {
        return R.layout.fragment_links;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view != null) {
            mContainer = view.findViewById(R.id.external_links_container);
            mFragmentTitle = view.findViewById(R.id.links_title);
        }
        columnCount = getResources().getInteger(R.integer.links_column_count);
        return view;
    }

    @Override
    protected void PopulateViews(LaunchDetails launch) {
        if (launch == null) return;
        List<LinkItem> tmp = new LinkedList<>();
        addLinks(tmp, launch.getRocketName(), merge(launch.getRocketInfoURLs(), launch.getRocketWikiURL()));
        if (launch.getMissions() != null) for (Mission m : launch.getMissions())
            addLinks(tmp, m.getName() + " mission", merge(null, m.getWikiURL()));
        addLinks(tmp, launch.getPadName(), merge(launch.getPadInfoURLs(), launch.getPadWikiURL()));
        addLinks(tmp, launch.getAgencyName(), merge(launch.getAgencyInfoURLs(), launch.getAgencyWikiURL()));
        handleDataChange(tmp);
    }

    private void addLinks(List<LinkItem> tmp, String name, List<String> urls) {
        if (urls == null) return;
        for (String u : urls) {
            if (StringUtils.isEmpty(u)) continue;

            String host = Uri.parse(u).getHost();
            host = host.substring(host.indexOf(".") + 1);

            if (host.contains("wikipedia")) {
                tmp.add(new LinkItem(String.format("%s", name), u));
                //                host = "wikipedia";
//                icon = R.drawable.ic_wikipedia;
            }
            //            else if (host.contains("facebook")) {
//                host = "facebook";
//                icon = R.drawable.ic_facebook_box;
//            } else if (u.contains("twitter")) {
//                host = "twitter";
//                icon = R.drawable.ic_twitter;
//            } else if (u.contains("linkedin")) {
//                host = "linkedid";
//                icon = R.drawable.ic_linkedin_box;
//            } else if (u.contains("instagram")) {
//                host = "instagram";
//                icon = R.drawable.ic_instagram;
//            } else if (u.contains("youtube")) {
//                host = "youtube";
//                icon = R.drawable.ic_youtube;
//            }
        }
    }

    class LinkItem {
        private final String label;
        private final String url;

        LinkItem(String label, String url) {
            this.label = label;
            this.url = url;
        }

        String getLabel() {
            return label;
        }

        String getUrl() {
            return url;
        }

    }

    @Override
    void handleDataChange(@Nullable List<LinkItem> entries) {
        boolean hasEntries = entries != null && entries.size() > 0;
        if (hasEntries) {
            mContainer.setVisibility(View.VISIBLE);
            mFragmentTitle.setText(getResources().getQuantityString(
                    R.plurals.document_label, entries.size(), entries.size()));
            pagesize = (int) Math.ceil(entries.size() / (float) columnCount);
            setGridLayoutManager();
        } else {
            mContainer.setVisibility(View.GONE);
        }
        super.handleDataChange(entries);
    }

    public class ExternalLinksAdapter
            extends RecyclerView.Adapter<ExternalLinksAdapter.ItemViewHolder>
            implements BaseRecyclerViewAdapter<LinksFragment.LinkItem> {

        private List<LinkItem> dataSource;

        ExternalLinksAdapter(List<LinkItem> dataArgs) {
            dataSource = dataArgs;
        }

        public void updateData(List<LinkItem> dataArgs) {
            dataSource = dataArgs;
        }

        @NonNull
        @Override
        public ExternalLinksAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ExternalLinksAdapter.ItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_link_list, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final ExternalLinksAdapter.ItemViewHolder holder, int position) {
            LinkItem item = dataSource.get(position);
            holder.mTitle.setText(item.getLabel());
            if (columnCount > 1)
                holder.mLayout.getLayoutParams().width = getResources()
                        .getDimensionPixelSize(R.dimen.links_column_width);
        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private final TextView mTitle;
            private final LinearLayout mLayout;

            ItemViewHolder(View v) {
                super(v);
                mLayout = v.findViewById(R.id.link_layout);
                mTitle = v.findViewById(R.id.link_text);
                v.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                try {
                    String url = dataSource.get(getAdapterPosition()).getUrl();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}