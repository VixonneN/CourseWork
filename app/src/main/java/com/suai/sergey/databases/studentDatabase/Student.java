package com.suai.sergey.databases.studentDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.suai.sergey.databases.groupDatabase.Group;

@Entity(foreignKeys = @ForeignKey(entity = Group.class, parentColumns = "id", childColumns = "idGroup"),
        indices = @Index("idGroup"))
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "fio_student")
    private String fio;
    private int idGroup;

    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdGroup() {
        return idGroup;
    }
    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }
}
