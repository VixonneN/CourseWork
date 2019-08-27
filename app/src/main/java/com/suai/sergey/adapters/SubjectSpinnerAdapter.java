package com.suai.sergey.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.suai.sergey.R;
import com.suai.sergey.databases.subjectDatabase.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectSpinnerAdapter extends BaseAdapter {


    private final LayoutInflater layoutInflater;
    private final List<Subject> subjectNames;

    public SubjectSpinnerAdapter(Context context, List<Subject> subjectNames) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.subjectNames = subjectNames;
    }

    @Override
    public int getCount() {
        return subjectNames.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return subjectNames.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List<String> subjectList = new ArrayList<>();
        subjectList.add(" ");
        for (Subject subjectName : subjectNames) {
            subjectList.add(String.valueOf(subjectName.getName()));
        }

//        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.spinner_item, parent, false);
            TextView textView = convertView.findViewById(R.id.spinner_id);
            textView.setText(String.valueOf(subjectList.get(position)));
//        }
        return convertView;
    }
}
