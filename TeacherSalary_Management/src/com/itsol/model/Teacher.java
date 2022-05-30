package com.itsol.model;

import java.util.Scanner;

public class Teacher extends Person {

    private static int ID = 1;

    private String id;

    private String typeTeacher;

    private float salary;

    public Teacher(){

    }

    public Teacher(String name, String address, int phone, String typeTeacher, float salary){
        super(name, address, phone);
        this.id = String.format("%03d", ID++);
        this.typeTeacher = typeTeacher;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeTeacher() {
        return typeTeacher;
    }

    public void setTypeTeacher(String typeTeacher) {
        this.typeTeacher = typeTeacher;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public void nhapTT() {
        this.id = String.format("%03d", ID++);

        super.nhapTT();

        System.out.println("Nhập loại giảng viên: ");
        System.out.println("1.GS-TS");
        System.out.println("2.PGS-TS");
        System.out.println("3.Giảng Viên");
        System.out.println("4.Thạc Sĩ");
        int choose = new Scanner(System.in).nextInt();

        switch (choose){
            case 1:
                this.typeTeacher = Type_Teacher.Prof_Dr.getType_Teacher();
                break;
            case 2:
                this.typeTeacher = Type_Teacher.Associate_Professor_PhD.getType_Teacher();
                break;
            case 3:
                this.typeTeacher = Type_Teacher.Lecturer.getType_Teacher();
                break;
            case 4:
                this.typeTeacher = Type_Teacher.Masters.getType_Teacher();
                break;
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", TeacherType='" + typeTeacher + '\'' +
                '}';
    }
}
