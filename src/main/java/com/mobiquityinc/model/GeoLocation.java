package com.mobiquityinc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anandkhatri on 10/24/16.
 */
public class GeoLocation {

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;

    /**
     *
     * @return
     * The lat
     */
    @JsonProperty("lat")
    public String getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    @JsonProperty("lat")
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lng
     */
    @JsonProperty("lng")
    public String getLng() {
        return lng;
    }

    /**
     *
     * @param lng
     * The lng
     */
    @JsonProperty("lng")
    public void setLng(String lng) {
        this.lng = lng;
    }
}
