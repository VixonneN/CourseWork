package com.suai.sergey;

import com.suai.sergey.databases.workDatabase.IdNameNumberMaxBallWork;

import java.util.ArrayList;
import java.util.List;

public enum FakeDataClass {
    INSTANCE;

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

}