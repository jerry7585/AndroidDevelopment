package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.Manifest;
import android.util.Log;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;
    private Location mCurrentLocation;
    private double longitude, latitude;
    private long ts;
    TextView locationText, timeText;
    boolean requestingLocationUpdates = false;

    List<Address> addressList = new ArrayList<>();
    HashMap<String, Integer> addressAll = new HashMap<>();
    protected void createLocationRequest() {
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressAll = new HashMap<>();
        locationText = (TextView) findViewById(R.id.location);
        timeText = (TextView) findViewById(R.id.time);


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        createLocationRequest();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            requestingLocationUpdates = true;
            fusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        longitude = location.getLongitude();
                        latitude = location.getLatitude();
                        ts = location.getTime();
                        //locationText.setText("Latitude:" + latitude + ", Longitude:" + longitude);

                        try {
                            addressList = geocoder.getFromLocation(latitude, longitude, 1);
                            //locationText.setText(addressList.get(0).getAddressLine(0));
                            StringBuilder sb = new StringBuilder();
                            sb.append(addressList.get(0).getAddressLine(0)).append("\n");

                            if (!addressAll.containsKey(addressList.get(0).getAddressLine(0))){
                                addressAll.put(addressList.get(0).getAddressLine(0), addressAll.size());
                                locationText.setText(locationText.getText().toString() + "\n" + sb.toString());
                            }
                            //System.out.println(sb.toString());
                            /*
                            String temp = locationText.getText().toString();
                            if (!(sb.toString().equals(temp))){
                                locationText.setText(locationText.getText().toString() + "\n" + sb.toString());
                            }
                            */
                            //locationText.setText(locationText.getText().toString() + "\n" + sb.toString());

                        } catch (IOException e) {
                            System.out.println("Error in geocoder");
                            throw new RuntimeException(e);
                        }

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                        String currentTime = dateFormat.format(new Date());
                      //  timeText.setText("Time: " + ts + "\n " + currentTime);
                    }
                }
            });
        }
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    //update ui with data
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();
                    ts = location.getTime();
                   // locationText.setText("Latitude:" + latitude + ", Longitude:" + longitude);
                    try {
                        addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        //locationText.setText(addressList.get(0).getAddressLine(0));
                        StringBuilder sb = new StringBuilder();
                        sb.append(addressList.get(0).getAddressLine(0)).append("\n");

                        if (!addressAll.containsKey(addressList.get(0).getAddressLine(0))){
                            addressAll.put(addressList.get(0).getAddressLine(0), addressAll.size());
                            locationText.setText(locationText.getText().toString() + "\n" + sb.toString());
                        }
                        /*
                        String temp = locationText.getText().toString();
                        if (!(sb.toString().equals(temp))){
                            locationText.setText(locationText.getText().toString() + "\n" + sb.toString());
                        }
                        */

                        //locationText.setText(locationText.getText().toString() + "\n" + sb.toString());

                        //System.out.println(sb.toString());
                    } catch (IOException e) {
                        System.out.println("Error in geocoder");
                        throw new RuntimeException(e);
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    String currentTime = dateFormat.format(new Date());
                   // timeText.setText("Time: " + ts + "\n " + currentTime);
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (requestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    private void startLocationUpdates() {
        //create a location request
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }
}