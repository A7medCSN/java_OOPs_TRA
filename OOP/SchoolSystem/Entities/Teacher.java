package OOP.SchoolSystem.Entities;

import java.util.List;

public class Teacher {
    private String name;
    private String id;
    private Short yearsOfExperience;
    private List<Subject> subjectsExpertiseList; //Descriptive name to mention it is a list

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Short yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public List<Subject> getSubjectsExpertiseList() {
        return subjectsExpertiseList;
    }

    public void setSubjectsExpertiseList(List<Subject> subjectsExpertiseList) {
        this.subjectsExpertiseList = subjectsExpertiseList;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", subjectsExpertiseList=" + subjectsExpertiseList +
                '}';
    }
}