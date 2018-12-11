package com.suai.sergey.databases.workDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.suai.sergey.databases.studentDatabase.Student;
import com.suai.sergey.databases.workDatabase.Work;

import java.util.List;

@Dao
public interface WorkDao {

    @Query("select name_work from work")
    List<NameWork> getName();

    @Update
    void updateAll(Student... students);
}