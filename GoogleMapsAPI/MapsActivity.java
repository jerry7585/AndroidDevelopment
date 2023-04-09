package com.example.mapsproject;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.Manifest;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

import androidx.fragment.app.Fragment;

import com.example.mapsproject.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity<MainActivity> extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnCameraIdleListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    TextView mMapTextView, camIdle;
    SearchView searchView;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Button getLocation = findViewById(R.id.getLocation);
        TextView currentLocation = (TextView) findViewById(R.id.currentLocation);*/

        mMapTextView = (TextView) findViewById(R.id.mMapTextView);
        camIdle = (TextView) findViewById(R.id.CameraIdle);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String search = (String) parent.getItemAtPosition(position);
                Geocoder geocoder = new Geocoder(MapsActivity.this);

                try {
                    List<Address> addresses = geocoder.getFromLocationName(search, 1);
                    Address address = addresses.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                    mMap.addMarker(new MarkerOptions().position(latLng).title(search));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                listView.setAdapter(null);
            }
        });

        searchView = (SearchView) findViewById(R.id.searchLocation);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                String search = searchView.getQuery().toString();
                Geocoder geocoder = new Geocoder(MapsActivity.this);

                try {
                    List<Address> addresses = geocoder.getFromLocationName(search, 1);
                    Address address = addresses.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                    mMap.addMarker(new MarkerOptions().position(latLng).title(search));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                mHandler.removeCallbacksAndMessages(null);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String search = searchView.getQuery().toString();
                        Geocoder geocoder = new Geocoder(MapsActivity.this);
                        try {
                            List<Address> addresses = geocoder.getFromLocationName(search, 3);
                            ArrayList<String> addrStr = new ArrayList<>();
                            for(Address i : addresses){
                                addrStr.add(i.getAddressLine(0));
                            }
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MapsActivity.this, android.R.layout.simple_list_item_1, addrStr);
                            listView.setAdapter(arrayAdapter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, 200);
                return false;
            }
        });
    }
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
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
        mMap.setOnCameraIdleListener(this);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);

        // Set compass position
        mMap.setPadding(0, 0, 0, 200);
    }

    @Override
    public void onMapClick(LatLng point) {
        mMapTextView.setText("tapped, point=" + point);
    }
    @Override
    public void onMapLongClick(LatLng point) {
        mMapTextView.setText("long pressed, point=" + point);
    }
    @Override
    public void onCameraIdle() {
        camIdle.setText(mMap.getCameraPosition().toString());
    }

}