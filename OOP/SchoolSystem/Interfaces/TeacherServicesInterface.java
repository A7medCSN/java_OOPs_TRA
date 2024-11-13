package OOP.SchoolSystem.Interfaces;

import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Entities.Teacher;

import java.util.List;

public interface TeacherServicesInterface {

    Teacher enterNewTeacher();
    List<Teacher> addTeacher();
    void addTeacherToSpecificSchool(List<School> schoolSystem);
}
