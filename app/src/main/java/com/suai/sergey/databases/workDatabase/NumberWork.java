package com.suai.sergey.databases.workDatabase;

import androidx.room.ColumnInfo;

public class NumberWork {

    @ColumnInfo(name = "number_work")
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
