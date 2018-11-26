package com.suai.sergey.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

//тут должны быть sql запросы
//для спиннера нужен номер группы, фио студента, название дисциплины, название работы
@Dao
public interface GroupDao {

    @Query("select number from `Group`")
    List<Group> getNumber();

    @Insert
    void insert(Group group);

    @Delete
    void delete(Group group);

}
