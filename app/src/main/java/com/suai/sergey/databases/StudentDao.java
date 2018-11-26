package com.suai.sergey.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("select fio from Student")
    List<Student> getFio();
}
