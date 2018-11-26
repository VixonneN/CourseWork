package com.suai.sergey.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WorkDao {

    @Query("select name from work")
    List<Work> getName();

}
