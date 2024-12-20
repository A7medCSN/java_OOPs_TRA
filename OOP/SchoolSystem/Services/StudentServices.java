package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Entities.Student;
import OOP.SchoolSystem.Interfaces.StudentServicesInterface;
import OOP.SchoolSystem.Interfaces.SubjectServicesInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServices implements StudentServicesInterface {
    static Scanner scanner = new Scanner(System.in);
    static SubjectServicesInterface subjectServicesInterface =new SubjectServices();


    public Student enterNewStudent() {

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

        student.setCourses(subjectServicesInterface.addSubject());

        return student;

    }


    public List<Student> addStudents() {
        List<Student> students = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new student? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                students.add(enterNewStudent());
            } else {
                System.out.println("Invalid Input. Please try again.");
            }

        }
        return students;
    }

    public void addStudentToSpecificSchool(List<School> schools) {

        if (schools.isEmpty()) {
            System.out.println("No schools available. Please add a school first.");
            return;
        }

        System.out.println("Enter the school name to add a new student:");
        String schoolName = scanner.nextLine();

        School targetSchool = null;
        for (School school : schools) {
            if (school.getName().equalsIgnoreCase(schoolName)) {
                targetSchool = school;
                break;
            }
        }

        if (targetSchool == null) {
            System.out.println("School not found. Please try again.");
            return;
        }

        Student newStudent = enterNewStudent();
        if (targetSchool.getStudents() == null) {
            targetSchool.setStudents(new ArrayList<>());
        }
        targetSchool.getStudents().add(newStudent);

        System.out.println("Student added successfully to " + targetSchool.getName());
    }
}

