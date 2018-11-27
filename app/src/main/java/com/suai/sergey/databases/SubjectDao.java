package com.suai.sergey.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SubjectDao {

    @Query("select id, name from subject")
    List<Subject> getName();
}
