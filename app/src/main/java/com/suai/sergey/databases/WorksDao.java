package com.suai.sergey.databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.suai.sergey.databases.groupDatabase.NumberGroup;
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

    @Query("select id, first_name, last_name from teacher")
    List<FioTeacher> getFioTeacher();

    //deleteAll
    @Query("delete from teacher")
    void deleteAllTeachers();
    @Query("delete from `group`")
    void deleteAllGroups();
    @Query("delete from student")
    void deleteAllStudents();
    @Query("delete from subject")
    void deleteAllSubjects();
    @Query("delete from submission")
    void deleteAllSubmissions();
    @Query("delete from work")
    void deleteAllWorks();

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