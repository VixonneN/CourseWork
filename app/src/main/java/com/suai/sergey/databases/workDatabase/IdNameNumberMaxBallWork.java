package com.suai.sergey.databases.workDatabase;

import androidx.room.ColumnInfo;

public class IdNameNumberMaxBallWork {

    private String id;
    @ColumnInfo(name = "name_work")
    private String name;
    @ColumnInfo(name = "number_work")
    private int number;
    @ColumnInfo(name = "max_mark")
    private int maxMarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }
}
