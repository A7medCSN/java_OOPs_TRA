package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Book;
import OOP.SchoolSystem.Entities.School;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServices {
    static Scanner scanner = new Scanner(System.in);

    public static Book putNewBook() {

        Book book = new Book();
        System.out.println("Enter book Name:");
        book.setName(scanner.nextLine());
        System.out.println("Enter book ID:");
        Integer bookID = scanner.nextInt();
        book.setId(bookID);
        scanner.nextLine();
        System.out.println("Enter book's author:");
        String authorName = scanner.nextLine();
        book.setAuthor(authorName);

        System.out.println("Enter book's publishing year:");
        book.setYearOfPublishing(scanner.nextLine());
        System.out.println("is the book available? (true/false):");
        book.setAvailable(scanner.nextBoolean());
        scanner.nextLine();

        return book;

    }

    public static List<Book> addBook() {
        List<Book> books = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new book? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if(response.equalsIgnoreCase("yes")) {
                books.add(BookServices.putNewBook());
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
        return books;
    }


}
