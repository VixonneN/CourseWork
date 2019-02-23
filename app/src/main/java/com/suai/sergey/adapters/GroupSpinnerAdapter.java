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
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupSpinnerAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<NumberGroup> numberGroups;
//    private List<String> groups;

    public GroupSpinnerAdapter(Context context, List<NumberGroup> numberGroups) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.numberGroups = numberGroups;
    }

    private List<String> groupToString(){
        List<String> groups = new ArrayList<>();
        groups.add("");
        for (NumberGroup number : numberGroups) {
            groups.add(String.valueOf(number.getNumber()));
        }
        return groups;
    }

    @Override
    public int getCount() {
        return numberGroups.size();
    }

    @Override
    public Object getItem(int position) {
        return numberGroups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(R.layout.spinner_item, parent, false);
        NumberGroup numberGroup = (NumberGroup) getItem(position);
        TextView textView = view.findViewById(R.id.spinner_id);
        textView.setText(String.valueOf(numberGroup.getNumber()));// сделать toString, крашится тут
        return view;
    }

//    private Function<NumberGroup, String> numberGroupsToString = input -> new NumberGroup().toString();
}