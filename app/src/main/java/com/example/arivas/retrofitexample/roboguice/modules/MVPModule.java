package com.example.arivas.retrofitexample.roboguice.modules;

import android.app.Application;

import com.example.arivas.retrofitexample.interfaces.presenters.MainActivityPresenterI;
import com.example.arivas.retrofitexample.presenters.MainActivityPresenter;
import com.google.inject.AbstractModule;

/**
 * Created by arivas on 09/08/2016.
 */
public class MVPModule extends AbstractModule {

    private Application application;

    public MVPModule() {
    }

    public MVPModule(Application application) {
        this.application = application;
    }

    @Override
    protected void configure() {
        bind(MainActivityPresenterI.class).to(MainActivityPresenter.class);
    }

}
