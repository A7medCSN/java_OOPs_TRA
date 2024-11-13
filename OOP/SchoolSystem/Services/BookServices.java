package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Book;
import OOP.SchoolSystem.Interfaces.BookServicesInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServices implements BookServicesInterface {
    static Scanner scanner = new Scanner(System.in);

    public Book putNewBook() {

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

    public  List<Book> addBook() {
        List<Book> books = new ArrayList<>();
        Boolean flag = true;
        while (flag) {
            System.out.println("do want to add new book? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag = false;
            } else if(response.equalsIgnoreCase("yes")) {
                books.add(putNewBook());
            }
            else {
                System.out.println("Invalid Input. Please try again.");
            }
        }
        return books;
    }


}
