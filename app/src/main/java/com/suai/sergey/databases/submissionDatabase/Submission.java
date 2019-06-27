package com.suai.sergey.databases.submissionDatabase;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity
public class Submission {

    @PrimaryKey
    @NonNull
    private String id;
    private int idStudent;//ссылка
    private int idWork;//ссылка
    private String date;
    private int mark;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdWork() {
        return idWork;
    }
    public void setIdWork(int idWork) {
        this.idWork = idWork;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
}