package OOP.SchoolSystem.Interfaces;

import OOP.SchoolSystem.Entities.School;

import java.util.List;

public interface SchoolServicesInterface {
    School createSchool();
    List<School> addSchools();
    void printAllSchoolDetails(List<School> schools);

}
