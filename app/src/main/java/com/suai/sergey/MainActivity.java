package com.suai.sergey;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;

public class MainActivity extends AppCompatActivity {

    public static String[] cClass = {" ","4741", "4742", "4743"};
    public static String[] academicSubject = {" ","Основы программирования", "Физика", "Электротехника", "Социология", "Прикладная физическая культура", "Английский язык"};

    ArrayList<String> textSpinner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classAdapterSpinner();
        academicAdapterSpinner();
        fixDeliveryButton();
        freeDeliveryButton();
    }

    @NeedsPermission(Manifest.permission.INTERNET)
    private void classAdapterSpinner(){
        Spinner classSpinner = findViewById(R.id.group_MA);
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cClass);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.add(0, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        classSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //

    }

    private void academicAdapterSpinner(){
        Spinner discipline = findViewById(R.id.s2);
        ArrayAdapter<String> disciplineAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, academicSubject);
        disciplineAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discipline.setAdapter(disciplineAdapter);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                textSpinner.add(1, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        discipline.setOnItemSelectedListener(onItemSelectedListener);
    }

    private void fixDeliveryButton(){
        final Intent fixDeliveryIntent = new Intent(MainActivity.this, FixDeliveryActivity.class);
        fixDeliveryIntent.putStringArrayListExtra("com.suai.sergey.MainActivity", textSpinner);
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

    @OnShowRationale(Manifest.permission.INTERNET)
    void showRationaleForInternet(final PermissionRequest request){
        showDialog("In order to proceed you need to provide storage permission");
    }

    @OnPermissionDenied(Manifest.permission.INTERNET)
    void showDeniedLocation(){
        showDialog("In order to proceed you need to provide storage permission");
    }
    void showNeverAskForLocation(){
        showDialog("In order to proceed you need to provide storage permission");
    }

    @OnNeverAskAgain(Manifest.permission.INTERNET)

    private void showDialog(String message) {
        new AlertDialog.Builder(this)
                .setMessage(message)
//                .setPositiveButton(R.string.button_allow, (dialog, button) -> request.proceed())
//                .setNegativeButton(R.string.button_deny, (dialog, button) -> request.cancel())
                .show();
    }

}