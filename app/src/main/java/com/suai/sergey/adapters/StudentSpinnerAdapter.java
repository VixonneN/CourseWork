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

import java.util.List;

public class StudentSpinnerAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<FioStudent> studentList;

    public StudentSpinnerAdapter(Context context, List<FioStudent> studentList){
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(R.layout.spinner_item, parent, false);

        FioStudent fioStudent = (FioStudent) getItem(position);

        TextView textView = view.findViewById(R.id.spinner_id);

        textView.setText((fioStudent.getFio()));// сделать toString, крашится тут

        return view;
    }
}
