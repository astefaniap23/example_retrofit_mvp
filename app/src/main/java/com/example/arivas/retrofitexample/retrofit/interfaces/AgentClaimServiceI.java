package com.example.arivas.retrofitexample.retrofit.interfaces;

import com.example.arivas.retrofitexample.retrofit.pojo.Claim;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by aportillo on 01/08/2016.
 */
public interface AgentClaimServiceI {

    @GET("portal/clientClaims.do")
    Call <Claim> claims(@QueryMap Map <String,String> getHeaders);

    @GET("bins/2u64f")
    Call <Claim> claimsPba();




}
