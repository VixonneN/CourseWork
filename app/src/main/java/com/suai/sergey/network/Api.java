package com.suai.sergey.network;

import com.suai.sergey.network.data_classes.SubjectData;
import com.suai.sergey.network.data_classes.auth.AuthBody;
import com.suai.sergey.network.data_classes.StudentsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL = "http://10.242.166.120:8080/";

    @GET("students")
    Call<List<StudentsData>> getStudents();

    @POST("auth")
    Call<Void> getAuth(@Body AuthBody authBody);

    @GET("subjects")
    Call<List<SubjectData>> getAllSubjects();
}
