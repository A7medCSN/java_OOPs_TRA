package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServices {
    static Scanner scanner = new Scanner(System.in);

    public static Student enterNewStudent() {

        Student student = new Student();
        System.out.println("Enter Student Name:");
        student.setName(scanner.nextLine());
        System.out.println("Enter Student ID:");
        student.setId(scanner.nextLine());
        System.out.println("Enter Student grade:");
        student.setGrade(scanner.nextLine());
        System.out.println("Enter student age:");
        student.setAge(scanner.nextShort());
        scanner.nextLine();

        student.setCourses(SubjectServices.addSubject());

        return student;

    }

    public static List<Student> addStudents() {
        List<Student> students = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new student? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                students.add(StudentServices.enterNewStudent());
            } else {
                System.out.println("Invalid Input. Please try again.");
            }

        }
        return students;
    }
}
