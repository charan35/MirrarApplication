/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.entity;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe Camera
 * Contient les infos relatives à une camera d'un rover
 * */
public class Camera {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("full_name")
    @Expose
    String fullName;

    public String getName(){ return this.name; }

    public String getFullName(){return this.fullName; }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @NonNull
    @Override
    public String toString() {
        return "Camera [ name= "+this.name+", fullName= "+this.fullName+" ]";
    }
}
