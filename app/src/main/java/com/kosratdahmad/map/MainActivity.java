package com.kosratdahmad.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap mMap;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void mapBtn(View v){

        if(mapReady)
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    public void satelliteBtn(View v){

        if(mapReady)
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
    public void hybridBtn(View v){

        if(mapReady)
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Log.i("Map","onMapReady");
        mapReady = true;
        mMap = googleMap;

        LatLng erbil = new LatLng(36.2063, 44.0089);
        CameraPosition target = CameraPosition.builder().target(erbil).zoom(12).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
