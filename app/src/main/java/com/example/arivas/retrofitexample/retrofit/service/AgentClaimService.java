package com.example.arivas.retrofitexample.retrofit.service;

import android.util.Log;


import com.example.arivas.retrofitexample.retrofit.interfaces.LoginServiceI;
import com.example.arivas.retrofitexample.retrofit.pojo.Claim;
import com.google.gson.Gson;

import com.example.arivas.retrofitexample.retrofit.interfaces.ServiceInterface;
import com.example.arivas.retrofitexample.retrofit.interfaces.AgentClaimServiceI;

import java.util.Map;

import retrofit2.Call;

/**
 * Created by aportillo on 28/07/2016.
 */

public class AgentClaimService<T> extends BaseService {

    private AgentClaimServiceI agentClaimServiceI;
    private ServiceGenerator serviceGenerator;

    public AgentClaimService(String baseUrl, Map<String, String> headers) {
        super(baseUrl, headers);
        this.agentClaimServiceI = getRetrofit().create(AgentClaimServiceI.class);
    }

    public void getAgentClaimI(Map<String, String> map, ServiceInterface<T> serviceInterface, T t) throws Exception {
        try {
            serviceGenerator = new ServiceGenerator();
            this.agentClaimServiceI = getRetrofit().create(AgentClaimServiceI.class);
            Call<T> aCall = (Call<T>) this.agentClaimServiceI.claims(map);
            serviceGenerator.response(aCall, serviceInterface);
        } catch (Exception e) {
            Log.e("Error", getClass().getSimpleName() + ":" + e.getMessage());
        }
    }

}

