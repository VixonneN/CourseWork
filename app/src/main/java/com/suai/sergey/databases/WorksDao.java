package com.suai.sergey.databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.suai.sergey.databases.groupDatabase.Group;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.studentDatabase.FioStudent;
import com.suai.sergey.databases.studentDatabase.Student;
import com.suai.sergey.databases.subjectDatabase.SubjectName;
import com.suai.sergey.databases.teacherDatabase.FioTeacher;
import com.suai.sergey.databases.teacherDatabase.Teacher;
import com.suai.sergey.databases.workDatabase.NameWork;

import java.util.List;

@Dao
public interface WorksDao {

    @Query("select * from `Group` order by number_group")
    List<Group> getNumber();

    @Query("select * from student where idGroup in (:idGroup) order by firstName, secondName, lastName")
    List<Student> getStudentsByGroup(String idGroup);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student... students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGroup(Group... groups);



    //deleteAll
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