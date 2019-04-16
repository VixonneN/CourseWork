package com.suai.sergey.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.suai.sergey.FakeDataClass;
import com.suai.sergey.FixDeliveryActivity;
import com.suai.sergey.FreeDeliveryActivity;
import com.suai.sergey.R;
import com.suai.sergey.adapters.GroupSpinnerAdapter;
import com.suai.sergey.adapters.SubjectSpinnerAdapter;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.subjectDatabase.SubjectName;


import java.util.ArrayList;

public class MainFragment extends Fragment {

    ArrayList<String> textSpinner = new ArrayList<>();//?

    private Spinner classSpinner;
    private Spinner discipline;
    private Button fixDelivery;
    private Button freeDelivery;

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    public MainFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        classSpinner = view.findViewById(R.id.group_MA);
        classAdapterSpinner();
        discipline = view.findViewById(R.id.s2);
        academicAdapterSpinner();
        fixDelivery = view.findViewById(R.id.fix_delivery);
        fixDeliveryButton();
        freeDelivery = view.findViewById(R.id.free_delivery);
        freeDeliveryButton();

        return view;
    }

    private void classAdapterSpinner(){
        GroupSpinnerAdapter spinnerAdapter = new GroupSpinnerAdapter(getContext(), FakeDataClass.INSTANCE.getGroupList());

        classSpinner.setAdapter(spinnerAdapter);

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                NumberGroup ng = (NumberGroup)parent.getItemAtPosition(position);
                String item = String.valueOf(ng.getNumber());
                textSpinner.add(0, item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void academicAdapterSpinner(){
        SubjectSpinnerAdapter spinnerAdapter = new SubjectSpinnerAdapter(getContext(), FakeDataClass.INSTANCE.getSubjectList());
        discipline.setAdapter(spinnerAdapter);

        discipline.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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
        final Intent fixDeliveryIntent = new Intent(getContext(), FixDeliveryActivity.class);
        fixDeliveryIntent.putStringArrayListExtra("com.suai.sergey.MainActivity", textSpinner);
        fixDelivery.setOnClickListener(v -> startActivity(fixDeliveryIntent));
    }

    private void freeDeliveryButton(){
        final Intent freeDeliveryIntent = new Intent(getContext(), FreeDeliveryActivity.class);
        freeDelivery.setOnClickListener(v -> startActivity(freeDeliveryIntent));
    }
}
