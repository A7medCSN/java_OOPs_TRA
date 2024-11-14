package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Teacher;
import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Interfaces.SubjectServicesInterface;
import OOP.SchoolSystem.Interfaces.TeacherServicesInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherServices implements TeacherServicesInterface {
    static Scanner scanner = new Scanner(System.in);
    static SubjectServicesInterface subjectServicesInterface =new SubjectServices();



    public Teacher enterNewTeacher() {

        Teacher teacher = new Teacher();
        System.out.println("Enter Teacher Name");
        teacher.setName(scanner.nextLine());
        System.out.println("Enter Teacher ID");
        teacher.setId(scanner.nextLine());
        System.out.println("Enter Teacher's years of Experience ");
        teacher.setYearsOfExperience(scanner.nextShort());
        scanner.nextLine();

        teacher.setSubjectsExpertiseList(subjectServicesInterface.addSubject());

        return teacher;

    }

    public List<Teacher> addTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new teacher? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                teachers.add(enterNewTeacher());
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
        return teachers;
    }

    public void addTeacherToSpecificSchool(List<School> schoolSystem) {
        if (schoolSystem.isEmpty()) {
            System.out.println("No schools available. Please add a school first.");
            return;
        }

        System.out.println("Enter the name of the school to add a teacher:");
        String schoolName = scanner.nextLine();


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


        Teacher newTeacher = enterNewTeacher();
        if (selectedSchool.getTeachers() == null) {
            selectedSchool.setTeachers(new ArrayList<>());
        }
        selectedSchool.getTeachers().add(newTeacher);
        System.out.println("Teacher added successfully to " + schoolName);
    }
}
