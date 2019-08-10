package com.suai.sergey.fix_package;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.groupDatabase.Group;
import com.suai.sergey.databases.subjectDatabase.SubjectName;

public class FixGroupAndSubjectActivity extends AppCompatActivity {

    private Spinner subjectSpinner, groupSpinner;
    private String nameSubject;
    private String numberGroup, idSpinner, idGroup;
    private boolean isFlagGroup;
    private boolean isFlagSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_and_subject);

        subjectSpinner = findViewById(R.id.s2);
        groupSpinner = findViewById(R.id.group_MA);

        getIntents();
        groupAdapterSpinner();
        subjectAdapterSpinner();
        deliveryButton();
        actionBar();
    }

    private void getIntents(){
        idSpinner = getIntent().getStringExtra("idSpinner");
        Toast.makeText(this, idSpinner, Toast.LENGTH_SHORT).show();
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

    //выпадающие списки
    private void groupAdapterSpinner() {
        //заменить группу
        GroupSpinnerAdapter spinnerAdapter = new GroupSpinnerAdapter(this, AppDatabase.getAppDatabase(this).worksDao().getNumber());
        groupSpinner.setAdapter(spinnerAdapter);
        groupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    //флаг для перехода
                    isFlagGroup = true;
                    Group ng = (Group) parent.getItemAtPosition(position);
                    numberGroup = String.valueOf(ng.getNumberGroup());
                    idGroup = (ng.getId());
                    subjectSpinner.setVisibility(View.VISIBLE);
                } else {
                    isFlagGroup = false;
                    subjectSpinner.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void subjectAdapterSpinner() {
        SubjectSpinnerAdapter spinnerAdapter = new SubjectSpinnerAdapter(this, FakeDataClass.INSTANCE.getSubjectList());
        subjectSpinner.setAdapter(spinnerAdapter);

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    isFlagSubject = true;
                    SubjectName subject = (SubjectName) parent.getItemAtPosition(position);
                    nameSubject = String.valueOf(subject.getName());
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
            if (isFlagGroup && isFlagSubject) {
                openFixStudentActivity();
            } else {
                makeToast("Выберите группу и предмет");
            }
        });
    }

    public static void start(Activity activity){
        Intent intent = new Intent(activity, FixGroupAndSubjectActivity.class);
        activity.startActivity(intent);
    }


    public void openFixStudentActivity() {
        FixStudentsActivity.start(this, numberGroup, nameSubject, idGroup);
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}