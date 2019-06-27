package com.suai.sergey.databases.groupDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity
public class Group {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "number_group")
    private String numberGroup;

    @NonNull
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
