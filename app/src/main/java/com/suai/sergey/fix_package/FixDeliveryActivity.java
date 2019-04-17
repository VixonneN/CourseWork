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
import com.suai.sergey.adapters.GroupSpinnerAdapter;
import com.suai.sergey.adapters.SubjectSpinnerAdapter;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.subjectDatabase.SubjectName;

import java.util.ArrayList;

public class FixDeliveryActivity extends AppCompatActivity {

    ArrayList<String> textSpinner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_delivery);
//        textSpinner = getIntent().getExtras().getStringArrayList("com.suai.sergey.MainActivity");

        classAdapterSpinner();
        academicAdapterSpinner();

        deliveryButton();

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

    //выпадающие списки
    private void classAdapterSpinner() {
        Spinner classSpinner = findViewById(R.id.group_MA);
        GroupSpinnerAdapter spinnerAdapter = new GroupSpinnerAdapter(this, FakeDataClass.INSTANCE.getGroupList());

        classSpinner.setAdapter(spinnerAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    NumberGroup ng = (NumberGroup) parent.getItemAtPosition(position);
                    String item = String.valueOf(ng.getNumber());
                    textSpinner.add(0, item);
                    makeToast(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //TODO: выбирается +1 элемент, если откатывать в методе вручную, то NPE
    private void academicAdapterSpinner() {
        Spinner discipline = findViewById(R.id.s2);
        SubjectSpinnerAdapter spinnerAdapter = new SubjectSpinnerAdapter(this, FakeDataClass.INSTANCE.getSubjectList());
        discipline.setAdapter(spinnerAdapter);

        discipline.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    SubjectName subject = (SubjectName) parent.getItemAtPosition(position);
                    String item = String.valueOf(subject.getName()); //
                    textSpinner.add(1, item);
                    Toast.makeText(FixDeliveryActivity.this, item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //нужно изменить
    private void deliveryButton() {
        Button fixDelivery = findViewById(R.id.deliveryBtnFix);
        fixDelivery.setOnClickListener(v -> {
            makeToast("Тут должен быть ответ в базу данных :D");
            Intent newIntent = new Intent(this, FixStudentsActivity.class);
            startActivity(newIntent);
        });
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}