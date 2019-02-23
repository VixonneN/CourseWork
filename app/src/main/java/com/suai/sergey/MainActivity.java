package com.suai.sergey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.suai.sergey.adapters.GroupArrayAdapter;
import com.suai.sergey.adapters.GroupSpinnerAdapter;
import com.suai.sergey.adapters.SubjectSpinnerAdapter;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.subjectDatabase.SubjectName;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> textSpinner = new ArrayList<>();//?
    private List<NumberGroup> numberGroups = new List<>();
    List<String> groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classAdapterSpinner();
        academicAdapterSpinner();
        fixDeliveryButton();
        freeDeliveryButton();
    }

    private List<String> listToString(){
        List<String> groups = new ArrayList<>();
        groups.add("");
        for (NumberGroup number : numberGroups) {
            groups.add(String.valueOf(number.getNumber()));
        }
        return groups;
    }

    //выпадающие списки
    private void classAdapterSpinner(){
        Spinner classSpinner = findViewById(R.id.group_MA);
        GroupSpinnerAdapter spinnerAdapter = new GroupSpinnerAdapter(this, FakeDataClass.INSTANCE.getGroupList());

        classSpinner.setAdapter(spinnerAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                groupToString() = (String) parent.getItemAtPosition(position);
//                NumberGroup ng = (NumberGroup)parent.getItemAtPosition(position);
//                List<String> groups = new ArrayList<>();
//                groups.add("");
//                for (NumberGroup number : numberGroups) {
//                    groups.add(String.valueOf(number.getNumber()));
//                }
                groups = (List<String>) parent.getItemAtPosition(position);
                String item = String.valueOf(groups);
                textSpinner.add(0, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }

    private void academicAdapterSpinner(){
        Spinner discipline = findViewById(R.id.s2);
        SubjectSpinnerAdapter spinnerAdapter = new SubjectSpinnerAdapter(this, FakeDataClass.INSTANCE.getSubjectList());
        discipline.setAdapter(spinnerAdapter);

        discipline.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String item = (String)parent.getItemAtPosition(position).toString();
                SubjectName subject = (SubjectName) parent.getItemAtPosition(position);
                String item = String.valueOf(subject.getName());
                textSpinner.add(1, item);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //кнопки
    private void fixDeliveryButton(){
        final Intent fixDeliveryIntent = new Intent(MainActivity.this, FixDeliveryActivity.class);
        fixDeliveryIntent.putStringArrayListExtra("com.suai.sergey.MainActivity", textSpinner);
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(fixDeliveryIntent));
    }

    private void freeDeliveryButton(){
        final Intent freeDeliveryIntent = new Intent(MainActivity.this, FreeDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.free_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(freeDeliveryIntent));
    }
}