package com.suai.sergey;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.teacherDatabase.Teacher;
import com.suai.sergey.fix_package.FixDeliveryActivity;
import com.suai.sergey.free_package.FreeDeliveryActivity;
import com.suai.sergey.network.Api;
import com.suai.sergey.network.NetworkModule;
import com.suai.sergey.network.data_classes.TeacherData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private TeacherData teacherData;
    private TextView tvFirstName, tvSecondName, tvLastName;
    private static final String TAG = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFirstName = findViewById(R.id.firstName);
        tvSecondName = findViewById(R.id.secondName);
        tvLastName = findViewById(R.id.lastName);

        fixDeliveryButton();
        freeDeliveryButton();
        networkResponse();
    }

    private void teacherSpinner() {

    }

    private void networkResponse() {
        getApp().getApi().getTeachers().enqueue(new Callback<List<TeacherData>>() {
            @Override
            public void onResponse(@NonNull Call<List<TeacherData>> call, @NonNull Response<List<TeacherData>> response) {
                if (response.isSuccessful()) {
                    List<TeacherData> data = response.body();
                    assert data != null;
                    makeToast(String.valueOf(data.size()));
                    Log.d(TAG, String.valueOf(data.size()));

                    for (int i = 0; i < data.size(); i++) {
                        String id = data.get(i).getId();
                        String firstName = data.get(i).getFirstName();
                        String secondName = data.get(i).getSecondName();
                        String lastName = data.get(i).getLastName();

                        tvFirstName.setText(firstName);
                        tvSecondName.setText(secondName);
                        tvLastName.setText(lastName);


                        Teacher teacher = createTeacher(id, firstName, secondName, lastName);

                        AppDatabase.getAppDatabase(MainActivity.this).worksDao().insertTeacher(teacher);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<TeacherData>> call, @NonNull Throwable t) {
                makeToast("Запрос завален1");
            }
        });

//        getApp().getApi().getTeacher("c380be58-f3d9-4524-b929-7a8e219a6e66").enqueue(new Callback<TeacherData>() {
//            @Override
//            public void onResponse(@NonNull Call<TeacherData> call, @NonNull Response<TeacherData> response) {
//                if (response.isSuccessful()) {
//                    TeacherData data = response.body();
//
//                    assert data != null;
//                    String firstNameData = data.getFirstName();
//                    String secondNameData = data.getSecondName();
//                    String lastNameData = data.getLastName();
//
////                    tvFirstName.setText(firstNameData);
////                    tvSecondName.setText(secondNameData);
////                    tvLastName.setText(lastNameData);
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<TeacherData> call, @NonNull Throwable t) {
//                makeToast("запрос завален2");
//            }
//        });
    }

    private void setFioData(){
        AppDatabase.getAppDatabase(this).worksDao().getFioTeacher();
    }

    private Teacher createTeacher(String id, String firstName, String secondName, String lastName) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setFirstName(firstName);
        teacher.setSecondName(secondName);
        teacher.setLastName(lastName);
        return teacher;
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    //TODO добавить тут бд + запрос с сервера для получения данных для бд

    private void fixDeliveryButton() {
        final Intent fixDeliveryIntent = new Intent(MainActivity.this, FixDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(fixDeliveryIntent));
    }

    private void freeDeliveryButton() {
        final Intent freeDeliveryIntent = new Intent(MainActivity.this, FreeDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.free_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(freeDeliveryIntent));
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private App getApp() {
        return ((App) getApplication());
    }
}