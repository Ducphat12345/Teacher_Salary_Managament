package com.itsol.model;

import java.util.Scanner;

public class Subject implements Input {

    private static int ID = 1;

    private String id;

    private String name_Subject;

    private int total_Period;

    private int number_Of_Theoretical_Periods;

    private int expense;

    public Subject(){

    }

    public Subject(String name_Subject, int total_Period, int number_Of_Theoretical_Periods, int expense){
        this.id = String.format("%03d", ID++);
        this.name_Subject = name_Subject;
        this.total_Period = total_Period;
        this.number_Of_Theoretical_Periods = number_Of_Theoretical_Periods;
        this.expense = expense;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_Subject() {
        return name_Subject;
    }

    public void setName_Subject(String name_Subject) {
        this.name_Subject = name_Subject;
    }

    public int getTotal_Period() {
        return total_Period;
    }

    public void setTotal_Period(int total_Period) {
        this.total_Period = total_Period;
    }

    public int getNumber_Of_Theoretical_Periods() {
        return number_Of_Theoretical_Periods;
    }

    public void setNumber_Of_Theoretical_Periods(int number_Of_Theoretical_Periods) {
        this.number_Of_Theoretical_Periods = number_Of_Theoretical_Periods;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public void nhapTT() {
        this.id = String.format("%03d", ID++);

        System.out.println("Nhập tên môn học: ");
        this.name_Subject = new Scanner(System.in).nextLine();

        System.out.println("Nhập số tiết: ");
        this.total_Period = new Scanner(System.in).nextInt();

        System.out.println("Nhập số tiết lý thuyết: ");
        this.number_Of_Theoretical_Periods = new Scanner(System.in).nextInt();

        System.out.println("Nhập kinh phí: ");
        this.expense = new Scanner(System.in).nextInt();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name_Subject='" + name_Subject + '\'' +
                ", total_Period=" + total_Period +
                ", number_Of_Theoretical_Periods=" + number_Of_Theoretical_Periods +
                ", expense=" + expense +
                '}';
    }
}
