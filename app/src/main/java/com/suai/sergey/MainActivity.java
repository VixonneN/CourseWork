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

import com.suai.sergey.databases.Group;
import com.suai.sergey.databases.Student;
import com.suai.sergey.databases.Subject;
import com.suai.sergey.databases.Submission;
import com.suai.sergey.databases.Work;

import java.util.ArrayList;
import java.util.List;


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

    //выпадающие списки
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

    //кнопки
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

    //методы для заполнения таблицы
    @NonNull
    private Group createGroup(int number){
        Group group = new Group();
        group.setNumber(number);
        return group;
    }

    @NonNull
    private Student createStudent(String fio){
        Student student = new Student();
        student.setFio(fio);
        return student;
    }

    @NonNull
    private Work createWork(int number, String name){
        Work work = new Work();
        work.setName(name);
        work.setNumber(number);
        return work;
    }

    @NonNull
    private Subject createSubject(String name){
        Subject subject = new Subject();
        subject.setName(name);
        return subject;
    }

    @NonNull
    private Submission creareSubmission(String date, int mark){
        Submission submission = new Submission();
        submission.setDate(date);
        submission.setMark(mark);
        return submission;
    }

    //добавление фейковых данных
    private List<Group> getGroupList(){
        List<Group> groupList = new ArrayList<>();
        groupList.add(createGroup(4741));
        groupList.add(createGroup(4742));
        groupList.add(createGroup(4743));
        groupList.add(createGroup(4731));
        groupList.add(createGroup(4716));
        return groupList;
    }

    private List<Student> getStudentList(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(createStudent(" "));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        return studentList;
    }

    private List<Work> getWorkList(){
        List<Work> workList = new ArrayList<>();
        workList.add(createWork(1, "Вводная работа"));
        workList.add(createWork(2, "Курсовая работа"));
        workList.add(createWork(3, "Дипломная работа"));
        return workList;
    }

    private List<Subject> getSubjectList(){
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(createSubject(" "));
        subjectList.add(createSubject("Основы программирования"));
        subjectList.add(createSubject("Физика"));
        subjectList.add(createSubject("Электротехника"));
        subjectList.add(createSubject("Социология"));
        subjectList.add(createSubject("English language"));
        return subjectList;
    }

    private List<Submission> getSubmissionList(){
        List<Submission> submissionList = new ArrayList<>();
        submissionList.add(creareSubmission("21.01.18", 0));
        submissionList.add(creareSubmission("21.01.18", 1));
        submissionList.add(creareSubmission("21.01.18", 3));
        submissionList.add(creareSubmission("21.01.18", 4));
        submissionList.add(creareSubmission("21.01.18", 5));
        return submissionList;
    }
}