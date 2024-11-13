package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Interfaces.*;

import java.util.List;
import java.util.Scanner;

public class MenuServices implements MenuServicesInterface {
    static StudentServicesInterface IStudentServices =  new StudentServices();
    static MarkServicesInterface IMarkServices =  new MarkServices();
    static LibraryServicesInterface ILibraryServices=new LibraryServices();
    static SchoolServicesInterface ISchoolServices=new SchoolServices();
    static TeacherServicesInterface ITeacherServices=new TeacherServices();





    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        List<School> schoolSystem = ISchoolServices.addSchools();

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
                    schoolSystem.add(ISchoolServices.createSchool());
                    break;
                case 2:
                    IStudentServices.addStudentToSpecificSchool(schoolSystem);
                    break;
                case 3:
                    ITeacherServices.addTeacherToSpecificSchool(schoolSystem);
                    break;
                case 4:
                    ILibraryServices.addBookToSpecificSchool(schoolSystem);
                    break;
                case 5:
                    ISchoolServices.printAllSchoolDetails(schoolSystem);
                    break;
                case 6:
                    IMarkServices.retrieveMarks(schoolSystem);
                    break;
                case 7:
                    IMarkServices.calculateAverageMarkForStudent(schoolSystem);
                    break;
                case 8:
                    ILibraryServices.bookManagement(schoolSystem);
                    break;
                case 9:
                    ILibraryServices.listAllAvailableBooksInSchoolLibrary(schoolSystem);
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

