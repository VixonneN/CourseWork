package com.suai.sergey.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.suai.sergey.FakeDataClass;
import com.suai.sergey.R;
import com.suai.sergey.databases.teacherDatabase.FioTeacher;
import com.suai.sergey.databases.workDatabase.IdNameNumberMaxBallWork;

import java.util.ArrayList;
import java.util.List;

public class MarkSpinnerAdapter extends BaseAdapter {

    private final LayoutInflater layoutInflater;
    private final List<IdNameNumberMaxBallWork> works;

    public MarkSpinnerAdapter(Context context, List<IdNameNumberMaxBallWork> works) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.works = works;
    }

    @Override
    public int getCount() {//
        return works.size() + 1;
    }

    @Override
    public Object getItem(int position) {//
        return works.get(position - 1);
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
//        for (IdNameNumberMaxBallWork work : works){
//
//            marks.add(String.valueOf(teachers.getFirstName()));
//        }

//        int maxMark = works.get(i).getMaxMarks();

//        for (int i = 1; i < works.get(0).getMaxMarks(); i++) {
//            marks.add(String.valueOf(i));
//        }

        for (int i = 1; i < FakeDataClass.INSTANCE.getIdNameNumberMaxBallWork().get(0).getMaxMarks(); i++){
            marks.add(String.valueOf(i));
        }

        convertView = layoutInflater.inflate(R.layout.spinner_mark_item, parent, false);
        TextView mark = convertView.findViewById(R.id.spinner_mark_id);
        mark.setText(String.valueOf(marks.get(position)));
        return convertView;
    }
}
