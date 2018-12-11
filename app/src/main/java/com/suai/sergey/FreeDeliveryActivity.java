package com.suai.sergey;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.suai.sergey.adapters.GroupSpinnerAdapter;
import com.suai.sergey.adapters.StudentSpinnerAdapter;
import com.suai.sergey.adapters.SubjectSpinnerAdapter;
import com.suai.sergey.adapters.WorkSpinnerAdapter;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.studentDatabase.FioStudent;
import com.suai.sergey.databases.subjectDatabase.SubjectName;
import com.suai.sergey.databases.workDatabase.NameWork;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FreeDeliveryActivity extends AppCompatActivity {

    List<String> textSpinner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_delivery);
        GroupSpinner();
        studentSpinner();
        subjectSpinner();
        labWorkSpinner();
        deliveryButton();
    }

    private void GroupSpinner(){
        Spinner groupSpinner = findViewById(R.id.sv1);
        GroupSpinnerAdapter groupSpinnerAdapter = new GroupSpinnerAdapter(this, FakeDataClass.INSTANCE.getGroupList());
        groupSpinner.setAdapter(groupSpinnerAdapter);

        groupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                NumberGroup nb = (NumberGroup) parent.getItemAtPosition(position);
                String item = String.valueOf(nb.getNumber());
                textSpinner.add(0, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void studentSpinner(){
        Spinner studSpinner = findViewById(R.id.sv2);
        StudentSpinnerAdapter studentSpinnerAdapter = new StudentSpinnerAdapter(this, FakeDataClass.INSTANCE.getStudentList());
        studSpinner.setAdapter(studentSpinnerAdapter);

        studSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FioStudent fioStudent = (FioStudent) parent.getItemAtPosition(position);
                textSpinner.add(1, fioStudent.getFio());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void subjectSpinner() {
        Spinner discipline = findViewById(R.id.sv3);
        SubjectSpinnerAdapter subjectSpinnerAdapter = new SubjectSpinnerAdapter(this, FakeDataClass.INSTANCE.getSubjectList());
        discipline.setAdapter(subjectSpinnerAdapter);

        discipline.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SubjectName subjectName = (SubjectName) parent.getItemAtPosition(position);
                textSpinner.add(2, subjectName.getName());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void labWorkSpinner(){
        Spinner workSpinner = findViewById(R.id.sv4);
        WorkSpinnerAdapter workSpinnerAdapter = new WorkSpinnerAdapter(this, FakeDataClass.INSTANCE.getWorkList());
        workSpinner.setAdapter(workSpinnerAdapter);

        workSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                NameWork nameWork = (NameWork) parent.getItemAtPosition(position);
                textSpinner.add(3, nameWork.getName());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFree);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                makeToast("Тут должен быть ответ в базу данных :D");
                String getMap = textSpinner.get(0) + " " + textSpinner.get(1) + " " + textSpinner.get(2) + " " + textSpinner.get(3);
                makeToast(getMap);
            }
        });
    }

    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
