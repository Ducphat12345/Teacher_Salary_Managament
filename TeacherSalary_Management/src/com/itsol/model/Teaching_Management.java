package com.itsol.model;

import java.util.Arrays;

public class Teaching_Management {

    private Teacher teacher;

    private Subject[] subjects;

    private int totalClass;

    private int totalLesson;

    public Teaching_Management(){

    }

    public Teaching_Management(Teacher teacher, Subject[] subjects, int totalClass,int totalLesson){
        this.teacher = teacher;
        this.subjects = subjects;
        this.totalClass = totalClass;
        this.totalLesson = totalLesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getTotalClass() {
        return totalClass;
    }

    public void setTotalClass(int totalClass) {
        this.totalClass = totalClass;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    @Override
    public String toString() {
        return "Teaching_Management{" +
                "teacher=" + teacher +
                ", subjects=" + Arrays.toString(subjects) +
                ", totalClass=" + totalClass +
                ", totalLesson=" + totalLesson +
                '}';
    }
}
