package com.suai.sergey.databases.groupDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.suai.sergey.databases.groupDatabase.Group;

import java.util.List;

//тут должны быть sql запросы
//для спиннера нужен номер группы, фио студента, название дисциплины, название работы
@Dao
public interface GroupDao {

    @Query("select number_group from `Group`")
    List<NumberGroup> getNumber();
}