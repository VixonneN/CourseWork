package com.suai.sergey.fix_package.recycle_view_labWork;

public class LabWorks {

    private final String numberWork;
    private final String nameWork;
    private final int mark;
    private final boolean isMarks;


    public LabWorks(String numberWork, String nameWork, int mark, boolean isMarks) {
        this.numberWork = numberWork;
        this.nameWork = nameWork;
        this.mark = mark;
        this.isMarks = isMarks;
    }

    String getNumberWork() {
        return numberWork;
    }
    String getNameWork() {
        return nameWork;
    }

    int getMark() {
        return mark;
    }
    boolean isMarks() {
        return isMarks;
    }
}