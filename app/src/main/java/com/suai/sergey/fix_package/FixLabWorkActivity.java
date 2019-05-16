package com.suai.sergey.fix_package;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.suai.sergey.R;
import com.suai.sergey.databases.workDatabase.NameWork;
import com.suai.sergey.databases.workDatabase.NumberWork;
import com.suai.sergey.fix_package.recycle_view_labWork.FixLabWorkAdapter;
import com.suai.sergey.fix_package.recycle_view_labWork.LabWorks;

import java.util.ArrayList;
import java.util.List;

public class FixLabWorkActivity extends AppCompatActivity {

    private NameWork nameWork;
    private NumberWork numberWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_lab_work);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        addRecycleView();

    }

    private void addRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.rv_lab_works);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new FixLabWorkAdapter(generateLabWork());//npe
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

    private List<LabWorks> generateLabWork() {
        List<LabWorks> labWorksList = new ArrayList<>();
        String works = String.valueOf(nameWork.getName());//npe
        String numberWorks = String.valueOf(numberWork.getNumber());//npe
        labWorksList.add(new LabWorks(numberWorks, works, 3, true));
        return labWorksList;
    }

    public static void start(Activity activity, String numberGroup, String nameSubject, String nameStudent) {
        Intent fixLabWork = new Intent(activity, FixLabWorkActivity.class);
        fixLabWork.putExtra("numberGroup", numberGroup);
        fixLabWork.putExtra("nameSubject", nameSubject);
        fixLabWork.putExtra("nameStudent", nameStudent);
        activity.startActivity(fixLabWork);
    }


}