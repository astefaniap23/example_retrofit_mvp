package com.example.arivas.retrofitexample.retrofit.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Vector;

/**
 * Created by arivas on 01/08/2016.
 */
public class Login {

    private int errorCode;
    private String errorMessage;
    private String token;

    @SerializedName("tpid")
    private long tpId;

    @SerializedName("thirdcode")
    private String thirdCode;


    private Vector<String> roles;
    private String tpName;

    @SerializedName("usertype")
    private String userType;

    @SerializedName("customeruid")
    private String customerUId;

    private String office;

    public Login() {
    }

    public Login(int errorCode, String errorMessage, String token, long tpId, String thirdCode, Vector<String> roles, String tpName, String userType, String customerUId, String office) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.token = token;
        this.tpId = tpId;
        this.thirdCode = thirdCode;
        this.roles = roles;
        this.tpName = tpName;
        this.userType = userType;
        this.customerUId = customerUId;
        this.office = office;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTpId() {
        return tpId;
    }

    public void setTpId(long tpId) {
        this.tpId = tpId;
    }

    public String getThirdCode() {
        return thirdCode;
    }

    public void setThirdCode(String thirdCode) {
        this.thirdCode = thirdCode;
    }

    public Vector<String> getRoles() {
        return roles;
    }

    public void setRoles(Vector<String> roles) {
        this.roles = roles;
    }

    public String getTpName() {
        return tpName;
    }

    public void setTpName(String tpName) {
        this.tpName = tpName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCustomerUId() {
        return customerUId;
    }

    public void setCustomerUId(String customerUId) {
        this.customerUId = customerUId;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
