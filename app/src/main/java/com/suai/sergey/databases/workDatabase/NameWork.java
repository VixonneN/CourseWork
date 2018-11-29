package com.suai.sergey.databases.workDatabase;

import android.arch.persistence.room.ColumnInfo;

public class NameWork {
    @ColumnInfo(name = "name_work")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
