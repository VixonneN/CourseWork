package com.suai.sergey.databases.studentDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.suai.sergey.databases.studentDatabase.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("select fio_student from Student")
    List<FioStudent> getFio();
}