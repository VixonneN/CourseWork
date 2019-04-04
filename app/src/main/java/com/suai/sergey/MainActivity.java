package com.suai.sergey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.suai.sergey.adapters.GroupSpinnerAdapter;
import com.suai.sergey.adapters.SubjectSpinnerAdapter;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.subjectDatabase.SubjectName;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> textSpinner = new ArrayList<>();//?

    public static final String ARRAYLISTEXTRA = "com.suai.sergey.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classAdapterSpinner();
        academicAdapterSpinner();
        fixDeliveryButton();
        freeDeliveryButton();
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
                    Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //кнопки
    //TODO должен быть запрос, который посылает данные, выбранные в спиннерах
    private void fixDeliveryButton() {
        final Intent fixDeliveryIntent = new Intent(MainActivity.this, FixDeliveryActivity.class);
        fixDeliveryIntent.putStringArrayListExtra(ARRAYLISTEXTRA, textSpinner);
        Button fixDelivery = findViewById(R.id.fix_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(fixDeliveryIntent));
    }

    private void freeDeliveryButton() {
        final Intent freeDeliveryIntent = new Intent(MainActivity.this, FreeDeliveryActivity.class);
        Button fixDelivery = findViewById(R.id.free_delivery);
        fixDelivery.setOnClickListener(v -> startActivity(freeDeliveryIntent));
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}