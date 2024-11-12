package OOP.SchoolSystem.Entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private String grade;
    private Short age;
    private List<Subject> courses;
    private List<Book> assignedBooks = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public List<Subject> getCourses() {
        return courses;
    }

    public void setCourses(List<Subject> courses) {
        this.courses = courses;
    }

    public List<Book> getAssignedBooks() {
        return assignedBooks;
    }

    public void setAssignedBooks(List<Book> assignedBooks) {
        this.assignedBooks = assignedBooks;
    }

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
}