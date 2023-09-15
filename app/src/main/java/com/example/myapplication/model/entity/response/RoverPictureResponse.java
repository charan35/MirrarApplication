/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.entity.response;

import com.example.myapplication.model.entity.RoverPicture;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Classe RoverPictureResponse
 *
 * Contient la réponse à la requete concernant
 * la récupération des photos d'un rover
 * */
public class RoverPictureResponse {

    @SerializedName("photos")
    @Expose
    private List<RoverPicture> roverPicture;

    public List<RoverPicture> getRoverPicture(){
        return this.roverPicture;
    }


}
