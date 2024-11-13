package OOP.SchoolSystem.Interfaces;

import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Entities.Student;

import java.util.List;

public interface StudentServicesInterface {

    Student enterNewStudent();
    List<Student> addStudents();
    void addStudentToSpecificSchool(List<School> schools);
}
