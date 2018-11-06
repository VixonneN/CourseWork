package com.suai.sergey;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.suai.sergey.databases.AppDatabase;

public class App extends Application {
    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "Database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance(){
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
