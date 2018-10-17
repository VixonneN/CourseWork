package com.suai.sergey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static com.suai.sergey.FixDeliveryActivity.students;
import static com.suai.sergey.MainActivity.cClass;
import static com.suai.sergey.MainActivity.academicSubject;
import static com.suai.sergey.FixDeliveryActivity.labWork;

public class FreeDeliveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_delivery);
        classAdapterSpinner();
        studentSpinner();
        academicAdapterSpinner();
        labWorkSpinner();
        deliveryButton();
    }

    private void classAdapterSpinner(){
        Spinner classSpinner = findViewById(R.id.sv1);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cClass);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);

    }

    private void studentSpinner(){
        Spinner studSpinner = findViewById(R.id.sv2);
        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, students);
        studentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studSpinner.setAdapter(studentAdapter);
    }

    private void academicAdapterSpinner() {
        Spinner discipline = findViewById(R.id.sv3);
        ArrayAdapter<String> disciplineAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, academicSubject);
        disciplineAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discipline.setAdapter(disciplineAdapter);
    }

    private void labWorkSpinner(){
        Spinner classSpinner = findViewById(R.id.sv4);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, labWork);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
    }

    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFree);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FreeDeliveryActivity.this, "Работа типо сдана :)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
