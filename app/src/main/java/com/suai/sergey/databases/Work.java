package com.suai.sergey.databases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Work {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int idSubject;

    public int number;

    public String name;

}