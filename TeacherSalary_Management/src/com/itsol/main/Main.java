package com.itsol.main;

import com.itsol.model.Person;
import com.itsol.service.Teaching_Service;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Teaching_Service teaching_service = new Teaching_Service();

        while (true){
            System.out.println("Mời bạn chọn chương trình:");
            System.out.println("1. Nhập, xuất danh sách các giảng viên");
            System.out.println("2. Nhập, xuất danh sách các môn học");
            System.out.println("3. Quản lý trả lương cho giảng viên");
            System.out.println("4. Sắp xếp giảng viên theo tên");
            System.out.println("5. Sắp xếp giảng viên theo số lượng tiết học giảm dần");
            System.out.println("6. Lương giảng viên sau khi dạy");
            System.out.println("7. Thoát");

            int lua_Chon = new Scanner(System.in).nextInt();

            switch (lua_Chon){

                case 1:
                    teaching_service.createNewTeacher();
                    teaching_service.displayTeacher();
                    break;
                case 2:
                    teaching_service.createNewSubject();
                    teaching_service.displaySubject();
                    break;
                case 3:
                    teaching_service.borrowTeacher();
                    break;
                case 4:
                    teaching_service.sortBorrowListByTeacherName();
                    break;
                case 5:
                    teaching_service.sortBorrowListByLessonAmount();
                    break;
                case 6:
                    teaching_service.salaryTeacher();
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có chương trình bạn chọn! Mời chọn lại:");
                    break;
            }
        }
    }

}
