package com.suai.sergey;

import android.app.Application;

import com.suai.sergey.network.Api;
import com.suai.sergey.network.NetworkModule;

public class App extends Application {

    private Api api;

    @Override
    public void onCreate() {
        super.onCreate();

        api = new NetworkModule().getApi();
    }

    public Api getApi(){
        return api;
    }
}
