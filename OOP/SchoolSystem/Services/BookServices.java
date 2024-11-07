package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServices {
    static Scanner scanner = new Scanner(System.in);

    public static Book getBook() {

        Book book = new Book();
        System.out.println("Enter book Name");
        book.name = scanner.nextLine();
        System.out.println("Enter book ID");
        book.id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter book's author ");
        book.author = scanner.nextLine();
        System.out.println("Enter book's publishing year");
        book.yearOfPublishing = scanner.nextLine();
        System.out.println("is the book available? (true/false)");
        book.isAvailable=scanner.nextBoolean();
        scanner.nextLine();

        return book;

    }

    public static List<Book> addBook() {
        List<Book> books = new ArrayList<>();
        Boolean flag=true;
        while (flag) {
            System.out.println("do want to add new book? (yes/no) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                flag=false;
            } else {
                books.add(BookServices.getBook());
            }
        }
        return books;
    }

}
