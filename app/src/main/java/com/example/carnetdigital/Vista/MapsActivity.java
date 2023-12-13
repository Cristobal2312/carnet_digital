package com.example.carnetdigital.Vista;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.carnetdigital.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.blue_button));
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;


        LatLng ubicacion = new LatLng(-30.609834297027078, -71.20177662698983);
        myMap.addMarker(new MarkerOptions().position(ubicacion).title("Cesfam Fray Jorge"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

        float zoomLevel = 15.0f;
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, zoomLevel));

        // Enable the desired UI settings
        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setCompassEnabled(true);
        myMap.getUiSettings().setScrollGesturesEnabled(true);


        // Optionally, you can also set other UI settings based on your requirements
        myMap.getUiSettings().setMapToolbarEnabled(true);




    }

}
