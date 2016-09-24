package com.kosratdahmad.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap mMap;
    boolean mapReady = false;

    MarkerOptions college;
    MarkerOptions institute;
    MarkerOptions center;
    MarkerOptions home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMarkers();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void initializeMarkers(){

        college = new MarkerOptions()
                .position(new LatLng(36.143408, 44.038090))
                .title("Erbil Technical Engineering College");

        institute = new MarkerOptions()
                .position(new LatLng(36.206036, 44.127907))
                .title("Hawler Private Computer Institute");

        center = new MarkerOptions()
                .position(new LatLng(36.238826, 44.008241))
                .title("GT Training Center");

        home = new MarkerOptions()
                .position(new LatLng(36.174615, 43.995754))
                .title("Home")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
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

        mMap.addMarker(college);
        mMap.addMarker(institute);
        mMap.addMarker(center);
        mMap.addMarker(home);

        LatLng erbil = new LatLng(36.2063, 44.0089);
        CameraPosition target = CameraPosition.builder().target(erbil).zoom(12).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 5000, null);
    }
}
