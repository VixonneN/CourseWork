package com.suai.sergey.fix_package;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.suai.sergey.R;
import com.suai.sergey.databases.workDatabase.NameWork;

import java.util.ArrayList;
import java.util.List;

public class FixLabWorkActivity extends AppCompatActivity {

    private NameWork nameWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_lab_work);

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

    private List<LabWorks> generateLabWork(){
        List<LabWorks> labWorksList = new ArrayList<>();
        String works = String.valueOf(nameWork.getName());
        labWorksList.add(new LabWorks(0, works, 3, true));
        return labWorksList;
    }

}