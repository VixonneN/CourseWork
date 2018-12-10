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

import com.suai.sergey.adapters.StudentSpinnerAdapter;
import com.suai.sergey.adapters.WorkSpinnerAdapter;

import java.util.ArrayList;

public class FixDeliveryActivity extends AppCompatActivity {


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
        StudentSpinnerAdapter studentSpinnerAdapter = new StudentSpinnerAdapter(this, FakeDataClass.INSTANCE.getStudentList());
        studSpinner.setAdapter(studentSpinnerAdapter);

        studSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position).toString();
                textSpinner.add(2, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void labWorkSpinner(){
        final Spinner workSpinner = findViewById(R.id.sd2);
        WorkSpinnerAdapter workSpinnerAdapter = new WorkSpinnerAdapter(this, FakeDataClass.INSTANCE.getWorkList());
        workSpinner.setAdapter(workSpinnerAdapter);

        workSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position).toString();
                textSpinner.add(3, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //нужно изменить
    private void deliveryButton(){
        Button fixDelivery = findViewById(R.id.deliveryBtnFix);
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