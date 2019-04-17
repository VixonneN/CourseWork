package com.suai.sergey.fix_package;

public class LabWorks {

    private final int numberWork;
    private final String nameWork;
    private final int mark;
    private final boolean isMarks;

    public LabWorks(int numberWork, String nameWork, int mark, boolean isMarks) {
        this.numberWork = numberWork;
        this.nameWork = nameWork;
        this.mark = mark;
        this.isMarks = isMarks;
    }

    public int getNumberWork() {
        return numberWork;
    }

    public String getNameWork() {
        return nameWork;
    }

    public int getMark() {
        return mark;
    }

    public boolean isMarks() {
        return isMarks;
    }
}

