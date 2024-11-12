package OOP.SchoolSystem.Entities;

import jdk.jfr.BooleanFlag;

import java.util.List;
import java.util.Scanner;

public class School {

    private String name;
    private String address;
    private List<Student> students;
    private List<Teacher> teachers;
    private Library library;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", students=" + students +
                ", teachers=" + teachers +
                ", library=" + library +
                '}';
    }
}