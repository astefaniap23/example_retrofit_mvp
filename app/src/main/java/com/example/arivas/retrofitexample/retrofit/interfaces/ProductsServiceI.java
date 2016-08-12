package com.example.arivas.retrofitexample.retrofit.interfaces;

import com.example.arivas.retrofitexample.retrofit.pojo.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by arivas on 02/08/2016.
 */
public interface ProductsServiceI {



    @GET("ws/rest/productsPrueba")
    Call<List<Products>> getProducts();

    @GET("ws/rest/productsPrueba/{id}")
    Call<Products> getProductsById(@Path("id") int id);
}
