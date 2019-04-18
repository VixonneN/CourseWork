package com.suai.sergey.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.studentDatabase.FioStudent;
import com.suai.sergey.databases.subjectDatabase.SubjectName;
import com.suai.sergey.databases.workDatabase.NameWork;

import java.util.List;

@Dao
public interface WorksDao {

    @Query("select name_work from work")
    List<NameWork> getWorkName();

    @Query("select subject_name from subject")
    List<SubjectName> getSubjectName();

    @Query("select fio_student from Student")
    List<FioStudent> getFio();

    @Query("select number_group from `Group`")
    List<NumberGroup> getNumber();

//    @Query("select number_work from work")
//    List<NumberGroup> getNumberGroup();

}
