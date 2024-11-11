package OOP.SchoolSystem.Entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public String id;
    public String name;
    public String grade;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                ", assignedBooks=" + assignedBooks +
                '}';
    }

    public Short age;
    public List<Subject> courses;
    public List<Book> assignedBooks = new ArrayList<>();
    ;
}