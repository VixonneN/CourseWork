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
import com.suai.sergey.fix_package.recycle_view_students.FixStudentAdapter;
import com.suai.sergey.fix_package.recycle_view_students.StudentsData;

import java.util.ArrayList;
import java.util.List;

public class FixStudentsActivity extends AppCompatActivity {

    private String number;
    private String name;
    private String nameStudent;
    private TextView numberGroup;
    private TextView nameSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_students);

        numberGroup = findViewById(R.id.tv_labwork_group);
        nameSubject = findViewById(R.id.tv_discipline);

        number = getIntent().getStringExtra("numberGroup");
        name = getIntent().getStringExtra("nameSubject");

        numberGroup.setText(number);
        nameSubject.setText(name);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        addRecycleView();
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
            studentsDataList.add(new StudentsData(i, String.valueOf(FakeDataClass.INSTANCE.getStudentList().get(i).getFio())));
        }
        return studentsDataList;
    }

    public void openFixLabWOrkActivity(){
        FixLabWorkActivity.start(this, number,  name, nameStudent);
    }


    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
