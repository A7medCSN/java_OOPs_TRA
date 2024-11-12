package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Library;
import OOP.SchoolSystem.Entities.Book;
import OOP.SchoolSystem.Entities.Student;
import OOP.SchoolSystem.Entities.School;


import java.util.List;
import java.util.Scanner;

public class LibraryServices {
    static Scanner scanner = new Scanner(System.in);

    public static Library createLibrary() {
        Library library = new Library();
        System.out.println("Enter library name: ");
        library.setName(scanner.nextLine());
        library.setBooks(BookServices.addBook());

        return library;
    }

    public static void bookManagement(List<School> schools) {
        while (true) {
            System.out.println("\nBook Management Menu:");
            System.out.println("1 - Assign Book to Student");
            System.out.println("2 - Return Book");
            System.out.println("3 - List Assigned Books for Student");
            System.out.println("4 - Exit Book Management");
            System.out.print("Choose an option (1-4): ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    assignBookToStudent(schools);
                    break;
                case 2:
                    returnBook(schools);
                    break;
                case 3:
                    listAssignedBooksForStudent(schools);
                    break;
                case 4:
                    System.out.println("Exiting Book Management.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void assignBookToStudent(List<School> schools) {
        System.out.println("Enter school name:");
        String schoolName = scanner.nextLine();
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter book name to assign:");
        String bookName = scanner.nextLine();

        boolean isAssigned = false;
        for (School school : schools) {
            if (school.getName().equals(schoolName)) {
                for (Student student : school.getStudents()) {
                    if (student.getName().equals(studentName)) {
                        for (Book book : school.getLibrary().getBooks()) {
                            if (book.getName().equals(bookName) && book.getAvailable()) {
                                student.getAssignedBooks().add(book);
                                book.setAvailable(false);
                                System.out.println("Book '" + bookName + "' has been assigned to " + studentName + ".");
                                isAssigned = true;
                                break;
                            }
                        }
                    }
                    if (isAssigned) break;
                }
            }
            if (isAssigned) break;
        }

        if (!isAssigned) {
            System.out.println("Assignment failed. Check if the school, student, or book name is correct, or if the book is available.");
        }
    }

    public static void returnBook(List<School> schools) {
        System.out.println("Enter school name:");
        String schoolName = scanner.nextLine();
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter book name to return:");
        String bookName = scanner.nextLine();

        boolean isReturned = false;
        for (School school : schools) {
            if (school.getName().equals(schoolName)) {
                for (Student student : school.getStudents()) {
                    if (student.getName().equals(studentName)) {
                        for (Book book : student.getAssignedBooks()) {
                            if (book.getName().equals(bookName)) {
                                book.setAvailable(true);
                                student.getAssignedBooks().remove(book);
                                System.out.println("Book '" + bookName + "' has been returned by " + studentName + ".");
                                isReturned = true;
                                break;
                            }
                        }
                    }
                    if (isReturned) break;
                }
            }
            if (isReturned) break;
        }

        if (!isReturned) {
            System.out.println("Return failed. Check if the school, student, or book name is correct.");
        }
    }

    public static void listAssignedBooksForStudent(List<School> schools) {
        System.out.println("Enter school name:");
        String schoolName = scanner.nextLine();
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();

        boolean studentFound = false;
        for (School school : schools) {
            if (school.getName().equals(schoolName)) {
                for (Student student : school.getStudents()) {
                    if (student.getName().equals(studentName)) {
                        System.out.println("Books assigned to " + studentName + ":");
                        for (Book book : student.getAssignedBooks()) {
                            System.out.println("- " + book.getName());
                        }
                        studentFound = true;
                        break;
                    }
                }
            }
            if (studentFound) break;
        }

        if (!studentFound) {
            System.out.println("Student not found. Check if the school or student name is correct.");
        }
    }
}
