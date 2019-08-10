package com.suai.sergey.network.data_classes;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {
    @SerializedName("Authorization")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}