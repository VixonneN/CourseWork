package com.suai.sergey.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.suai.sergey.R;
import com.suai.sergey.databases.teacherDatabase.FioTeacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherSpinnerAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private final List<FioTeacher> teacherData;

    public TeacherSpinnerAdapter(Context context, List<FioTeacher> teacherData) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.teacherData = teacherData;
    }

    @Override
    public int getCount() {
        return teacherData.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return teacherData.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List<String> teacherList = new ArrayList<>();
        teacherList.add("");
        for (FioTeacher fioTeacher : teacherData){
            teacherList.add(fioTeacher.getFirstName() + " " + fioTeacher.getLastName());
        }

        convertView = layoutInflater.inflate(R.layout.spinner_item, parent, false);
        TextView textView = convertView.findViewById(R.id.spinner_id);
        textView.setText(String.valueOf(teacherList.get(position)));

        return convertView;
    }
    //addAll(List<FioTeacher>)
}
