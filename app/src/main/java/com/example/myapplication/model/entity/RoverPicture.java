/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.entity;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe RoverPicture
 *
 * Contient les infos relatives aux données concernant
 * les tirages photos d'un rover en particulier
 *
 * */
public class RoverPicture {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("rover")
    @Expose
    private RoverManifest rover;

    @SerializedName("camera")
    @Expose
    private Camera camera;

    @SerializedName("img_src")
    @Expose
    private String image;

    private String date;

    public RoverManifest getRover(){ return this.rover; }

    public Camera getCamera(){ return this.camera; }

    public String getImage(){ return this.image; }

    public int getId(){
        return this.id;
    }

    public String getDate(){
        return this.date;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setRover(RoverManifest rover) {
        this.rover = rover;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDate(String date){
        this.date = date;
    }

    @NonNull
    @Override
    public String toString() {
        return "RoverPicture [ id= "+this.id+",rover= "+this.rover.toString()+", date="+this.date+", camera= "+this.camera.toString()+", image= "+this.image+" ]";
    }
}
