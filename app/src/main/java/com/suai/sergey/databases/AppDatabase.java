package com.suai.sergey.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Group.class, Student.class, Subject.class, Submission.class, Work.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GroupDao groupDao();
    public abstract StudentDao studentDao();
    public abstract SubjectDao subjectDao();
    public abstract SubmissionDao submissionDao();
    public abstract WorkDao workDao();

}