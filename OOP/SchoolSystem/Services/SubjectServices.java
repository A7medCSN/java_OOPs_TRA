package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Subject;
import OOP.SchoolSystem.Interfaces.MarkServicesInterface;
import OOP.SchoolSystem.Interfaces.SubjectServicesInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectServices implements SubjectServicesInterface {
    static Scanner scanner = new Scanner(System.in);
    static MarkServicesInterface markServicesInterface =  new MarkServices();


    public Subject enterNewSubject() {

        Subject subject = new Subject();
        System.out.println("Enter subject Name");
        subject.setName(scanner.nextLine());
        System.out.println("Enter subject credits ");
        subject.setCreditHours(scanner.nextShort());
        scanner.nextLine();

        Boolean flag = true;
        while (flag) {
            System.out.println("is this subject for student? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                subject.setMarks(markServicesInterface.addMark());
                break;
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
        return subject;
    }

    public List<Subject> addSubject() {
        List<Subject> subjects = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new subject? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if (response.equalsIgnoreCase("yes")) {
                subjects.add(enterNewSubject());
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
        return subjects;
    }
}
