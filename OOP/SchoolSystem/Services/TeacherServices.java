package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherServices {
    static Scanner scanner = new Scanner(System.in);

    public static Teacher getTeacher() {

        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher Name");
        teacher.name = scanner.nextLine();
        System.out.println("Enter Teacher ID");
        teacher.id = scanner.nextLine();
        System.out.println("Enter Teacher's years of Experience ");
        teacher.yearsOfExperience=scanner.nextShort();
        scanner.nextLine();

        teacher.subjectsExpertiseList=SubjectServices.addSubject();

        return teacher;

    }

    public static List<Teacher> addTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        Boolean flag=true;
        while (flag) {
            System.out.println("do want to add new teacher? (yes/no) ");
            String response=scanner.nextLine();
            if (response.equalsIgnoreCase("no")){
                flag=false;
            }
            else{
            teachers.add(TeacherServices.getTeacher());
        }}
        return teachers;
    }
}
