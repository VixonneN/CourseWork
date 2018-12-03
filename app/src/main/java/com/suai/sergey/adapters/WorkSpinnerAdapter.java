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
        return nameWorks.size();
    }

    @Override
    public Object getItem(int position) {
        return nameWorks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(R.layout.spinner_item, parent, false);
        NameWork nameWork = (NameWork) getItem(position);
        TextView textView = view.findViewById(R.id.spinner_id);
        textView.setText(nameWork.getName());
        return view;
    }

}
