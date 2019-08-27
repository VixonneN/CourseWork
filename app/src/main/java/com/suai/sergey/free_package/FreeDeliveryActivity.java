package com.suai.sergey.free_package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.suai.sergey.R;
import com.suai.sergey.adapters.GroupSpinnerAdapter;
import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.groupDatabase.Group;

public class FreeDeliveryActivity extends AppCompatActivity {

    private Spinner numberGroupSpinner, nameStudentSpinner;
    private String numberGroup, idGroup;
    private boolean isFlagGroup;
    private boolean isFlagSubject;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_delivery);

        numberGroupSpinner = findViewById(R.id.sv1);
        nameStudentSpinner = findViewById(R.id.sv2);

        groupSpinner();
        actionBar();
    }

    private void actionBar() {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void start(Activity activity){
        Intent intent = new Intent(activity, FreeDeliveryActivity.class);

        activity.startActivity(intent);
    }

    private void groupSpinner(){
        GroupSpinnerAdapter spinnerAdapter = new GroupSpinnerAdapter(this, AppDatabase.getAppDatabase(this).worksDao().getNumber());
        numberGroupSpinner
                .setAdapter(spinnerAdapter);
        numberGroupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    //флаг для перехода
                    Group group = (Group) parent.getItemAtPosition(position);
                    numberGroup = String.valueOf(group.getNumberGroup());
                    idGroup = (group.getId());
                    isFlagGroup = true;
                } else {
                    isFlagGroup = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void studentSpinner(){
        GroupSpinnerAdapter spinnerAdapter = new GroupSpinnerAdapter(this, AppDatabase.getAppDatabase(this).worksDao().getNumber());
        numberGroupSpinner
                .setAdapter(spinnerAdapter);
        numberGroupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    //флаг для перехода
                    Group group = (Group) parent.getItemAtPosition(position);
                    numberGroup = String.valueOf(group.getNumberGroup());
                    idGroup = (group.getId());
                    isFlagGroup = true;
                } else {
                    isFlagGroup = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
