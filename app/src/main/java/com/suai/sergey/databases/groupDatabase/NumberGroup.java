package com.suai.sergey.databases.groupDatabase;

import androidx.room.ColumnInfo;

public class NumberGroup {

    @ColumnInfo(name = "number_group")
    private int number;

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}