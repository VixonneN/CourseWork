package com.suai.sergey;

import android.app.Activity;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.groupDatabase.Group;
import com.suai.sergey.databases.studentDatabase.Student;
import com.suai.sergey.fix_package.FixGroupAndSubjectActivity;
import com.suai.sergey.network.data_classes.StudentsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String id, firstName, secondName, lastName, idGroup, numberGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fixDeliveryButton();
        freeDeliveryButton();
        networkResponse();
    }

    private void networkResponse() {
        getApp().getApi().getStudents().enqueue(new Callback<List<StudentsData>>() {
            @Override
            public void onResponse(Call<List<StudentsData>> call, Response<List<StudentsData>> response) {
                List<StudentsData> data = response.body();
                if (data != null) {
                    for (int i = 0; i < data.size(); i++) {
                        id = data.get(i).getId();
                        firstName = data.get(i).getFirstName();
                        secondName = data.get(i).getSecondName();
                        lastName = data.get(i).getLastName();

                        idGroup = data.get(i).getGroupsData().getId();
                        numberGroup = data.get(i).getGroupsData().getNumber();

                        Student student = createStudent(id, firstName, secondName, lastName, idGroup);
                        AppDatabase.getAppDatabase(MainActivity.this).worksDao().insertStudent(student);

                        Group group = createGroup(idGroup, numberGroup);
                        AppDatabase.getAppDatabase(MainActivity.this).worksDao().insertGroup(group);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<StudentsData>> call, Throwable t) {
                makeToast("fail");
            }
        });
    }//    @Query("select number_work from work")
//    List<NumberGroup> getNumberGroup();

//    //добавление данных в бд списком
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertGroup(Group... groups);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertStudent(List<FioStudent> students);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertSubject(Subject... subjects);
//


    private Student createStudent(String id, String firstName, String secondName, String lastName, String idGroup) {
        Student student = new Student();
        student.setId(id);
        student.setFirstName(firstName);
        student.setSecondName(secondName);
        student.setLastName(lastName);
        student.setIdGroup(idGroup);
        return student;
    }

    private Group createGroup(String id, String numberGroup){
        Group group = new Group();
        group.setId(id);
        group.setNumberGroup(numberGroup);
        return group;
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void fixDeliveryButton() {
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(v -> openFixDeliveryActivity());
    }

    private void freeDeliveryButton() {
    }

    private void makeToast(@SuppressWarnings("SameParameterValue") String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private App getApp() {
        return ((App) getApplication());
    }

    private void openFixDeliveryActivity() {
        FixGroupAndSubjectActivity.start(this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}