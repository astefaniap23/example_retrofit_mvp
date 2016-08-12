package com.example.arivas.retrofitexample.retrofit.pojo;

import java.util.List;

/**
 * Created by arivas on 14/06/2016.
 */
public class Persona {

    private String nombre;
    private String cedula;
    private List<String> palabras;
    private List<Auto> autos;

    public Persona(){
    }

    public Persona(String nombre, String cedula, List<String> palabras, List<Auto> autos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.palabras = palabras;
        this.autos = autos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<String> palabras) {
        this.palabras = palabras;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
}
