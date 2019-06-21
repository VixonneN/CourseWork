package com.suai.sergey.network;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {

    private final Api api;

    public NetworkModule() {
        final Gson gson = provideGson();
        final OkHttpClient okHttpClient = provideOkHttpClient();
        final Retrofit retrofit = provideRetrofit(okHttpClient, gson);

        api = provideApi(retrofit);
    }

    public Api getApi() {
        return api;
    }

    private OkHttpClient provideOkHttpClient() {

        final HttpLoggingInterceptor.Logger logger = message -> Log.d("OkHttp", message);

        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger) //
                .setLevel(HttpLoggingInterceptor.Level.HEADERS);

        return new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    private Gson provideGson() {
        return new GsonBuilder().create();
    }

    private Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    private Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

}
