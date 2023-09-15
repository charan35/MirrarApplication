/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.entity.response;

import com.example.myapplication.model.entity.RoverManifest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Classe RoverManifestResponse
 * Contient les infos relatives à un appel vers l'api
 * sur /manifests/
 * */
public class RoverManifestResponse {

    @SerializedName("photo_manifest")
    @Expose
    private RoverManifest manifest;

    public RoverManifest getManifest(){
        return this.manifest;
    }
}

