package io.github.nkrusch.spacelaunchone.features.details;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudinary.utils.StringUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.CircleTransform;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.LaunchDetails;

import static android.view.View.VISIBLE;

@SuppressWarnings("SpellCheckingInspection")
public class SummaryFragment extends DetailsBaseFragment {

    private final String EXTRA_INIT = "countdown_initialized";
    private boolean countdownInitialized = false;
    private boolean animateCountdown = true;
    private FrameLayout mTimerContainer;
    private ImageView mRocketCardImage;
    private ImageView mRocketImage;
    private ImageView mStatusImage;
    private ImageView mCountryImage;
    private TextView mStatus;
    private TextView mAgency;
    private TextView mRocket;
    private TextView mCountry;
    private SummaryItem mEventName;
    private SummaryItem mEventDate;
    private SummaryItem mRocketText;
    private SummaryItem mEventChanged;
    private SummaryItem mHashtag;
    private SummaryItem mLocation;
    private SummaryItem mAgencyName;
    private SummaryItem mCountryCode;
    private View mMissionDivider;
    private View mVideoDivider;

    public static Fragment newInstance() {
        return new SummaryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animateCountdown = (savedInstanceState == null || !savedInstanceState.containsKey(EXTRA_INIT));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        mTimerContainer = view.findViewById(R.id.timerContainer);
        mMissionDivider = view.findViewById(R.id.mission_divider);
        mVideoDivider = view.findViewById(R.id.divider_videos);

        mStatus = view.findViewById(R.id.event_status_text2);
        mAgency = view.findViewById(R.id.event_agency_text2);
        mRocket = view.findViewById(R.id.event_rocket_text2);
        mCountry = view.findViewById(R.id.event_country_text2);

        mCountryImage = view.findViewById(R.id.event_country);
        mRocketImage = view.findViewById(R.id.event_rocket);
        mStatusImage = view.findViewById(R.id.event_status);
        mRocketCardImage = view.findViewById(R.id.details_rocket_image);

        mEventName = view.findViewById(R.id.event_name);
        mEventDate = view.findViewById(R.id.event_date);
        mRocketText = view.findViewById(R.id.event_rocket_summary_text);
        mHashtag = view.findViewById(R.id.event_hashtag);
        mLocation = view.findViewById(R.id.event_location);
        mEventChanged = view.findViewById(R.id.event_change);
        mAgencyName = view.findViewById(R.id.agency_name);
        mCountryCode = view.findViewById(R.id.agency_country_code);
        return view;
    }

    private int statusImage(int status) {
        switch (status) {
            case 1:
                return R.drawable.ic_status_green;
            case 2:
                return R.drawable.ic_status_red;
            case 3:
                return R.drawable.ic_status_success;
            case 4:
                return R.drawable.ic_status_fail;
            case 5:
                return R.drawable.ic_status_on_hold;
            case 6:
                return R.drawable.ic_status_in_flight;
            case 7:
                return R.drawable.ic_status_partial_fail;
            default:
                return R.drawable.ic_status;
        }
    }

    private String countryName(String countryCode) {
        switch ((countryCode + "").toUpperCase()) {
            case "CHN":
                return "China";
            case "IND":
                return "India";
            case "FRA":
                return "France";
            case "JPN":
                return "Japan";
            case "KOR":
                return "South Korea";
            case "NZL":
                return "New Zealand";
            case "RUS":
                return "Russia";
            default:
                return countryCode;
        }
    }

    private void initCountdown(Long utc) {
        if (countdownInitialized) return;
        countdownInitialized = true;
        if (utc >= new Date().getTime() && getActivity() != null) {
            final DetailsTimer f = (DetailsTimer) DetailsTimer.newInstance(utc);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(mTimerContainer.getId(), f).commit();
        }
    }

    private void adjustDividers(LaunchDetails launch) {
        if (launch.getVidURLs() != null && launch.getVidURLs().length > 0)
            mVideoDivider.setVisibility(VISIBLE);
        if (launch.getMissions() != null && launch.getMissions().size() > 0)
            mMissionDivider.setVisibility(VISIBLE);
    }

    @Override
    protected void PopulateViews(LaunchDetails launch) {
        if (launch == null) return;

        String agency = coalesce(launch.getAgencyAbbrev());
        String agencyFullName = coalesce(launch.getAgencyName(), unknown);
        String agencyNameValue = StringUtils.isEmpty(agency) ? agencyFullName :
                String.format("%s (%s)", agencyFullName, agency);
        String rocketFamily = coalesce(launch.getRocketFamilyName(), unknown);
        String country = coalesce(countryName(launch.getLocationCountryCode()),
                countryName(launch.getAgencyCountryCode()), unknown);
        String location = String.format("%s\n%s", launch.getPadName(), launch.getLocationName()).trim();
        String changeDate = StringUtils.isEmpty(launch.getChanged()) ? unknown : Utilities
                .localTimeLabel(models.Launch.changeDate(launch.getChanged()), "MMMM d, yyyy HH:mm");
        initCountdown(launch.getLaunchDateUTC());
        adjustDividers(launch);

        mStatus.setText(launch.getStatusText());
        mRocket.setText(rocketFamily);
        mAgency.setText(agency);
        mCountry.setText(country);

        mEventName.setText(R.string.event_name, launch.getName());
        mEventDate.setText(R.string.launch_date, launch.getNet());
        mLocation.setText(R.string.launch_site, coalesce(location, unknown));
        mHashtag.setText(R.string.hashtag, coalesce(launch.getHashtag(), none));
        mEventChanged.setText(R.string.last_modified, changeDate);
        mAgencyName.setText(R.string.launch_service_provider, agencyNameValue);
        mCountryImage.setImageResource(Utilities.countryIcon(launch.getAgencyCountryCode()));
        mCountryCode.setText(R.string.agency_country_code, coalesce(launch.getAgencyCountryCode(), unknown));
        mRocketText.setText(R.string.rocket_summary_label,
                coalesce(launch.getRocketName(), unknown) + " / " +
                        coalesce(launch.getRocketFamilyName(), unknown) + " / " +
                        coalesce(launch.getRocketConfiguration(), unknown));

        mStatusImage.setImageResource(statusImage(launch.getStatus()));
        setImage(launch.getImage(), mRocketImage);
        setRocket(launch.getImage());
    }

    private void setImage(final String image, final ImageView target) {
        if (StringUtils.isEmpty(image) || models.Launch.isPlaceholderImage(image) || target == null)
            return;
        final Context context = getContext();
        final String sizedImage = Utilities.roundImage(image, Utilities.dpToPixel(40, getResources()));

        Picasso.with(context).load(sizedImage).noFade()
                .transform(new CircleTransform()).into(target, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
                target.setImageDrawable(getResources().getDrawable(R.drawable.ic_rocket));
            }
        });
    }

    private void setRocket(final String image) {
        if (StringUtils.isEmpty(image) || models.Launch.isPlaceholderImage(image) ||
                mRocketCardImage == null || getActivity() == null)
            return;
        WindowManager wm = getActivity().getWindowManager();
        final Context context = getContext();
        final String sizedImage = Utilities.sizedHeight(image, Utilities.display(wm).second);
        Picasso.with(context)
                .load(sizedImage)
                .into(mRocketCardImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        ((View) mRocketCardImage.getParent()).setVisibility(VISIBLE);
                    }

                    @Override
                    public void onError() {
                    }
                });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if (!animateCountdown) outState.putInt(EXTRA_INIT, 1);
        super.onSaveInstanceState(outState);
    }
}
