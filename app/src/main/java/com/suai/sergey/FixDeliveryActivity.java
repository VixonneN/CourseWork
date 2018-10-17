package com.suai.sergey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class FixDeliveryActivity extends AppCompatActivity {

    public static String students[] = {" ", "Петров", "Иванов", "Сидоров"};
    public static String labWork[] = {" ", "1", "2", "3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_delivery);
        studentSpinner();
        labWorkSpinner();
        deliveryButton();
    }

    private void studentSpinner(){
        Spinner studSpinner = findViewById(R.id.sd1);
        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, students);
        studentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studSpinner.setAdapter(studentAdapter);
    }

    private void labWorkSpinner(){
        Spinner classSpinner = findViewById(R.id.sd2);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, labWork);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
    }

    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFix);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FixDeliveryActivity.this, "Работа типо сдана :)", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
