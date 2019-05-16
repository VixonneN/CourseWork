package com.suai.sergey.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.suai.sergey.R;
import com.suai.sergey.databases.workDatabase.NameWork;

import java.util.ArrayList;
import java.util.List;

public class WorkSpinnerAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<NameWork> nameWorks;

    public WorkSpinnerAdapter(Context context, List<NameWork> nameWorks) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.nameWorks = nameWorks;
    }

    @Override
    public int getCount() {
        return nameWorks.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return nameWorks.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List<String> workList = new ArrayList<>();
        workList.add(" ");
        for (NameWork nameWork : nameWorks) {
            workList.add(String.valueOf(nameWork.getName()));
        }

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.spinner_item, parent, false);
            TextView textView = convertView.findViewById(R.id.spinner_id);
            textView.setText(String.valueOf(workList.get(position)));
        }
        return convertView;
    }
}
