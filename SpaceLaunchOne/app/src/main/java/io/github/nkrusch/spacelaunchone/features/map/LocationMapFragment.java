package io.github.nkrusch.spacelaunchone.features.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import io.github.nkrusch.spacelaunchone.R;
import local.Pad;
import viewmodels.LocationDetailsViewModel;

import static android.view.View.GONE;


public class LocationMapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng[] locations;
    private String[] names;
    private LatLngBounds.Builder builder;

    public static Fragment newInstance() {
        return new LocationMapFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);
        if (mapFragment != null) mapFragment.getMapAsync(this);
        AppCompatImageButton mLaunchSiteZoomToggleButton = view.findViewById(R.id.custom_map_button);
        mLaunchSiteZoomToggleButton.setVisibility(GONE);
        return view;
    }

    private void setupViewModel() {
        if (getActivity() == null) return;
        new ViewModelProvider(getActivity()).get(LocationDetailsViewModel.class)
                .get().observe(this, result -> {
                    if (result != null && result.getPads() != null && locations==null) {
                        locations = new LatLng[result.getPads().size()];
                        names = new String[result.getPads().size()];
                        for (int i = 0; i < result.getPads().size(); i++) {
                            Pad p = result.getPads().get(i);
                            locations[i] = new LatLng(p.getLatitude(), p.getLongitude());
                            names[i] = p.getName();
                        }
                        setMarker();
                    }
                });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        UiSettings mUiSettings = mMap.getUiSettings();
        mUiSettings.setZoomControlsEnabled(true);
        mUiSettings.setCompassEnabled(true);
        mUiSettings.setScrollGesturesEnabled(true);
        mUiSettings.setZoomGesturesEnabled(true);
        mUiSettings.setTiltGesturesEnabled(true);
        mUiSettings.setRotateGesturesEnabled(true);
        setMarker();
    }

    private void setMarker() {
        if (locations != null && locations.length > 0 && mMap != null) {
            builder = new com.google.android.gms.maps.model.LatLngBounds.Builder();
            for (int i = 0; i < locations.length; i++) {
                LatLng location = locations[i];
                String name = names[i];
                mMap.addMarker(new MarkerOptions().position(location).title(name));
                builder.include(location);
            }
            mMap.setOnMapLoadedCallback(this::centerMap);
        }
    }

    private void centerMap() {
        if (locations.length == 1) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(locations[0], 10.0f));
        } else {
            LatLngBounds bounds = builder.build();
            int mapCameraPadding = 100;
            mMap.animateCamera(com.google.android.gms.maps.CameraUpdateFactory.
                    newLatLngBounds(bounds, mapCameraPadding));
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        setupViewModel();
    }
}
