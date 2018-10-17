package com.suai.sergey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    public static String[] cClass = {" ","4741", "4742", "4743"};
    public static String[] academicSubject = {" ","Основы программирования", "Физика", "Электротехника", "Социология", "Прикладная физическая культура", "Английский язык"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classAdapterSpinner();
        academicAdapterSpinner();
        fixDeliveryButton();
        freeDeliveryButton();
    }

    private void classAdapterSpinner(){
        Spinner classSpinner = findViewById(R.id.group_MA);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cClass);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
//        OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String item = (String)parent.getItemAtPosition(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        };
//        classSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }
    
    private void academicAdapterSpinner(){
        Spinner discipline = findViewById(R.id.s2);
        ArrayAdapter<String> disciplineAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, academicSubject);
        disciplineAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discipline.setAdapter(disciplineAdapter);
//        OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String item = (String)parent.getItemAtPosition(position);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        };
//        discipline.setOnItemSelectedListener(onItemSelectedListener);
    }

    private void fixDeliveryButton(){
        final Intent fixDeliveryIntent = new Intent(MainActivity.this, FixDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fixDeliveryIntent);
            }
        });
    }

    private void freeDeliveryButton(){
        final Intent freeDeliveryIntent = new Intent(MainActivity.this, FreeDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.free_delivery);
        fixDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(freeDeliveryIntent);
            }
        });
    }
}
