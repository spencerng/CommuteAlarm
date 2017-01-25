package com.pennapps.xv.adoperari.data;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;

import java.util.AbstractList;
import java.util.List;

import static com.google.android.gms.location.Geofence.NEVER_EXPIRE;

/** Class of static methods using Google Maps API
 * Created by sng on 1/21/2017.
 */

public class GoogleMaps {
    GoogleApiClient apiClient;
    AbstractList geoList = null;

    public static void initializeGAC(Context passC) {
        GoogleMaps gm = new GoogleMaps();
        gm.apiClient = new GoogleApiClient.Builder(passC)
                .addApi(LocationServices.API)
                .build();
        gm.apiClient.connect();
    }

    public Location getLocation() {
        return LocationServices.FusedLocationApi.getLastLocation(apiClient);
    }

    public void addWorkGeofence(Place workplace) {

        LatLng workplaceLatLng = workplace.getLatLng();
        geoList.add(2, new Geofence.Builder()
                // Set the request ID of the geofence. This is a string to identify this
                // geofence.
                .setRequestId("2")

                .setCircularRegion(
                        workplaceLatLng.latitude,
                        workplaceLatLng.longitude,
                        100 //Radius of geofence in meters
                )
                .setExpirationDuration(NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
                .build());

    }

    public void addHomeGeofence(Location currLoc) {
        geoList.add(1, new Geofence.Builder()
                .setRequestId("1")
                .setCircularRegion(
                    currLoc.getLatitude(),
                    currLoc.getLongitude(),
                    100 )
                .setExpirationDuration(NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_EXIT)
                .build());

    }

    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(geoList);
        return builder.build();
    }


}
