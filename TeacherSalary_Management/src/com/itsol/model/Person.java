package com.itsol.model;

import java.util.Scanner;

public abstract class Person implements Input{
    private String name;

    private String address;

    private int phone;

    public Person(){

    }

    public Person(String name, String address, int phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public void nhapTT() {
        System.out.println("Nhập tên giảng viên: ");
        this.name = new Scanner(System.in).nextLine();

        System.out.println("Nhập địa chỉ giảng viên: ");
        this.address = new Scanner(System.in).nextLine();

        System.out.println("Nhập sđt giảng viên: ");
        this.phone = new Scanner(System.in).nextInt();
    }
}
