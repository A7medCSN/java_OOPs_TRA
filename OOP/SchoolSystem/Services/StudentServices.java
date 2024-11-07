package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServices {
    static Scanner scanner = new Scanner(System.in);

    public static Student getStudent() {

        Student student = new Student();
        System.out.println("Enter Student Name");
        student.name = scanner.nextLine();
        System.out.println("Enter Student ID");
        student.id = scanner.nextLine();
        System.out.println("Enter Student grade");
        student.grade = scanner.nextLine();
        System.out.println("Enter student age");
        student.age = scanner.nextShort();
        scanner.nextLine();

        student.courses=SubjectServices.addSubject();

        return student;

    }

    public static List<Student> addStudents() {
        List<Student> students = new ArrayList<>();
        Boolean flag=true;
        while (flag) {
            System.out.println("do want to add new student? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag=false;
            } else {
                students.add(StudentServices.getStudent());
            }
        }
        return students;
    }
}
