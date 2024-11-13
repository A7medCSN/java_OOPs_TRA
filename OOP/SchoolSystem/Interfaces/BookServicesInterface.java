package OOP.SchoolSystem.Interfaces;

import OOP.SchoolSystem.Entities.Book;

import java.util.List;

public interface BookServicesInterface {

    Book putNewBook();
    List<Book> addBook();
}
