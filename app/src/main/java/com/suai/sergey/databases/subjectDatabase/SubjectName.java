package com.suai.sergey.databases.subjectDatabase;

import android.arch.persistence.room.ColumnInfo;

public class SubjectName {
    @ColumnInfo(name = "subject_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}