/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.service;

import com.example.myapplication.model.entity.response.RoverManifestResponse;
import com.example.myapplication.model.entity.response.RoverPictureResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Interface contenant les méthodes d'accès à l'api
 * 
 * */
public interface NasaRoverApiService {

    /**
     * Récupère les métadonnées relatives à un rover en particulier
     * */
    @GET("manifests/{roverName}")
    Single<RoverManifestResponse> getManifestForRover(@Path("roverName") String roverName, @Query("api_key") String key);

    /**
     * Récupère les données d'un rover à une date donnée
     * */
    @GET("rovers/{roverName}/photos")
    Single<RoverPictureResponse> getRover(@Path("roverName") String roverName, @Query("earth_date") String date, @Query("api_key") String key);

}
