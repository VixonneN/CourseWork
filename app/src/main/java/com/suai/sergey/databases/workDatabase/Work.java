package com.suai.sergey.databases.workDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.suai.sergey.databases.subjectDatabase.Subject;

@Entity(foreignKeys = @ForeignKey(entity = Subject.class, parentColumns = "id", childColumns = "idSubject"), indices = @Index("idSubject"))
public class Work {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int idSubject;
    @ColumnInfo(name = "number_work")
    private int number;
    @ColumnInfo(name = "name_work")
    private String name;
    @ColumnInfo(name = "max_ball")
    private int maxMarks;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdSubject() {
        return idSubject;
    }
    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxMarks() {
        return maxMarks;
    }
    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }
}