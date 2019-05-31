package com.suai.sergey.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.suai.sergey.databases.groupDatabase.Group;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.studentDatabase.FioStudent;
import com.suai.sergey.databases.studentDatabase.Student;
import com.suai.sergey.databases.subjectDatabase.Subject;
import com.suai.sergey.databases.subjectDatabase.SubjectName;
import com.suai.sergey.databases.teacherDatabase.FioTeacher;
import com.suai.sergey.databases.teacherDatabase.Teacher;
import com.suai.sergey.databases.workDatabase.NameWork;

import java.util.List;

@Dao
public interface WorksDao {

    @Query("select name_work from work")
    List<NameWork> getWorkName();

    @Query("select subject_name from subject")
    List<SubjectName> getSubjectName();

    @Query("select number_group from `Group`")
    List<NumberGroup> getNumber();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTeacher(Teacher... teachers);

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertGroup(Group... groups);

    @Query("select id, first_name, last_name from teacher")
    List<FioTeacher> getFioTeacher();

//    @Query("select number_work from work")
//    List<NumberGroup> getNumberGroup();

//    //добавление данных в бд списком
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertGroup(Group... groups);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertStudent(List<FioStudent> students);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insertSubject(Subject... subjects);
//
}
//stetho