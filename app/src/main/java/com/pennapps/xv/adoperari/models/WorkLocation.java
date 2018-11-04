package com.pennapps.xv.adoperari.models;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by jeffrey on 1/22/17.
 */

public class WorkLocation {

    public transient Place place;

    public LatLng getCoord() {
        return coord;
    }

    public void setCoord(LatLng coord) {
        this.coord = coord;
    }

    LatLng coord;
    public String name;

    public WorkLocation(Place place){
        coord = place.getLatLng();
        name = "" + place.getName();
    }
}
