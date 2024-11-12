package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Teacher;
import OOP.SchoolSystem.Entities.School;

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

    public static void addTeacherToSpecificSchool(List<School> schoolSystem) {
        if (schoolSystem.isEmpty()) {
            System.out.println("No schools available. Please add a school first.");
            return;
        }

        System.out.println("Enter the name of the school to add a teacher:");
        String schoolName = scanner.nextLine();

        // Find the school by name
        School selectedSchool = null;
        for (School school : schoolSystem) {
            if (school.getName().equalsIgnoreCase(schoolName)) {
                selectedSchool = school;
                break;
            }
        }

        if (selectedSchool == null) {
            System.out.println("School not found. Please ensure the school exists.");
            return;
        }

        // Add a new teacher to the selected school
        Teacher newTeacher = enterNewTeacher();
        if (selectedSchool.getTeachers() == null) {
            selectedSchool.setTeachers(new ArrayList<>());
        }
        selectedSchool.getTeachers().add(newTeacher);
        System.out.println("Teacher added successfully to " + schoolName);
    }
}
