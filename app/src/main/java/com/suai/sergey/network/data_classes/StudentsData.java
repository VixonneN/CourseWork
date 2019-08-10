package com.suai.sergey.network.data_classes;

import com.google.gson.annotations.SerializedName;

public class StudentsData {
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;

    @SerializedName("group")
    private GroupsData groupsData;

    public GroupsData getGroupsData() {
        return groupsData;
    }

    public void setGroupsData(GroupsData groupsData) {
        this.groupsData = groupsData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
