package com.suai.sergey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class FixDeliveryActivity extends AppCompatActivity {

    public static String students[] = {" ", "Петров", "Иванов", "Сидоров"};
    public static String labWork[] = {" ", "1", "2", "3"};

//    Intent intent = getIntent();
//    ArrayList<String> textSpinner = intent.getStringArrayListExtra("com.suai.sergey.FixDeliveryActivity");
    ArrayList<String> textSpinner = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_delivery);
        textSpinner = getIntent().getExtras().getStringArrayList("com.suai.sergey.MainActivity");
        studentSpinner();
        labWorkSpinner();
        deliveryButton();
    }

    private void studentSpinner(){
        Spinner studSpinner = findViewById(R.id.sd1);
        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, students);
        studentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studSpinner.setAdapter(studentAdapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.add(2, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        studSpinner.setOnItemSelectedListener(onItemSelectedListener);

    }

    private void labWorkSpinner(){
        final Spinner classSpinner = findViewById(R.id.sd2);
        final ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, labWork);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.add(3, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        classSpinner.setOnItemSelectedListener(onItemSelectedListener);

    }

    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFix);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = textSpinner.get(0) + " " + textSpinner.get(1) + " " + textSpinner.get(2) + " " + textSpinner.get(3);
                makeToast(getText);
            }
        });
    }
    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
