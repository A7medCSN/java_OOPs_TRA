package OOP.SchoolSystem.Entities;

import java.util.List;

public class School {

    public String name;
    public String address;
    public List<Student> students;
    public List<Teacher> teachers;
    public Library library;


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