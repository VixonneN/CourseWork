package com.suai.sergey.auth;

import android.text.TextUtils;

import com.suai.sergey.storage.PreferencesProvider;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        final String token = PreferencesProvider.getPreferences().getSavedToken();
        
        if (!TextUtils.isEmpty(token)) {
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", "Bearer " + token).build();
            return chain.proceed(authenticatedRequest);
        }

        return chain.proceed(request);
    }
}