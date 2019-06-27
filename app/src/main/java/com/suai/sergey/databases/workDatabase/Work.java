package com.suai.sergey.databases.workDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity
public class Work {

    @PrimaryKey
    @NonNull
    private String id;
    private String idSubject;
    @ColumnInfo(name = "number_work")
    private int number;
    @ColumnInfo(name = "name_work")
    private String name;
    @ColumnInfo(name = "max_mark")
    private int maxMarks;
    @ColumnInfo(name = "order_number")
    private String orderNumber;
    private String type;

    @NonNull
    public String getId() {
        return id;
    }
    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getIdSubject() {
        return idSubject;
    }
    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxMarks() {
        return maxMarks;
    }
    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}