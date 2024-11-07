package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectServices {
    static Scanner scanner = new Scanner(System.in);

    public static Subject getSubject() {

        Subject subject = new Subject();
        System.out.println("Enter subject Name");
        subject.name = scanner.nextLine();
        System.out.println("Enter subject credits ");
        subject.creditHours = scanner.nextShort();
        scanner.nextLine();

        Boolean flag = true;
        while (flag) {
            System.out.println("is this subject for student? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else {
                subject.marks = MarkServices.addMark();
               break;
            }
        }
        return subject;
    }

    public static List<Subject> addSubject() {
        List<Subject> subjects = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new subject? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else {
                subjects.add(SubjectServices.getSubject());
            }
        }
        return subjects;
    }
}
