package com.suai.sergey;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
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
import java.util.List;

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
        markSpinner();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void GroupSpinner(){
        Spinner groupSpinner = findViewById(R.id.sv1);
        GroupSpinnerAdapter groupSpinnerAdapter = new GroupSpinnerAdapter(this, FakeDataClass.INSTANCE.getGroupList());
        groupSpinner.setAdapter(groupSpinnerAdapter);

        groupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    NumberGroup nb = (NumberGroup) parent.getItemAtPosition(position);
                    String item = String.valueOf(nb.getNumber());
                    makeToast(item);
                textSpinner.add(0, item);
                }
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
                if (position != 0) {
                    FioStudent fioStudent = (FioStudent) parent.getItemAtPosition(position);
                textSpinner.add(1, fioStudent.getFio());
                    String item = String.valueOf(fioStudent.getFio());
                    makeToast(item);
                }
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
                if (position != 0) {
                    SubjectName subjectName = (SubjectName) parent.getItemAtPosition(position);
                    String item = String.valueOf(subjectName.getName());
                    makeToast(item);
                textSpinner.add(2, subjectName.getName());
                }
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
                if (position != 0) {
                    NameWork nameWork = (NameWork) parent.getItemAtPosition(position);
                textSpinner.add(3, nameWork.getName());
                    String item = String.valueOf(nameWork.getName());
                    makeToast(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void markSpinner(){
        Spinner markSpinner = findViewById(R.id.markSpinnerFree);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.marks , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        markSpinner.setAdapter(adapter);
        markSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
//                textSpinner.add(4, item);
                makeToast(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFree);
        fixDelivery.setOnClickListener(v -> {
//                makeToast("Тут должен быть ответ в базу данных :D");
            String getMap = textSpinner.get(0) + " " + textSpinner.get(1) + " " + textSpinner.get(2) + " " + textSpinner.get(3) + " c оценкой " /*+ textSpinner.get(4)*/;
            makeToast(getMap);
        });
    }

    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
