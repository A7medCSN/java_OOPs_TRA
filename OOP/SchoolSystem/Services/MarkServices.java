package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Mark;
import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Entities.Student;
import OOP.SchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarkServices {
    static Scanner scanner = new Scanner(System.in);

    public static Mark getMark() {

        Mark mark = new Mark();
        System.out.println("Enter mark ");
        mark.marks = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter grade ");
        mark.grade = scanner.nextLine();

        System.out.println("Enter description ");
        mark.description = scanner.nextLine();
        return mark;

    }

    public static List<Mark> addMark() {
        List<Mark> marks = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new mark? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else {
                marks.add(MarkServices.getMark());
            }
        }
        return marks;
    }

    public static void retrieveMarks(List<School> schools) {

        System.out.println("retrieving marks for a student: ");
        System.out.println("enter school name: ");
        String schoolName = scanner.nextLine();
        System.out.println("enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("enter subject name: ");
        String subjectName = scanner.nextLine();

        for (School school : schools) {
            if (school.name.equalsIgnoreCase(schoolName)) {
                for (Student student : school.students) {
                    if (student.name.equalsIgnoreCase(studentName)) {
                        for (Subject subject : student.courses) {
                            if (subject.name.equalsIgnoreCase(subjectName)) {
                                System.out.println("Marks for " + studentName + " in " + schoolName + ":");
                                for (Mark mark : subject.marks) {
                                    System.out.println("Mark: " + mark.marks
                                            + ", Grade: " + mark.grade + ", Description: " + mark.description);
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
    }

    public static void calculateAverageMarkForStudent(List<School> schools) {
        System.out.println("Enter school name: ");
        String schoolName = scanner.nextLine();
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter subject name: ");
        String subjectName = scanner.nextLine();

        for (School school : schools) {
            if (school.name.equalsIgnoreCase(schoolName)) {
                for (Student student : school.students) {
                    if (student.name.equalsIgnoreCase(studentName)) {
                        for (Subject subject : student.courses) {
                            if (subject.name.equalsIgnoreCase(subjectName)) {
                                double totalMarks = 0;
                                int markCount = 0;

                                for (Mark mark : subject.marks) {
                                    totalMarks += mark.marks;
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
    }



}

