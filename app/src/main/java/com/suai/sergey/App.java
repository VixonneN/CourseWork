package com.suai.sergey;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.suai.sergey.network.Api;
import com.suai.sergey.network.NetworkModule;

public class App extends Application {

    private Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        api = new NetworkModule().getApi();
    }

    public Api getApi(){
        return api;
    }
}
