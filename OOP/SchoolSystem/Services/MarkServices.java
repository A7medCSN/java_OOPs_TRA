package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Mark;
import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Entities.Student;
import OOP.SchoolSystem.Entities.Subject;
import OOP.SchoolSystem.Interfaces.MarkServicesInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarkServices implements MarkServicesInterface {
    static Scanner scanner = new Scanner(System.in);

    public Mark enterMark() {

        Mark mark = new Mark();
        System.out.println("Enter mark: ");
        mark.setMarks(scanner.nextFloat());
        scanner.nextLine();
        System.out.println("Enter grade: ");
        mark.setGrade(scanner.nextLine());
        System.out.println("Enter description: ");
        mark.setDescription(scanner.nextLine());
        return mark;

    }

    public List<Mark> addMark() {
        List<Mark> marks = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new mark? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                marks.add(enterMark());
            } else {
                System.out.println("Invalid Input. Please try again.");
            }

        }
        return marks;
    }

    public void retrieveMarks(List<School> schools) {

        if (schools.isEmpty()) {
            System.out.println("No schools available. Please add a school first.");
            return;
        }

        Boolean flage = true;
        while (flage) {
            System.out.println("Do you want to retrieve mark for a student? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flage = false;
            } else if (response.equalsIgnoreCase("yes")) {
                System.out.println("retrieving marks for a student: ");
                System.out.println("enter school name: ");
                String schoolName = scanner.nextLine();
                System.out.println("enter student name: ");
                String studentName = scanner.nextLine();
                System.out.println("enter subject name: ");
                String subjectName = scanner.nextLine();

                for (School school : schools) {
                    if (school.getName().equalsIgnoreCase(schoolName)) {
                        for (Student student : school.getStudents()) {
                            if (student.getName().equalsIgnoreCase(studentName)) {
                                for (Subject subject : student.getCourses()) {
                                    if (subject.getName().equalsIgnoreCase(subjectName)) {
                                        System.out.println("Marks for " + studentName + " in " + schoolName + ":");
                                        for (Mark mark : subject.getMarks()) {
                                            System.out.println("Mark: " + mark.getMarks()
                                                    + ", Grade: " + mark.getGrade() + ", Description: " + mark.getDescription());
                                        }
                                        return;
                                    }
                                }
                                System.out.println("Subject not found.");
                                return;
                            }
                        }
                        System.out.println("Student not found.");
                        return;
                    }
                }
                System.out.println("School not found.");
            } else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }

    public void calculateAverageMarkForStudent(List<School> schools) {

        if (schools.isEmpty()) {
            System.out.println("No schools available. Please add a school first.");
            return;
        }

        Boolean flage = true;
        while (flage) {
            System.out.println("Do you want to calculate average mark for a student? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flage = false;
            } else if (response.equalsIgnoreCase("yes")) {
                System.out.println("Enter school name: ");
                String schoolName = scanner.nextLine();
                System.out.println("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.println("Enter subject name: ");
                String subjectName = scanner.nextLine();

                for (School school : schools) {
                    if (school.getName().equalsIgnoreCase(schoolName)) {
                        for (Student student : school.getStudents()) {
                            if (student.getName().equalsIgnoreCase(studentName)) {
                                for (Subject subject : student.getCourses()) {
                                    if (subject.getName().equalsIgnoreCase(subjectName)) {
                                        double totalMarks = 0;
                                        int markCount = 0;

                                        for (Mark mark : subject.getMarks()) {
                                            totalMarks += mark.getMarks();
                                            markCount++;
                                        }

                                        if (markCount > 0) {
                                            double averageMark = totalMarks / markCount;
                                            System.out.println("Average mark for " + studentName + " in " + subjectName + " at " + schoolName + ": " + averageMark);
                                        } else {
                                            System.out.println("No marks available for " + subjectName);
                                        }
                                        return;
                                    }
                                }
                                System.out.println("Subject not found.");
                                return;
                            }
                        }
                        System.out.println("Student not found.");
                        return;
                    }
                }
                System.out.println("School not found.");
            } else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
    }
}

