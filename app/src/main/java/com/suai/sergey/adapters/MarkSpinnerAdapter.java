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

public class MarkSpinnerAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private final List<FioTeacher> fioTeacher;

    public MarkSpinnerAdapter(Context context, List<FioTeacher> fioTeacher) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.fioTeacher = fioTeacher;
    }

    @Override
    public int getCount() {//
        return 0;
    }

    @Override
    public Object getItem(int position) {//
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List<String> marks = new ArrayList<>();
        marks.add("");
        for (FioTeacher teachers : fioTeacher){
            marks.add(String.valueOf(teachers.getFirstName()));
        }

        convertView = layoutInflater.inflate(R.layout.spinner_mark_item, parent, false);
        TextView mark = convertView.findViewById(R.id.spinner_mark_id);
        mark.setText(String.valueOf(marks.get(position)));
        return convertView;
    }
}
