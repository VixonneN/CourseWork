package com.suai.sergey.databases.groupDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Group {

    @NonNull
    @PrimaryKey
    private String id;

    @ColumnInfo(name = "number_group")
    private String numberGroup;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNumberGroup() {
        return numberGroup;
    }
    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }
}
