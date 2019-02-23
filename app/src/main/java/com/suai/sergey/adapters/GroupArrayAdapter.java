package com.suai.sergey.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.suai.sergey.R;
import com.suai.sergey.databases.groupDatabase.NumberGroup;

import java.util.List;

public class GroupArrayAdapter extends ArrayAdapter<NumberGroup> {

    private LayoutInflater layoutInflater;
    private List<NumberGroup> numberGroups;

    public GroupArrayAdapter(@NonNull Context context, int resource, @NonNull List<NumberGroup> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustovView(position, convertView, parent);
    }

    private View getCustovView(int position, View convertView, ViewGroup parent){
        View view = layoutInflater.inflate(R.layout.spinner_item, parent, false);//npe
        NumberGroup numberGroup = getItem(position);
        TextView textView = view.findViewById(R.id.spinner_id);
        textView.setText(String.valueOf(numberGroup.getNumber()));// сделать toString, крашится тут
        return view;
    }
}