package com.example.arivas.retrofitexample.retrofit.service;

import com.example.arivas.retrofitexample.retrofit.interfaces.ProductsServiceI;


/**
 * Created by arivas on 02/08/2016.
 */
public class ProductsService extends BaseService {

    private ProductsServiceI productsServiceI;

    public ProductsService(String baseUrl) {
        super(baseUrl);
        this.productsServiceI = getRetrofit().create(ProductsServiceI.class);
    }

    public ProductsServiceI getProductsServiceI() {
        return productsServiceI;
    }
}
