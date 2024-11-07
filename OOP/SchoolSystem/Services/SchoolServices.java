package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.School;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolServices {
    static Scanner scanner = new Scanner(System.in);

    public static School getSchool() {

        School school = new School();
        System.out.println("Enter School Name");
        school.name = scanner.nextLine();

        System.out.println("Enter School Address");
        school.address = scanner.nextLine();

        school.library = LibraryServices.getLibrary();
        school.students = StudentServices.addStudents();
        school.teachers = TeacherServices.addTeacher();

        return school;
    }

    public static List<School> addSchools() {
        List<School> schools = new ArrayList<>();
        Boolean flag=true;
        while (flag) {
            System.out.println("do want to add new school? (yes/no) ");
            String response=scanner.nextLine();
            if (response.equalsIgnoreCase("no")){
                flag=false;
            }
            else {
                schools.add(SchoolServices.getSchool());
            }
        }
        return schools;
    }
}