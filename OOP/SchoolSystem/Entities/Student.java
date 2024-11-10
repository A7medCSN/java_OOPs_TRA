package OOP.SchoolSystem.Entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
     public String id;
    public String name;
    public String grade;
    public Short age;
    public List<Subject> courses;
    public List<Book> assignedBooks = new ArrayList<>();;
}