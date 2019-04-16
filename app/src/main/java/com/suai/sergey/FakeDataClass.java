package com.suai.sergey;

import android.support.annotation.NonNull;

import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.studentDatabase.FioStudent;
import com.suai.sergey.databases.subjectDatabase.SubjectName;
import com.suai.sergey.databases.submissionDatabase.Submission;
import com.suai.sergey.databases.workDatabase.NameWork;

import java.util.ArrayList;
import java.util.List;

public enum FakeDataClass {
    INSTANCE;

    //методы для заполнения таблицы
    @NonNull
    public NumberGroup createGroup(int number) {
        NumberGroup group = new NumberGroup();
        group.setNumber(number);
        return group;
    }

    @NonNull
    public FioStudent createStudent(String fio) {
        FioStudent student = new FioStudent();
        student.setFio(fio);
        return student;
    }

    @NonNull
    public NameWork createWork(int number, String name) {
        NameWork work = new NameWork();
        work.setName(name);
//        work.setNumber(number);
        return work;
    }

    @NonNull
    public SubjectName createSubject(String name) {
        SubjectName subject = new SubjectName();
        subject.setName(name);
        return subject;
    }

    @NonNull
    public Submission createSubmission(String date, int mark) {
        Submission submission = new Submission();
        submission.setDate(date);
        submission.setMark(mark);
        return submission;
    }

    //добавление фейковых данных
    public List<NumberGroup> getGroupList() {
        List<NumberGroup> groupList = new ArrayList<>();
        groupList.add(createGroup(4741));
        groupList.add(createGroup(4742));
        groupList.add(createGroup(4743));
        groupList.add(createGroup(4731));
        groupList.add(createGroup(4716));
        return groupList;
    }

    public List<FioStudent> getStudentList() {
        List<FioStudent> studentList = new ArrayList<>();
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        return studentList;
    }

    public List<NameWork> getWorkList() {
        List<NameWork> workList = new ArrayList<>();
        workList.add(createWork(1, "Вводная работа"));
        workList.add(createWork(2, "Курсовая работа"));
        workList.add(createWork(3, "Дипломная работа"));
        return workList;
    }

    public List<SubjectName> getSubjectList() {
        List<SubjectName> subjectList = new ArrayList<>();
        subjectList.add(createSubject("Основы программирования"));
        subjectList.add(createSubject("Физика"));
        subjectList.add(createSubject("Электротехника"));
        subjectList.add(createSubject("Социология"));
        subjectList.add(createSubject("English language"));
        return subjectList;
    }

    public List<Submission> getSubmissionList() {
        List<Submission> submissionList = new ArrayList<>();
        submissionList.add(createSubmission("21.01.18", 0));
        submissionList.add(createSubmission("22.01.18", 1));
        submissionList.add(createSubmission("23.01.18", 3));
        submissionList.add(createSubmission("24.01.18", 4));
        submissionList.add(createSubmission("25.01.18", 5));
        return submissionList;
    }
}