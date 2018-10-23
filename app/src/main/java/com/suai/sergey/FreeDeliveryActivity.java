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

import java.util.LinkedHashMap;
import java.util.Map;

import static com.suai.sergey.FixDeliveryActivity.students;
import static com.suai.sergey.MainActivity.cClass;
import static com.suai.sergey.MainActivity.academicSubject;
import static com.suai.sergey.FixDeliveryActivity.labWork;

public class FreeDeliveryActivity extends AppCompatActivity {

//    List<String> textSpinner = new ArrayList<>();

    @SuppressLint("UseSparseArrays")
    Map<Integer, String> textSpinner = new LinkedHashMap<>();


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
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.put(0, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        classSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    private void studentSpinner(){
        Spinner studSpinner = findViewById(R.id.sv2);
        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, students);
        studentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studSpinner.setAdapter(studentAdapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.put(1, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        studSpinner.setOnItemSelectedListener(onItemSelectedListener);

    }

    private void academicAdapterSpinner() {
        Spinner discipline = findViewById(R.id.sv3);
        ArrayAdapter<String> disciplineAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, academicSubject);
        disciplineAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discipline.setAdapter(disciplineAdapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.put(2, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        discipline.setOnItemSelectedListener(onItemSelectedListener);

    }

    private void labWorkSpinner(){
        Spinner classSpinner = findViewById(R.id.sv4);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, labWork);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.put(3,item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        classSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFree);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getMap = textSpinner.get(0) + " " + textSpinner.get(1) + " " + textSpinner.get(2) + " " + textSpinner.get(3);
                makeToast(getMap);
//                Toast.makeText(FreeDeliveryActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
