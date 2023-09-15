/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.entity;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author rgiaquinto
 *
 * Classe RoverManifest
 * Contient les metadonnées relavites à un rover sur mars.
 *
 * */
public class RoverManifest {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("landing_date")
    @Expose
    private String landingDate;

    @SerializedName("launch_date")
    @Expose
    private String launchDate;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("max_date")
    @Expose
    private String maxDate;

    @SerializedName("total_photos")
    @Expose
    private int totalPhotos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public int getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(int totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    @NonNull
    @Override
    public String toString() {
        return "RoverManifest : [ name= "+this.name+", landingDate= "+this.landingDate+", launchDate= "+this.launchDate+", status= "+this.status+", maxDate= "+this.maxDate+", totalPhotos= "+this.totalPhotos+" ]";
    }
}
