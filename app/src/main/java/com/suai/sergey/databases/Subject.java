package com.suai.sergey.databases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Subject {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
}
