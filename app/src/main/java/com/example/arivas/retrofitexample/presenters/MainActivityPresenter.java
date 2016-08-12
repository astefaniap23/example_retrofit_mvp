package com.example.arivas.retrofitexample.presenters;

import android.content.Context;
import android.util.Log;

import com.example.arivas.retrofitexample.MvcApplication;
import com.example.arivas.retrofitexample.interfaces.views.MainActivityI;
import com.example.arivas.retrofitexample.retrofit.interfaces.AgentClaimServiceI;
import com.example.arivas.retrofitexample.retrofit.interfaces.ServiceInterface;
import com.example.arivas.retrofitexample.retrofit.pojo.Claim;
import com.example.arivas.retrofitexample.retrofit.service.AgentClaimService;
import com.example.arivas.retrofitexample.views.MainActivity;
import com.example.arivas.retrofitexample.interfaces.presenters.MainActivityPresenterI;
import com.example.arivas.retrofitexample.retrofit.pojo.Login;
import com.example.arivas.retrofitexample.retrofit.pojo.Persona;
import com.example.arivas.retrofitexample.retrofit.pojo.Products;
import com.example.arivas.retrofitexample.retrofit.service.LoginService;
import com.example.arivas.retrofitexample.retrofit.service.PersonaService;
import com.example.arivas.retrofitexample.retrofit.service.ProductsService;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arivas on 02/08/2016.
 */
public class MainActivityPresenter implements MainActivityPresenterI {

    private MainActivityI mainActivity;
    private ProductsService productsService;
    private PersonaService personaService;
    private LoginService loginService;
    private AgentClaimService angentClaimService;

    Context context;
    MvcApplication mvcApplication;


    @Override
    public void onCreate(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.onConnection();
        context = (Context) mainActivity;
        mvcApplication = (MvcApplication) context.getApplicationContext();
    }

    @Override
    public void onConnection() {
        this.productsService = new ProductsService("http://192.168.1.75:9080/");
        this.personaService = new PersonaService("https://api.myjson.com/", null, null, null);
        this.loginService = new LoginService(null, null, null);
        this.angentClaimService = new AgentClaimService("http://192.168.0.134:9080/ws/", null);
    }


    @Override
    public void loadProducts() {

        this.productsService.getProductsServiceI().getProducts()
                .enqueue(new Callback<List<Products>>() {
                    @Override
                    public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                        mainActivity.setTextView(new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<List<Products>> call, Throwable t) {
                        mainActivity.setTextView(t.getMessage());
                    }
                });
    }

    @Override
    public void loadProduct() {
        this.productsService.getProductsServiceI().getProductsById(1111)
                .enqueue(new Callback<Products>() {
                    @Override
                    public void onResponse(Call<Products> call, Response<Products> response) {
                        mainActivity.setTextView(new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<Products> call, Throwable t) {
                        mainActivity.setTextView(t.getMessage());
                    }
                });
    }

    @Override
    public void loadPersona() throws Exception {
        try {
            this.personaService.getPersonaServiceI().persona()
                    .enqueue(new Callback<Persona>() {
                        @Override
                        public void onResponse(Call<Persona> call, Response<Persona> response) {
                            try {
                                if (response.isSuccessful()) {
                                    mainActivity.setTextView(new Gson().toJson(response.body()));
                                } else {
                                    throw new Exception("Is Not Successful.");
                                }
                            } catch (Exception e) {
                                mainActivity.setTextView(e.getMessage());
                            }
                        }

                        @Override
                        public void onFailure(Call<Persona> call, Throwable t) {
                            mainActivity.setTextView(t.getMessage());
                        }
                    });
        } catch (Exception e) {
            Log.e("MainPresenter", "loadPersona - " + e.getMessage());
        }

    }

    @Override
    public void login(String securityLanguage, String securityLogin, String securitySubmit, String securityPassword) {
        /*
            @Header("SecurityLanguage") String securityLanguage,
            @Header("SecurityLogin") String securityLogin,
            @Header("SecuritySubmit") String securitySubmit,
            @Header("SecurityPassword") String securityPassword
        */
        this.loginService.getLoginServiceI().login(securityLanguage, securityLogin, securitySubmit, securityPassword).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()) {
                    mainActivity.setTextView(new Gson().toJson(response.body()));
                    mvcApplication.setLogin(response.body());
                }else{
                    mainActivity.setTextView(response.message());
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                mainActivity.setTextView(t.getMessage());
            }
        });
    }

    @Override
    public void loadClaim(Map<String,String> map) {
         try {
            this.angentClaimService.getAgentClaimI(map,new ServiceInterface<Claim>() {
                @Override
                public void onSuccess(Claim value) {
                    Log.e("onSuccess.value", String.valueOf(value));
                }
                @Override
                public void onError() {
                    Log.e("onError", "onError");
                }
            },Claim.class );
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "loadClaim - " + e.getMessage());
        }
    }

}
