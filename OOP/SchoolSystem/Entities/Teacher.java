package OOP.SchoolSystem.Entities;

import java.util.List;

public class Teacher {
    public String name;
    public String id;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", subjectsExpertiseList=" + subjectsExpertiseList +
                '}';
    }

    public Short yearsOfExperience;
    public List<Subject> subjectsExpertiseList; //Descriptive name to mention it is a list
}