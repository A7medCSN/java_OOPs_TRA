package OOP.SchoolSystem.Entities;

public class Mark {
    private Float marks;
    private String grade;
    private String description;

    public Float getMarks() {
        return marks;
    }

    public void setMarks(Float marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "marks=" + marks +
                ", grade='" + grade + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}