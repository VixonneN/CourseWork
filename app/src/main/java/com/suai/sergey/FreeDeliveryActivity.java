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

import java.util.LinkedHashMap;
import java.util.Map;

public class FreeDeliveryActivity extends AppCompatActivity {

//    List<String> textSpinner = new ArrayList<>();

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
    }

    private void studentSpinner(){
        Spinner studSpinner = findViewById(R.id.sv2);
        StudentSpinnerAdapter studentSpinnerAdapter = new StudentSpinnerAdapter(this, FakeDataClass.INSTANCE.getStudentList());
        studSpinner.setAdapter(studentSpinnerAdapter);
    }

    private void subjectSpinner() {
        Spinner discipline = findViewById(R.id.sv3);
        SubjectSpinnerAdapter subjectSpinnerAdapter = new SubjectSpinnerAdapter(this, FakeDataClass.INSTANCE.getSubjectList());
        discipline.setAdapter(subjectSpinnerAdapter);

    }

    private void labWorkSpinner(){
        Spinner workSpinner = findViewById(R.id.sv4);
        WorkSpinnerAdapter workSpinnerAdapter = new WorkSpinnerAdapter(this, FakeDataClass.INSTANCE.getWorkList());
        workSpinner.setAdapter(workSpinnerAdapter);

    }

    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFree);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Тут должен быть ответ в базу данных :D");
//                Toast.makeText(FreeDeliveryActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
