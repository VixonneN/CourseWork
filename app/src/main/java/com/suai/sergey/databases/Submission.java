package com.suai.sergey.databases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Work.class, parentColumns = "id", childColumns = "idWork"),
indices = @Index("idWork"))
        //как сделать 2 привязки в room, см. пример
        //@ForeignKey(entity = Group.class, parentColumns = "id", childColumns = "idGroup"))
public class Submission {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int idStudent;//ссылка
    private int idWork;//ссылка
    private String date;
    private int mark;

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
