package com.itsol.service;

import com.itsol.model.Subject;
import com.itsol.model.Teacher;
import com.itsol.model.Teaching_Management;

import java.util.Scanner;

public class Teaching_Service {

    int countTeacher;

    int countSubject;

    Teacher[] teachers;

    Subject[] subjects;

    Teaching_Management[] teaching_managements;

    String id;

    public void createNewTeacher(){
        System.out.println("Nhập số lượng giảng viên muốn thêm: ");
        countTeacher = new Scanner(System.in).nextInt();
        teachers = new Teacher[countTeacher];
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = new Teacher();
            System.out.println("Nhập thông tin giảng viên thứ " + (i + 1));
            teacher.nhapTT();
            teachers[i] = teacher;
        }
    }

    public void displayTeacher(){
        for (int i = 0; i < teachers.length; i++) {
            System.out.println(teachers[i].toString());
        }
    }

    public void createNewSubject(){
        System.out.println("Nhập số lượng môn học muốn thêm: ");
        countSubject = new Scanner(System.in).nextInt();
        subjects = new Subject[countSubject];
        for (int i = 0; i < subjects.length; i++) {
            Subject subject = new Subject();
            System.out.println("Nhập thông tin môn học thứ " + (i + 1));
            subject.nhapTT();
            subjects[i] = subject;
        }
    }

    public void displaySubject(){
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i].toString());
        }
    }

    public void borrowTeacher(){
        if (teachers == null || subjects == null){
            System.out.println("Giảng viên hoặc môn học không tồn tại! Bạn cần nhập giảng viên và môn học trước");
            return;
        }

        teaching_managements = new Teaching_Management[countTeacher];

        for (int i = 0; i < teachers.length; i++) {
            System.out.println("Nhập số lượng môn học cho giảng viên " + teachers[i].getName() + " dạy: ");
            int subjectNumber = new Scanner(System.in).nextInt();
            Subject[] subjectList = new Subject[subjectNumber];

            int totalClass = 0;
            int totalLesson = 0;

            for (int j = 0; j < subjectNumber; j++) {
                System.out.println("Nhập id môn học thứ " + (j + 1) + " mà giảng viên " + teachers[i].getName() + " dạy: ");
                id = new Scanner(System.in).nextLine();
                Subject subject = searchSubject(id);

                int classNumber = 1;

                if (subject != null){
                    do {
                        System.out.println("Nhập số lớp học của môn học thứ " + (j + 1) + " mà giảng viên " + teachers[i].getName() + " dạy: ");
                        classNumber = new Scanner(System.in).nextInt();
                    }while (classNumber < 0 || classNumber > 3);
                }

                totalLesson += subject.getTotal_Period() * classNumber;

                if (totalLesson > 200){
                    System.out.println("Tổng số tiết dạy của 1 giảng viên không được quá 200, Xin mời nhập lại từ đầu!");
                    break;
                }
                else {
                    int practice = subject.getTotal_Period() - subject.getNumber_Of_Theoretical_Periods();
                    float salary = (float) ((subject.getExpense() * subject.getNumber_Of_Theoretical_Periods()) + (practice * subject.getExpense() * 0.7));
                    teachers[j].setSalary(salary);
                    subjectList[j] = subject;
                    totalClass += classNumber;
                }
            }

            Teaching_Management teaching_management = new Teaching_Management(teachers[i], subjectList, totalClass, totalLesson);
            teaching_managements[i] = teaching_management;
        }

        for (int i = 0; i < teaching_managements.length; i++) {
            System.out.println(teaching_managements[i].toString());
        }
    }

    public void sortBorrowListByTeacherName(){
        for (int i = 0; i < teaching_managements.length - 1; i++) {
            for (int j = i + 1; j < teaching_managements.length; j++) {
                if (teaching_managements[i].getTeacher().getName().compareTo(teaching_managements[j].getTeacher().getName()) > 0){
                    Teaching_Management temp = teaching_managements[i];
                    teaching_managements[i] = teaching_managements[j];
                    teaching_managements[j] = temp;
                }
            }
        }

        for (int i = 0; i < teaching_managements.length; i++) {
            System.out.println(teaching_managements[i].toString());
        }
    }

    public void sortBorrowListByLessonAmount(){
        for (int i = 0; i < teaching_managements.length - 1; i++) {
            for (int j = i + 1; j < teaching_managements.length; j++) {
                if(teaching_managements[i].getTotalLesson() < teaching_managements[j].getTotalLesson()){
                    Teaching_Management temp = teaching_managements[i];
                    teaching_managements[i] = teaching_managements[j];
                    teaching_managements[j] = temp;
                }
            }
        }

        for (int i = 0; i < teaching_managements.length; i++) {
            System.out.println(teaching_managements[i].toString());
        }
    }

    public void salaryTeacher(){
        for (int i = 0; i < teaching_managements.length; i++) {
            System.out.println("Tiền lương của giảng viên " + teaching_managements[i].getTeacher().getName() + " là: " + teaching_managements[i].getTeacher().getSalary());
        }
    }

    public Subject searchSubject(String id){
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].getId().equals(id)){
                return subjects[i];
            }
        }
        return null;
    }
}
