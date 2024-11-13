package OOP.SchoolSystem.Interfaces;

import OOP.SchoolSystem.Entities.Mark;
import OOP.SchoolSystem.Entities.School;

import java.util.List;

public interface MarkServicesInterface {
    Mark enterMark();
    List<Mark> addMark();
    void retrieveMarks(List<School> schools);
    void calculateAverageMarkForStudent(List<School> schools);

}
