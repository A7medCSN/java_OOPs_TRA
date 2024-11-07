package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Library;

import java.util.Scanner;

public class LibraryServices {
    static Scanner scanner = new Scanner(System.in);

    public static Library getLibrary() {
        Library library = new Library();
        System.out.println("Enter library name: ");
        library.name = scanner.nextLine();

        library.books=BookServices.addBook();

        return library;
    }
}
