package com.example.arivas.retrofitexample.retrofit.interfaces;

import com.example.arivas.retrofitexample.retrofit.pojo.Persona;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by arivas on 28/07/2016.
 */
public interface PersonaServiceI {

    /*@Headers(
            {
                    "prueba-header: parametro"
            }
    )*/

    @GET("bins/19fn8")
    Call<Persona> persona();
    //Call<Persona> persona(@Header("prueba-header") String prueba, @Header("prueba-header2") String prueba2);
}
