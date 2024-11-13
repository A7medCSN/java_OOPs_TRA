package OOP.SchoolSystem.Interfaces;

import OOP.SchoolSystem.Entities.Subject;

import java.util.List;

public interface SubjectServicesInterface {
    Subject enterNewSubject();
    List<Subject> addSubject();
}
