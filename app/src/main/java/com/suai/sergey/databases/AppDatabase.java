package com.suai.sergey.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Group.class, Student.class, Subject.class, Submission.class, Work.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase singleton;
    private static final String DATABASE_NAME = "Course.db";

    public abstract GroupDao groupDao();

    public abstract StudentDao studentDao();

    public abstract SubjectDao subjectDao();

    public abstract SubmissionDao submissionDao();

    public abstract WorkDao workDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (singleton == null) {
            synchronized (AppDatabase.class) {
                if (singleton == null) {
                    singleton = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,

                            DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return singleton;
    }
}

//столбец idGroup ссылается на внешний ключ,
// но не является частью индекса.
// Это может вызвать полное сканирование таблицы при каждом изменении родительской таблицы,
// поэтому настоятельно рекомендуется создать индекс, покрывающий этот столбец.
//и так с каждой таблицей, как решить - не знаю.