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
import com.suai.sergey.databases.subjectDatabase.Subject;
import com.suai.sergey.fix_package.FixGroupAndSubjectActivity;
import com.suai.sergey.free_package.FreeDeliveryActivity;
import com.suai.sergey.network.data_classes.StudentsData;
import com.suai.sergey.network.data_classes.SubjectData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String idStudent, firstName, secondName, lastName, idGroup, numberGroup, idSubject, nameSubject, typeSubject;

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
                        idStudent = data.get(i).getId();
                        firstName = data.get(i).getFirstName();
                        secondName = data.get(i).getSecondName();
                        lastName = data.get(i).getLastName();

                        idGroup = data.get(i).getGroupsData().getId();
                        numberGroup = data.get(i).getGroupsData().getNumber();

                        Student student = createStudent(idStudent, firstName, secondName, lastName, idGroup);
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

        getApp().getApi().getAllSubjects().enqueue(new Callback<List<SubjectData>>() {
            @Override
            public void onResponse(Call<List<SubjectData>> call, Response<List<SubjectData>> response) {
                List<SubjectData> data = response.body();
                if(data != null){
                    for (int i = 0; i < data.size(); i++){
                        idSubject = data.get(i).getId();
                        nameSubject = data.get(i).getName();
                        typeSubject = data.get(i).getType();

                        Subject subject = createSubject(idSubject, nameSubject, typeSubject);
                        AppDatabase.getAppDatabase(MainActivity.this).worksDao().insertSubject(subject);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<SubjectData>> call, Throwable t) {

            }
        });
    }

    private Subject createSubject(String id, String name, String type){
        Subject subject = new Subject();
        subject.setId(id);
        subject.setName(name);
        subject.setType(type);
        return subject;
    }

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
        Button freeDeliveryButton = findViewById(R.id.free_delivery);
        freeDeliveryButton.setOnClickListener(v -> openFreeDeliveryActivity());

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

    private void openFreeDeliveryActivity(){
        FreeDeliveryActivity.start(this);
    }

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}