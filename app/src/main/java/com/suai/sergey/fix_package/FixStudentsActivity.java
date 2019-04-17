package com.suai.sergey.fix_package;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.suai.sergey.FakeDataClass;
import com.suai.sergey.R;
import com.suai.sergey.adapters.StudentSpinnerAdapter;
import com.suai.sergey.databases.studentDatabase.FioStudent;

public class FixStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_students);

        studentSpinner();
        fixDeliveryButton();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void studentSpinner() {
        Spinner studSpinner = findViewById(R.id.fix_student);
        StudentSpinnerAdapter studentSpinnerAdapter = new StudentSpinnerAdapter(this, FakeDataClass.INSTANCE.getStudentList());
        studSpinner.setAdapter(studentSpinnerAdapter);

        studSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    FioStudent fioStudent = (FioStudent) parent.getItemAtPosition(position);
                    String item = String.valueOf(fioStudent.getFio());
                    makeToast(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void fixDeliveryButton() {
        final Intent fixDeliveryIntent = new Intent(this, FixLabWorkActivity.class);
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(fixDeliveryIntent));
    }


    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
