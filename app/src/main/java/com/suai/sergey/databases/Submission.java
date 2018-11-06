package com.suai.sergey.databases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Submission {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int idStudent;

    public int idWork;

    public String date;

    public int mark;
}
