package OOP.SchoolSystem.Interfaces;

import OOP.SchoolSystem.Entities.Library;
import OOP.SchoolSystem.Entities.School;

import java.util.List;

public interface LibraryServicesInterface {
    Library createLibrary();
    void bookManagement(List<School> schools);
    void assignBookToStudent(List<School> schools);
    void returnBook(List<School> schools);
    void listAssignedBooksForStudent(List<School> schools);
    void addBookToSpecificSchool(List<School> schoolSystem);
    void listAllAvailableBooksInSchoolLibrary(List<School> schoolSystem);

}
