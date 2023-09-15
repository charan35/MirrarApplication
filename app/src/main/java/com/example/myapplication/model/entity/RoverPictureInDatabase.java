/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.entity;

import java.io.Serializable;

/**
 * Classe RoverPictureInDatabase
 * Représente un rover stocké en base de données locale
 * */
public class RoverPictureInDatabase implements Serializable {

    private int id;

    private String roverName;

    private String cameraShortname;

    private String cameraLongName;

    private String date;

    private String image;

    public RoverPictureInDatabase(int id, String roverName, String cameraShortname, String cameraLongName, String date, String image) {

        this.id = id;
        this.roverName = roverName;
        this.cameraShortname = cameraShortname;
        this.cameraLongName = cameraLongName;
        this.date = date;
        this.image = image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoverName() {
        return roverName;
    }

    public void setRoverName(String roverName) {
        this.roverName = roverName;
    }

    public String getCameraShortname() {
        return cameraShortname;
    }

    public void setCameraShortname(String cameraShortname) {
        this.cameraShortname = cameraShortname;
    }

    public String getCameraLongName() {
        return cameraLongName;
    }

    public void setCameraLongName(String cameraLongName) {
        this.cameraLongName = cameraLongName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
