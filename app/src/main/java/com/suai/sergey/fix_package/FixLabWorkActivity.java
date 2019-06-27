package com.suai.sergey.fix_package;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.suai.sergey.R;
import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.fix_package.recycle_view_labWork.FixLabWorkAdapter;
import com.suai.sergey.fix_package.recycle_view_labWork.LabWorks;

import java.util.ArrayList;
import java.util.List;

public class FixLabWorkActivity extends AppCompatActivity {

    private TextView numberGroup, nameSubject, fioStudent;
    private String number, name, fio;
    private FixLabWorkAdapter labWorkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_lab_work);

        numberGroup = findViewById(R.id.tv_labwork_group);
        nameSubject = findViewById(R.id.tv_labWork_discipline);
        fioStudent = findViewById(R.id.tv_labWork_student);

        getIntents();
        actionBar();
        addRecycleView();

    }

    private void actionBar(){
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void getIntents(){
        number = getIntent().getStringExtra("numberGroup");
        name = getIntent().getStringExtra("nameSubject");
        fio = getIntent().getStringExtra("nameStudent");

        numberGroup.setText(number);
        nameSubject.setText(name);
        fioStudent.setText(fio);
    }

    private void addRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.rv_lab_works);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new FixLabWorkAdapter(generateLabWork());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    private List<LabWorks> generateLabWork() {
//        List<LabWorks> labWorksList = new ArrayList<>();
//        String works = String.valueOf(nameWork.getName());//npe
//        for (int i = 0; i < FakeDataClass.INSTANCE.getWorkList().size(); i++){
//            labWorksList.add(new LabWorks(FakeDataClass.INSTANCE.getWorkList().get(i).getNumber());
//        }
//        String numberWorks = String.valueOf(numberWork.getNumber());//npe
//        labWorksList.add(new LabWorks(numberWorks, works, 3, true));
//        return labWorksList;
//    }

    private List<LabWorks> generateLabWork(){
        List<LabWorks> labWorksList = new ArrayList<>();
        labWorksList.add(new LabWorks("1", "курсовая", 5, true));
        labWorksList.add(new LabWorks("2", "курсовая", 0, false));
        labWorksList.add(new LabWorks("3", "курсовая", 10, true));
        labWorksList.add(new LabWorks("4", "курсовая", 0, false));
        labWorksList.add(new LabWorks("5", "курсовая", 15, true));

        return labWorksList;
    }

    public static void start(Activity activity, String numberGroup, String nameSubject, String nameStudent) {
        Intent fixLabWork = new Intent(activity, FixLabWorkActivity.class);
        fixLabWork.putExtra("numberGroup", numberGroup);
        fixLabWork.putExtra("nameSubject", nameSubject);
        fixLabWork.putExtra("nameStudent", nameStudent);
        activity.startActivity(fixLabWork);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}