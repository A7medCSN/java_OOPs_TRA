package OOP.SchoolSystem.Entities;

import java.util.Date;

public class Book {
    public String name;
    public String author;
    public Integer id;
    public String yearOfPublishing;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", yearOfPublishing='" + yearOfPublishing + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public Boolean isAvailable;

}
