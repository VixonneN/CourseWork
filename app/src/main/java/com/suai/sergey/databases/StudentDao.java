package com.suai.sergey.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("select id, fio, idGroup from Student")
    List<Student> getFio();
}