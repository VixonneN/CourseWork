package com.suai.sergey;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.suai.sergey.adapters.TeacherSpinnerAdapter;
import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.teacherDatabase.FioTeacher;
import com.suai.sergey.databases.teacherDatabase.Teacher;
import com.suai.sergey.fix_package.FixDeliveryActivity;
import com.suai.sergey.free_package.FreeDeliveryActivity;
import com.suai.sergey.network.data_classes.TeacherData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String id, firstName, secondName, lastName, idSpinner;
    private boolean isFlagTeacher = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fixDeliveryButton();
        freeDeliveryButton();
        networkResponse();
        teacherSpinner();
    }

    private void teacherSpinner() {
        Spinner teacherSpinner = findViewById(R.id.teacher_spinner);
        TeacherSpinnerAdapter adapter = new TeacherSpinnerAdapter(this, AppDatabase.getAppDatabase(this).worksDao().getFioTeacher());
        teacherSpinner.setAdapter(adapter);
        teacherSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    FioTeacher nb = (FioTeacher) parent.getItemAtPosition(position);
                    idSpinner = String.valueOf(nb.getId());
                    isFlagTeacher = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void networkResponse() {
        getApp().getApi().getTeachers().enqueue(new Callback<List<TeacherData>>() {
            @Override
            public void onResponse(@NonNull Call<List<TeacherData>> call, @NonNull Response<List<TeacherData>> response) {
                if (response.isSuccessful()) {
                    List<TeacherData> data = response.body();
                    assert data != null;

                    for (int i = 0; i < data.size(); i++) {
                        id = data.get(i).getId();
                        firstName = data.get(i).getFirstName();
                        secondName = data.get(i).getSecondName();
                        lastName = data.get(i).getLastName();

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

    private void fixDeliveryButton() {
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(v -> {
            if (isFlagTeacher) {
                openFixDeliveryActivity();
            } else {
                makeToast("Выберите преподавателя");
            }
        });
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

    private void openFixDeliveryActivity() {
        FixDeliveryActivity.start(this, idSpinner);
    }
}