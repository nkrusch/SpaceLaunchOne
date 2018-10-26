package io.github.nkrusch.spacelaunchone.features.map;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import io.github.nkrusch.spacelaunchone.R;
import io.github.nkrusch.spacelaunchone.app.Utilities;
import local.LaunchDetails;
import viewmodels.LaunchDetailsViewModel;

import static android.view.View.GONE;

/**
 * This fragment displays google map with a marker set to the rocket launch site
 */
public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnPoiClickListener {

    private AppCompatImageButton mLaunchSiteZoomToggleButton;
    private GoogleMap mMap;
    private Marker marker;
    private LatLng location;
    private final int customZoomDuration = 800;

    public static Fragment newInstance() {
        return new MapFragment();
    }

    /**
     * Get the map fragment and initialize maps; set callback when map has finished loading.
     * Also find custom toggle button and set it invisible for now
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        if (mapFragment != null) mapFragment.getMapAsync(this);

        mLaunchSiteZoomToggleButton = view.findViewById(R.id.custom_map_button);
        mLaunchSiteZoomToggleButton.setOnClickListener(onMarkerZoomButtonClick());
        mLaunchSiteZoomToggleButton.setVisibility(GONE);
        return view;
    }

    /**
     * Bind viewModel which returns the location coordinates
     */
    private void setupViewModel() {
        if (getActivity() == null) return;
        ViewModelProviders.of(getActivity()).get(LaunchDetailsViewModel.class)
                .get().observe(this, new Observer<LaunchDetails>() {
            @Override
            public void onChanged(@Nullable LaunchDetails result) {
                if (result != null) {
                    location = new LatLng(result.getLatitude(), result.getLongitude());
                    setMarker();
                }
            }
        });
    }

    /**
     * This custom button zooms in and out of the launch size
     */
    private View.OnClickListener onMarkerZoomButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMap == null) return;
                float currentZoomLevel = mMap.getCameraPosition().zoom;
                float midZoom = Math.abs(mMap.getMaxZoomLevel() - mMap.getMinZoomLevel()) * 0.5f;
                float current = currentZoomLevel < midZoom ?
                        0.85f * mMap.getMaxZoomLevel() :
                        mMap.getMinZoomLevel();
                mMap.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(marker.getPosition(), current),
                        customZoomDuration, null);
            }
        };
    }

    /**
     * Bind map controls and reveal custom launch site zoom toggle button after map has loaded
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);
        mUiSettings.setCompassEnabled(true);
        mUiSettings.setScrollGesturesEnabled(true);
        mUiSettings.setZoomGesturesEnabled(true);
        mUiSettings.setTiltGesturesEnabled(true);
        mUiSettings.setRotateGesturesEnabled(true);
        mMap.setOnPoiClickListener(this);
        setMarker();
    }

    /**
     * Handle map click on some point of interest ->
     * This will attempt to load places images for the selected location
     */
    public void onPoiClick(PointOfInterest poi) {
        final ConnectivityManager cm = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        boolean canLoadPlaces = Utilities.isNetworkAvailable(cm);
        if (canLoadPlaces) {
            if (getFragmentManager() != null) {
                PlacesFragment psf = PlacesFragment.newInstance(poi.placeId, poi.name);
                psf.show(getFragmentManager(), null);
            }
        } else Snackbar.make(getActivity().findViewById(android.R.id.content),
                R.string.offline_message, Snackbar.LENGTH_LONG).show();
    }

    /**
     * Add market to map showing the launch site and set marker zoom button visible
     */
    private void setMarker() {
        if (location != null && mMap != null) {
            marker = mMap.addMarker(new MarkerOptions().position(location).title(getString(R.string.launch_site)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            mLaunchSiteZoomToggleButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        setupViewModel();
    }
}
