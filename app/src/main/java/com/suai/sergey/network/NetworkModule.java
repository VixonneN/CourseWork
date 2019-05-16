package com.suai.sergey.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {

    private final Api api;

    public NetworkModule(){
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        final Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public Api api(){
        return api;
    }

}
