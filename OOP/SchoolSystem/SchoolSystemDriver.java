package OOP.SchoolSystem;

import OOP.SchoolSystem.Entities.School;
import OOP.SchoolSystem.Services.LibraryServices;
import OOP.SchoolSystem.Services.MarkServices;
import OOP.SchoolSystem.Services.SchoolServices;

import java.util.List;


public class SchoolSystemDriver {

    public static void main(String[] args){
        List<School> schoolSystem= SchoolServices.addSchools();
       //MarkServices.retrieveMarks(schoolSystem);
        LibraryServices.bookManagement(schoolSystem);
        SchoolServices.printAllSchoolDetails(schoolSystem);

    }
}
