package com.example.arivas.retrofitexample.retrofit.pojo;

import com.example.arivas.retrofitexample.retrofit.interfaces.ServiceInterface;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aportillo on 02/08/2016.
 */
public class Claim  {

    @SerializedName("claims")
    private List<Claims> claims;

    private String errorCode;
    private String errorMessage;

    public Claim(List<Claims> claims) {
        this.claims = claims;
    }

    public List<Claims> getClaims() {
        return claims;
    }

    public void setClaims(List<Claims> claims) {
        this.claims = claims;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
