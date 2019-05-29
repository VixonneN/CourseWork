package com.suai.sergey.network;

import com.suai.sergey.network.data_classes.TeacherData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "http://my-json-server.typicode.com/aksenoff/api-test/";

    @GET("teachers")
    Call<List<TeacherData>> getTeachers();

    @GET("teachers/{id}")
    Call<TeacherData> getTeacher(@Path("id") String id);
}
