package com.example.arivas.retrofitexample.retrofit.pojo;

import java.io.Serializable;

/**
 * Created by arivas on 14/06/2016.
 */
public class Auto {

    private String placa;
    private String color;

    public Auto() {
    }

    public Auto(String placa, String color) {
        this.placa = placa;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
