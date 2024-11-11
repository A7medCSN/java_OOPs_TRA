package OOP.SchoolSystem.Entities;

import java.util.List;

public class Subject {
    public String name;
    public Short creditHours;
    public List<Mark> marks;

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", creditHours=" + creditHours +
                ", marks=" + marks +
                '}';
    }
}