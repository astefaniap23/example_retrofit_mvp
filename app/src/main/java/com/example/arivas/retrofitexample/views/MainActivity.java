package com.example.arivas.retrofitexample.views;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.example.arivas.retrofitexample.MvcApplication;
import com.example.arivas.retrofitexample.R;
import com.example.arivas.retrofitexample.interfaces.views.MainActivityI;
import com.example.arivas.retrofitexample.retrofit.interfaces.ServiceInterface;
import com.example.arivas.retrofitexample.retrofit.pojo.Claim;
import com.example.arivas.retrofitexample.retrofit.service.AgentClaimService;
import com.example.arivas.retrofitexample.interfaces.presenters.MainActivityPresenterI;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.InjectView;

public class MainActivity extends RoboActionBarActivity implements MainActivityI, View.OnClickListener {//AppCompatActivity implements MainActivityI{

    @InjectView(R.id.toolbar)
    private Toolbar toolbar;

    @InjectView(R.id.nombre)
    private TextView textView;

    @InjectView(R.id.fab)
    private FloatingActionButton fab;

    @InjectView(R.id.claim)
    private Button buttonClaim;

    @InjectView(R.id.buttonPersonas)
    Button buttonPersonas;

    @InjectView(R.id.buttonLogin)
    private Button buttonLogin;

    @InjectView(R.id.buttonProducts)
    private Button buttonProducts;

    @InjectView(R.id.buttonProduct)
    private Button buttonProduct;

    @Inject
    private MainActivityPresenterI mainPresenterI;


    MvcApplication mvcApplication;

    Claim claim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * @InjectView(R.id.toolbar)
         *private Toolbar toolbar;
         */
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //mainPresenterI = new MainActivityPresenter(this);

        /**
         * @InjectView(R.id.nombre)
         * private TextView textView;
         */
        //textView = (TextView) findViewById(R.id.nombre);

        /**
         * @InjectView(R.id.fab)
         * private FloatingActionButton fab;
         */
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        /**
         * @InjectView(R.id.claim)
         * private Button buttonClaim;
         */

        /**
         * @InjectView(R.id.buttonPersonas)
         * Button buttonPersonas;
         */
        //Button buttonPersonas = (Button) findViewById(R.id.buttonPersonas);
        /**
         * @InjectView(R.id.buttonLogin)
         * private Button buttonLogin;
         */
        //Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        /**
         * @InjectView(R.id.buttonProducts)
         * private Button buttonProducts;
         */
        //Button buttonProducts = (Button) findViewById(R.id.buttonProducts);
        /**
         * @InjectView(R.id.buttonProduct)
         * private Button buttonProduct;
         */
        //Button buttonProduct = (Button) findViewById(R.id.buttonProduct);


        mvcApplication = (MvcApplication) this.getApplicationContext();
        setSupportActionBar(toolbar);
        mainPresenterI.onCreate(this);
        buttonPersonas.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        buttonProducts.setOnClickListener(this);
        buttonProduct.setOnClickListener(this);
        buttonClaim.setOnClickListener(this);
        fab.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void setTextView(String text) {
        textView.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPersonas:
                personas();
                break;
            case R.id.buttonLogin:
                login();
                break;
            case R.id.buttonProducts:
                products();
                break;
            case R.id.buttonProduct:
                product();
                break;
            case R.id.fab:
                clearQATextView(v);
                break;
            case R.id.claim:
                try {
                    claim();
                } catch (Exception e) {
                    Log.e("Button Clain", e.getMessage());
                }
                break;
            default:
                Toast.makeText(MainActivity.this, "default", Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void login() {
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        mainPresenterI.login("es", usuario.getText().toString(), "true", contraseña.getText().toString());
    }

    @Override
    public void clearQATextView(View v) {
        Snackbar.make(v, "Clear", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        setTextView("QA");
    }

    @Override
    public void personas() {
        try {
            mainPresenterI.loadPersona();
        } catch (Exception e) {
            Log.e("MainActivity", "onCreate - " + e.getMessage());
        }
    }

    @Override
    public void products() {
        mainPresenterI.loadProducts();
    }

    @Override
    public void product() {
        mainPresenterI.loadProduct();
    }

    public void claim() {
        try {
            mainPresenterI.loadClaim(makeMap());
        } catch (Exception e) {
            Log.e("button.claim", e.getMessage());
        }
    }


    public Map<String, String> makeMap() { //Ejemplo carga de data por Map
        Map<String, String> headers = new HashMap<>();

        String mvcApp= String.valueOf(mvcApplication.getLogin());
        if (!((mvcApp.isEmpty()) || (mvcApp.equals("null"))))
            headers.put("token", mvcApplication.getLogin().getToken());
        else
            headers.put("token", "2F083BA202085E04A1BAC88FC2CD6E942F083BA202085E04");
        headers.put("command", "claims");
        headers.put("start", "1");
        headers.put("offset", "15");
        headers.put("tptId", "806567");
        headers.put("currency", "2244");
        return headers;
    }


    /*

    @Override
    public void claim() throws Exception{
        try {
            AgentClaimService angentClaimService = new AgentClaimService("http://192.168.0.78:9080/ws/", makeMap());
            angentClaimService.getAgentClaim(new ServiceInterface<Claim>() {
                @Override
                public void onSuccess(Claim value) {
                    Log.e("onSuccess.value", String.valueOf(value));
                }

                @Override
                public void onError() {
                    Log.e("onError", "onError");
                }
            });
        }catch (Exception e) {
            Log.e("button.claim", e.getMessage());
        }
    }*/


}

