package com.suai.sergey.databases.studentDatabase;

import android.arch.persistence.room.ColumnInfo;

public class FioStudent {
    @ColumnInfo(name = "fio_student")
    private String fio;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
