package com.suai.sergey.databases.subjectDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.suai.sergey.databases.subjectDatabase.Subject;

import java.util.List;

@Dao
public interface SubjectDao {

    @Query("select subject_name from subject")
    List<SubjectName> getName();
}