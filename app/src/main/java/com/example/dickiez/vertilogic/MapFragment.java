package com.example.dickiez.vertilogic;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.dickiez.vertilogic.Model.Address;
import com.example.dickiez.vertilogic.Model.Geo;
import com.example.dickiez.vertilogic.Model.User;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.GsonBuilder;

/**
 * Created by Dickiez on 4/10/2018.
 */

public class MapFragment extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    User listUser;
    Address address;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        listUser = new GsonBuilder().create()
                .fromJson(getIntent().getStringExtra("user"), User.class);

        // Add a marker in Sydney and move the camera
        address = listUser.getAddress();
        Geo geo = address.getGeo();
        Log.d("ANU IKI : ", geo.getLat());
        double lat = Integer.parseInt(geo.getLat());
        double lgt = Integer.parseInt(geo.getLng());

        LatLng location = new LatLng(lat,lgt);

        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}

/**
 * mMap.addMarker(new MarkerOptions().position(location).title(listUser.getCompany().getName()));
 CameraPosition camera = new CameraPosition.Builder().target(location).bearing(0).tilt(45).build();
 googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
 */
