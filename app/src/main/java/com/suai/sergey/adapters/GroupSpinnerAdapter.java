package com.suai.sergey.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.suai.sergey.R;
import com.suai.sergey.databases.groupDatabase.NumberGroup;

import java.util.ArrayList;
import java.util.List;

public class GroupSpinnerAdapter extends BaseAdapter {


    private LayoutInflater layoutInflater;
    private List<NumberGroup> numberGroups;

    public GroupSpinnerAdapter(Context context, List<NumberGroup> numberGroups) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.numberGroups = numberGroups;
    }

    @Override
    public int getCount() {
        return numberGroups.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return numberGroups.get(position - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List<String> groups = new ArrayList<>();
        groups.add(" ");
        for (NumberGroup number : numberGroups) {
            groups.add(String.valueOf(number.getNumber()));
        }

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.spinner_item, parent, false);
            TextView textView = convertView.findViewById(R.id.spinner_id);
            textView.setText(String.valueOf(groups.get(position)));
        }
        return convertView;
    }
}