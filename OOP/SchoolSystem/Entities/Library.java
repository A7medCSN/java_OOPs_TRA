package OOP.SchoolSystem.Entities;

import java.util.List;

public class Library {
    public List<Book> books;
    public String name;

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", name='" + name + '\'' +
                '}';
    }
}