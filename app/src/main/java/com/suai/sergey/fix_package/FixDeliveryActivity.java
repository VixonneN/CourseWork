package com.suai.sergey.fix_package;

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
import com.suai.sergey.adapters.GroupSpinnerAdapter;
import com.suai.sergey.adapters.SubjectSpinnerAdapter;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.subjectDatabase.SubjectName;

public class FixDeliveryActivity extends AppCompatActivity {

    private String name;
    private String number;
    private boolean isFlagGroup;
    private boolean isFlagSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_delivery);

        classAdapterSpinner();
        academicAdapterSpinner();

        deliveryButton();

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

    //выпадающие списки
    private void classAdapterSpinner() {
        Spinner classSpinner = findViewById(R.id.group_MA);
        GroupSpinnerAdapter spinnerAdapter = new GroupSpinnerAdapter(this, FakeDataClass.INSTANCE.getGroupList());

        classSpinner.setAdapter(spinnerAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    //флаг для перехода
                    isFlagGroup = true;
                    NumberGroup ng = (NumberGroup) parent.getItemAtPosition(position);
                    String item = String.valueOf(ng.getNumber());
//                    textSpinner.add(0, item);
                    number = item;
                    makeToast(item);
                } else {
                    isFlagGroup = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void academicAdapterSpinner() {
        Spinner discipline = findViewById(R.id.s2);
        SubjectSpinnerAdapter spinnerAdapter = new SubjectSpinnerAdapter(this, FakeDataClass.INSTANCE.getSubjectList());
        discipline.setAdapter(spinnerAdapter);

        discipline.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    isFlagSubject = true;
                    SubjectName subject = (SubjectName) parent.getItemAtPosition(position);
                    String item = String.valueOf(subject.getName()); //
                    name = item;
                    Toast.makeText(FixDeliveryActivity.this, item, Toast.LENGTH_SHORT).show();
                } else {
                    isFlagSubject = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void deliveryButton() {
        Button fixDelivery = findViewById(R.id.deliveryBtnFix);
        fixDelivery.setOnClickListener(v -> {
            if (isFlagGroup && isFlagSubject){
                openFixStudentActivity();
            } else {
                makeToast("Выберите группу и предмет");
            }
        });
    }

    public void openFixStudentActivity() {
        FixStudentsActivity.start(this, number, name);
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}