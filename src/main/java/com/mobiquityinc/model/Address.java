package com.mobiquityinc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anandkhatri on 10/24/16.
 */
public class Address {

    @JsonProperty("street")
    private String street;

    @JsonProperty("housenumber")
    private String housenumber;

    @JsonProperty("postalcode")
    private String postalcode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("geoLocation")
    private GeoLocation geoLocation;


    /**
     *
     * @return
     * The street
     */
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    /**
     *
     * @param street
     * The street
     */
    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @return
     * The housenumber
     */
    @JsonProperty("housenumber")
    public String getHousenumber() {
        return housenumber;
    }

    /**
     *
     * @param housenumber
     * The housenumber
     */
    @JsonProperty("housenumber")
    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    /**
     *
     * @return
     * The postalcode
     */
    @JsonProperty("postalcode")
    public String getPostalcode() {
        return postalcode;
    }

    /**
     *
     * @param postalcode
     * The postalcode
     */
    @JsonProperty("postalcode")
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     *
     * @return
     * The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The geoLocation
     */
    @JsonProperty("geoLocation")
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    /**
     *
     * @param geoLocation
     * The geoLocation
     */
    @JsonProperty("geoLocation")
    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

}
