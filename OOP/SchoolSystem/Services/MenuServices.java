package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Interfaces.*;

import java.util.List;
import java.util.Scanner;

public class MenuServices implements MenuServicesInterface {
    static StudentServicesInterface studentServicesInterface =  new StudentServices();
    static MarkServicesInterface markServicesInterface =  new MarkServices();
    static LibraryServicesInterface libraryServicesInterface =new LibraryServices();
    static SchoolServicesInterface schoolServicesInterface =new SchoolServices();
    static TeacherServicesInterface teacherServicesInterface =new TeacherServices();


    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        List<School> schoolSystem = schoolServicesInterface.addSchools();

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
                    schoolSystem.add(schoolServicesInterface.createSchool());
                    break;
                case 2:
                    studentServicesInterface.addStudentToSpecificSchool(schoolSystem);
                    break;
                case 3:
                    teacherServicesInterface.addTeacherToSpecificSchool(schoolSystem);
                    break;
                case 4:
                    libraryServicesInterface.addBookToSpecificSchool(schoolSystem);
                    break;
                case 5:
                    schoolServicesInterface.printAllSchoolDetails(schoolSystem);
                    break;
                case 6:
                    markServicesInterface.retrieveMarks(schoolSystem);
                    break;
                case 7:
                    markServicesInterface.calculateAverageMarkForStudent(schoolSystem);
                    break;
                case 8:
                    libraryServicesInterface.bookManagement(schoolSystem);
                    break;
                case 9:
                    libraryServicesInterface.listAllAvailableBooksInSchoolLibrary(schoolSystem);
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

