package com.example.arivas.retrofitexample.retrofit.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aportillo on 02/08/2016.
 */
public class Claims {

    @SerializedName("claimNumber")
    private String claimNumber;
    @SerializedName("paidAmount")
    private int paidAmount;
    @SerializedName("pendingAmount")
    private float pendingAmount;
    @SerializedName("currency")
    private String currency;


    public Claims(String claimNumber, int paidAmount, float pendingAmount,String currency ) {
        this.claimNumber = claimNumber;
        this.paidAmount = paidAmount;
        this.pendingAmount = pendingAmount;
        this.currency = currency;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public float getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(float pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
