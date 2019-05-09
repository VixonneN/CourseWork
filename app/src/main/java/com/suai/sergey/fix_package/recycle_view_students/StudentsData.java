package com.suai.sergey.fix_package.recycle_view_students;

public class StudentsData {

    private final int numberStudentFromGroup;
    private final String nameStudent;

    public StudentsData(int numberStudentFromGroup, String nameStudent) {
        this.numberStudentFromGroup = numberStudentFromGroup;
        this.nameStudent = nameStudent;
    }

    public int getNumberStudentFromGroup() {
        return numberStudentFromGroup;
    }

    public String getNameStudent() {
        return nameStudent;
    }
}
