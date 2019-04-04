package com.suai.sergey.databases.groupDatabase;

import android.arch.persistence.room.ColumnInfo;

public class NumberAndSubjectGroup {

    @ColumnInfo(name = "subject_name")
    private String name;

    @ColumnInfo(name = "number_group")
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}