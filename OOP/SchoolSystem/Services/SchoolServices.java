package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.*;

import java.util.*;

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
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new school? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else {
                schools.add(SchoolServices.getSchool());
            }
        }
        return schools;
    }
    public static void printAllSchoolDetails(List<School> schools) {
        if (schools.isEmpty()) {
            System.out.println("No schools available.");
            return;
        }
        for (School school : schools) {
            System.out.println("\nSchool Name: " + school.name);
            System.out.println("Address: " + school.address);
            // Library details
            System.out.println("Library:");
            if (school.library != null && school.library.books != null) {
                for (Book book : school.library.books) {
                    System.out.println("  Book Title: " + book.name + ", Author: " + book.author);
                }
            } else {
                System.out.println("  No books available.");
            }
            // Teachers details
            System.out.println("Teachers:");
            if (school.teachers != null) {
                for (Teacher teacher : school.teachers) {
                    System.out.println("  Teacher Name: " + teacher.name + ", Subjects: " + teacher.subjectsExpertiseList);
                }
            } else {
                System.out.println("  No teachers available.");
            }
            // Students and their subjects and marks
            System.out.println("Students:");
            if (school.students != null) {
                for (Student student : school.students) {
                    System.out.println("  Student Name: " + student.name);
                    // Subjects and marks for each student
                    if (student.courses != null) {
                        for (Subject subject : student.courses) {
                            System.out.println("    Subject Name: " + subject.name);
                            if (subject.marks != null) {
                                for (Mark mark : subject.marks) {
                                    System.out.println("      Test: " + mark.description + ", Score: " + mark.marks+ ", Grade: " + mark.grade);
                                }
                            } else {
                                System.out.println("      No marks available.");
                            }
                        }
                    } else {
                        System.out.println("    No subjects available.");
                    }
                }
            } else {
                System.out.println("  No students available.");
            }
        }
    }

}