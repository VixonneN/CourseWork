package com.suai.sergey.fix_package;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.suai.sergey.FakeDataClass;
import com.suai.sergey.R;
import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.studentDatabase.Student;
import com.suai.sergey.fix_package.recycle_view_students.FixStudentAdapter;
import com.suai.sergey.fix_package.recycle_view_students.StudentsData;

import java.util.ArrayList;
import java.util.List;

public class FixStudentsActivity extends AppCompatActivity {

    private String nameStudent;
    private TextView numberGroup;
    private TextView nameSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_students);

        numberGroup = findViewById(R.id.tv_labwork_group);
        nameSubject = findViewById(R.id.tv_discipline);

        getIntents();
        actionBar();
        addRecycleView();
    }

    private void getIntents(){
        String number = getIntent().getStringExtra("numberGroup");
        String name = getIntent().getStringExtra("nameSubject");

        numberGroup.setText(number);
        nameSubject.setText(name);
    }

    private void addRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.fix_students_recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FixStudentAdapter.OnItemClickListener onItemClickListener = (studentsData, position) -> {
            String numberGroups =  numberGroup.getText().toString();
            String nameSubjects = nameSubject.getText().toString();
            nameStudent = studentsData.getNameStudent();
            FixLabWorkActivity.start(FixStudentsActivity.this, numberGroups, nameSubjects, nameStudent);
        };

        recyclerView.setAdapter(new FixStudentAdapter(writeDBStudents(), onItemClickListener));
    }

    private void actionBar(){
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

    public static void start(Activity activity, String number, String name){
        Intent fixStudentIntent = new Intent(activity, FixStudentsActivity.class);
        fixStudentIntent.putExtra("numberGroup", number);
        fixStudentIntent.putExtra("nameSubject", name);
        activity.startActivity(fixStudentIntent);
    }

    private List<StudentsData> writeDBStudents(){
        List<StudentsData> studentsDataList = new ArrayList<>();
        for (int i = 0; i < FakeDataClass.INSTANCE.getStudentList().size(); i++){
            studentsDataList.add(new StudentsData(i + 1, String.valueOf(FakeDataClass.INSTANCE.getStudentList().get(i).getFio())));
        }
        return studentsDataList;
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
