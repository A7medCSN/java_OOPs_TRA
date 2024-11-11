package OOP.SchoolSystem.Entities;

public class Mark {
    public Float marks;
    public String grade;

    @Override
    public String toString() {
        return "Mark{" +
                "marks=" + marks +
                ", grade='" + grade + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String description;
}