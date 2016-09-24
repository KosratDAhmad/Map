package com.kosratdahmad.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/**
 * Created by kosrat on 9/24/16.
 */

public class StreetActivity extends AppCompatActivity implements
        OnStreetViewPanoramaReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street);

        StreetViewPanoramaFragment streetFragment = (StreetViewPanoramaFragment) getFragmentManager()
                .findFragmentById(R.id.streetView);
        streetFragment.getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {

        streetViewPanorama.setPosition(new LatLng(37.400546,-122.108668));

        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
        streetViewPanorama.animateTo(camera, 1000);
        streetViewPanorama.setStreetNamesEnabled(true);
        streetViewPanorama.setZoomGesturesEnabled(true);
        streetViewPanorama.setUserNavigationEnabled(true);

        // Detect camera changes:
        // setOnStreetViewPanoramaCameraChangeListener

        // Detect user touches on panorama:
        // setOnStreetViewPanoramaClickListener

        // Detect changes to the panorama:
        // setOnStreetViewPanoramaChangeListener

    }
}
