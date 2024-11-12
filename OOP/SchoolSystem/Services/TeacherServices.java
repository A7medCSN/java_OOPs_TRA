package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherServices {
    static Scanner scanner = new Scanner(System.in);

    public static Teacher enterNewTeacher() {

        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher Name");
        teacher.setName(scanner.nextLine());
        System.out.println("Enter Teacher ID");
        teacher.setId(scanner.nextLine());
        System.out.println("Enter Teacher's years of Experience ");
        teacher.setYearsOfExperience(scanner.nextShort());
        scanner.nextLine();

        teacher.setSubjectsExpertiseList(SubjectServices.addSubject());

        return teacher;

    }

    public static List<Teacher> addTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new teacher? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                teachers.add(TeacherServices.enterNewTeacher());
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
        return teachers;
    }
}
