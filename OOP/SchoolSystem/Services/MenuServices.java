package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Interfaces.StudentServicesInterface;

import java.util.List;
import java.util.Scanner;

public class MenuServices {
    static StudentServicesInterface IStudentServices =  new StudentServices();

    public static void showMenu() {

        Scanner scanner = new Scanner(System.in);
        List<School> schoolSystem = SchoolServices.addSchools();

        while (true) {
            System.out.println("\nSchool System Menu:");
            System.out.println("1 - Add New School");
            System.out.println("2 - Add Student to Specific School");
            System.out.println("3 - Add Teacher to Specific School");
            System.out.println("4 - Add Book to Specific School Library");
            System.out.println("5 - Print All School Details");
            System.out.println("6 - Retrieve Marks for Student in Subject");
            System.out.println("7 - Calculate Average Marks for Student");
            System.out.println("8 - Book Management");
            System.out.println("9 - List All Available Books In Specific School Library");
            System.out.println("10 - Exit");
            System.out.print("Choose an option (1-9): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    schoolSystem.add(SchoolServices.createSchool());
                    break;
                case 2:
                    IStudentServices.addStudentToSpecificSchool(schoolSystem);
                    break;
                case 3:
                    TeacherServices.addTeacherToSpecificSchool(schoolSystem);
                    break;
                case 4:
                    LibraryServices.addBookToSpecificSchool(schoolSystem);
                    break;
                case 5:
                    SchoolServices.printAllSchoolDetails(schoolSystem);
                    break;
                case 6:
                    MarkServices.retrieveMarks(schoolSystem);
                    break;
                case 7:
                    MarkServices.calculateAverageMarkForStudent(schoolSystem);
                    break;
                case 8:
                    LibraryServices.bookManagement(schoolSystem);
                    break;
                case 9:
                    LibraryServices.listAllAvailableBooksInSchoolLibrary(schoolSystem);
                    break;
                case 10:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}

