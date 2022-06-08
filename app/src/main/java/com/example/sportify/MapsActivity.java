package com.example.sportify;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.sportify.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    MarkerOptions Vistafonmarker;
    MarkerOptions Unamarker;
    MarkerOptions Bentbasamarker;
    LatLng centerLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        centerLocation = new LatLng(43.8563, 18.4131);

        Vistafonmarker = new MarkerOptions().title("Vistafon")
                .position(new LatLng(43.84781989893643, 18.358650361384527))
                .snippet ("Open from 08:00- 00:00");

        Unamarker = new MarkerOptions().title("Una")
                .position(new LatLng(43.857382714671296, 18.397772382397932))
                .snippet ("Open from 08:00- 00:00");

        Bentbasamarker = new MarkerOptions().title("Bentbasa")
                .position(new LatLng(43.85879190791246, 18.438872742066255))
                .snippet ("Open from 08:00- 00:00");
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(Vistafonmarker);
        mMap.addMarker(Unamarker);
        mMap.addMarker(Bentbasamarker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLocation,13));
    }
}