package com.suai.sergey.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.suai.sergey.R;
import com.suai.sergey.databases.studentDatabase.FioStudent;
import com.suai.sergey.databases.studentDatabase.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentSpinnerAdapter extends BaseAdapter {


    private final LayoutInflater layoutInflater;
    private final List<Student> studentList;

    public StudentSpinnerAdapter(Context context, List<Student> studentList) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List<String> stringFio = new ArrayList<>();
        stringFio.add(" ");
        for (Student students : studentList) {
            stringFio.add((students.getFirstName() + " " +students.getSecondName() + " " + students.getLastName()));
        }

            convertView = layoutInflater.inflate(R.layout.spinner_item, parent, false);
            TextView textView = convertView.findViewById(R.id.spinner_id);
            textView.setText((String.valueOf(stringFio.get(position))));

        return convertView;
    }
}