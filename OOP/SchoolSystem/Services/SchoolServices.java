package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.*;

import java.util.*;

public class SchoolServices {
    static Scanner scanner = new Scanner(System.in);

    public static School createSchool() {

        School school = new School();
        System.out.println("Enter School Name:");
        school.setName(scanner.nextLine());

        System.out.println("Enter School Address:");
        school.setAddress(scanner.nextLine());

        school.setLibrary(LibraryServices.createLibrary());
        school.setStudents(StudentServices.addStudents());
        school.setTeachers(TeacherServices.addTeacher());

        return school;
    }

    public static List<School> addSchools() {
        List<School> schools = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new school? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                schools.add(SchoolServices.createSchool());
            }
            else {
                System.out.println("Invalid Input. Please try again.");
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
            System.out.println("\nSchool Name: " + school.getName());
            System.out.println("Address: " + school.getAddress());
            // Library details
            System.out.println("Library name: "+school.getLibrary().getName());
            if (school.getLibrary() != null && school.getLibrary().getBooks() != null) {
                System.out.println("Available Books at Library: ");
                for (Book book : school.getLibrary().getBooks()) {
                    System.out.println("  Book Title: " + book.getName() + ", BookID: " + book.getId()
                            + ", Author: " + book.getAuthor()+ ", Year of publishing: "
                            + book.getYearOfPublishing()+ ", is available?: " + book.getAvailable());
                }
            } else {
                System.out.println("  No books available.");
            }

            System.out.println("Teachers:");
            if (school.getTeachers() != null) {
                for (Teacher teacher : school.getTeachers()) {
                    System.out.println("  Teacher Name: " + teacher.getName() + ", TeacherID: " + teacher.getId()
                            + ", Subjects Expertise: " + teacher.getSubjectsExpertiseList()+ ", Years of Experience: " + teacher.getYearsOfExperience());
                }
            } else {
                System.out.println("  No teachers available.");
            }

            System.out.println("Students:");
            if (school.getStudents() != null) {
                for (Student student : school.getStudents()) {
                    System.out.println("  Student Name: " + student.getName()+"  StudentID: " + student.getId()
                            +"  Student grade: " + student.getGrade()+"  Student age: " + student.getAge());

                    if (student.getCourses() != null) {
                        for (Subject subject : student.getCourses()) {
                            System.out.println("    Subject Name: " + subject.getName());
                            if (subject.getMarks() != null) {
                                for (Mark mark : subject.getMarks()) {
                                    System.out.println("      Test: " + mark.getDescription() + ", Score: " + mark.getMarks()+ ", Grade: " + mark.getGrade());
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