/**
 * @author rgiaquinto
 * */
package com.example.myapplication.model.datasource;

import com.example.myapplication.model.service.NasaRoverApiService;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Classe RemoteClient
 * Initialize une instance de retrofit pour acceder à l'api de la NASA
 *
 * */
public abstract class RemoteClient {

    private static Retrofit retrofit;
    private static NasaRoverApiService service;

    private static final String API_URL = "https://api.nasa.gov/mars-photos/api/v1/";
//    private static final String API_URL = "https://api.nasa.gov/planetary/apod";

    /**
     * Retourne une instance configurée de retrofit
     * @see Retrofit
     * */
    private static Retrofit getInstance(){

        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(

                            new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

                    )).build();
        }

        return retrofit;
    }

    /**
     * Retourne le service correspondant à celui utilisé pour communiquer avec l'api
     * */
    public static NasaRoverApiService getService(){

        if(service == null){

            service = getInstance().create(NasaRoverApiService.class);
        }

        return service;
    }

}
