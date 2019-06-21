package com.suai.sergey;

import android.support.annotation.NonNull;

import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.databases.groupDatabase.Group;
import com.suai.sergey.databases.groupDatabase.NumberGroup;
import com.suai.sergey.databases.studentDatabase.FioStudent;
import com.suai.sergey.databases.studentDatabase.Student;
import com.suai.sergey.databases.subjectDatabase.Subject;
import com.suai.sergey.databases.subjectDatabase.SubjectName;
import com.suai.sergey.databases.submissionDatabase.Submission;
import com.suai.sergey.databases.workDatabase.IdNameNumberMaxBallWork;
import com.suai.sergey.databases.workDatabase.NameWork;
import com.suai.sergey.databases.workDatabase.NumberWork;
import com.suai.sergey.databases.workDatabase.Work;

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

    public NumberWork createNumberWork(int numberWork) {
        NumberWork numberWork1 = new NumberWork();
        numberWork1.setNumber(numberWork);
        return numberWork1;
    }

    public IdNameNumberMaxBallWork createWork(String id, String name, int number, int maxBall) {
        IdNameNumberMaxBallWork idNameNumberMaxBallWork = new IdNameNumberMaxBallWork();
        idNameNumberMaxBallWork.setId(id);
        idNameNumberMaxBallWork.setName(name);
        idNameNumberMaxBallWork.setNumber(number);
        idNameNumberMaxBallWork.setMaxMarks(maxBall);
        return idNameNumberMaxBallWork;
    }

    public List<IdNameNumberMaxBallWork> getIdNameNumberMaxBallWork() {
        List<IdNameNumberMaxBallWork> workList = new ArrayList<>();
        workList.add(createWork("1234", "Курсовая работа", 1, 15));
        workList.add(createWork("1324", "Дипломная работа", 2, 15));
        workList.add(createWork("1423", "Лабораторная работа №1", 3, 15));
        workList.add(createWork("1432", "Лабораторная работа №2", 4, 15));
        workList.add(createWork("2134", "Лабораторная работа №3", 5, 15));
        workList.add(createWork("2314", "Лабораторная работа №4", 6, 15));
        return workList;
    }

    public List<NumberWork> getNumberWork() {
        List<NumberWork> numberWorks = new ArrayList<>();
        numberWorks.add(createNumberWork(10));
        return numberWorks;
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
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
        studentList.add(createStudent("Иванов"));
        studentList.add(createStudent("Петров"));
        studentList.add(createStudent("Сидоров"));
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

    public List<String> addMark() {
        List<String> marks = new ArrayList<>();
        marks.add(0, "");
        marks.add(1, "Не сдано");
        marks.add(2, "Сдано");
        return marks;
    }

    //бд группы
//    public Group createGroup(String id, int number) {
//        Group group = new Group();
//        group.setId(id);
//        group.setNumber(number);
//        return group;
//    }

    public void addGroups(){

    }

    //бд студента
    public Student createStudent(String id, String firstName, String secondName, String lastName, String idGroup) {
        Student student = new Student();
        student.setId(id);
        student.setFirstName(firstName);
        student.setSecondName(secondName);
        student.setLastName(lastName);
        student.setIdGroup(idGroup);
        return student;
    }

    //бд предмета
    public Subject createSubject(String id, String name, String type) {
        Subject subject = new Subject();
        subject.setId(id);
        subject.setName(name);
        subject.setType(type);
        return subject;
    }

    //бд работы
    public Work createWork(String id, String idSubject, int number, String name, int maxMarks, String orderNumber, String type) {
        Work work = new Work();
        work.setId(id);
        work.setIdSubject(idSubject);
        work.setNumber(number);
        work.setName(name);
        work.setMaxMarks(maxMarks);
        work.setOrderNumber(orderNumber);
        work.setType(type);
        return work;
    }
}