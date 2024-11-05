import java.util.*;

public class SchoolSystemWithoutUsingOOP2 {

    static Scanner scanner = new Scanner(System.in);
    static List<HashMap<String, Object>> schools = new ArrayList<>();

    public static void main(String[] args) {
        schools = getSchools();
        System.out.println(schools);
        if (!schools.isEmpty()) {
            listAvailableBooksForSchool();
            manageBookAssignments();
        }
        scanner.close();

    }

    public static List<HashMap<String, Object>> getSchools() {
        List<HashMap<String, Object>> listOfSchools = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to enter a new school? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
            HashMap<String, Object> school = new HashMap<>();
            System.out.println("Enter school name: ");
            school.put("school name", scanner.nextLine());
            System.out.println("Enter address: ");
            school.put("address", scanner.nextLine());

            school.put("Library Books", getBooksForSchoolLibrary());
            List<HashMap<String, Object>> teachers = getTeachers();
            school.put("Teachers", teachers);
            school.put("Students", getStudents(teachers));
            listOfSchools.add(school);
        }
        return listOfSchools;
    }

    public static List<HashMap<String, Object>> getBooksForSchoolLibrary() {
        List<HashMap<String, Object>> listOfBooks = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to enter a new Book for school library? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            HashMap<String, Object> book = new HashMap<>();
            System.out.println("Enter Book name: ");
            book.put("book name", scanner.nextLine());
            System.out.println("Is the book available? (yes/no)");
            String availabilityResponse = scanner.nextLine();
            book.put("availability", availabilityResponse.equalsIgnoreCase("yes"));

            listOfBooks.add(book);
        }
        return listOfBooks;
    }

    public static void listAvailableBooksForSchool() {
        while (true) {
            System.out.println("Do you want to List Books in specific school library? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Enter the name of the school:");
            String schoolName = scanner.nextLine();

            boolean schoolFound = false;
            for (HashMap<String, Object> school : schools) {
                if (school.get("school name").equals(schoolName)) {
                    schoolFound = true;

                    List<HashMap<String, Object>> books = (List<HashMap<String, Object>>) school.get("Library Books");
                    boolean foundAvailableBooks = false;

                    System.out.println("Available Books in " + schoolName + " Library:");
                    for (HashMap<String, Object> book : books) {
                        if ((book.get("availability").equals(true))) {
                            System.out.println("Book name: " + book.get("book name"));
                            foundAvailableBooks = true;
                        }
                    }

                    if (!foundAvailableBooks) {
                        System.out.println("No available books found in the library.");
                    }
                    break;
                }
            }
            if (!schoolFound) {
                System.out.println("School not found.");
            }
        }
    }

    public static void manageBookAssignments() {
        while (true) {
            System.out.println("Do you want to manage book assignments? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
            System.out.println("1- Assign Book to Student");
            System.out.println("2- Return Book");
            System.out.println("3- List Assigned Books for Student");
            System.out.println("Choose an option (1-3):");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    assignBookToStudent();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    listAssignedBooksForStudent();
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void assignBookToStudent() {
        System.out.println("Enter the school name:");
        String schoolName = scanner.nextLine();
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();

        for (HashMap<String, Object> school : schools) {
            if (school.get("school name").equals(schoolName)) {
                List<HashMap<String, Object>> books = (List<HashMap<String, Object>>) school.get("Library Books");
                List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");


                System.out.println("Enter book name to assign:");
                String bookName = scanner.nextLine();
                HashMap<String, Object> bookToAssign = null;

                for (HashMap<String, Object> book : books) {
                    if (book.get("book name").equals(bookName) && book.get("availability").equals(true)) {
                        bookToAssign = book;
                        break;
                    }
                }
                if (bookToAssign != null) {
                    for (HashMap<String, Object> student : students) {
                        if (student.get("student name").equals(studentName)) {
                            if (!student.containsKey("Assigned Books")) {
                                student.put("Assigned Books", new ArrayList<HashMap<String, Object>>());
                            }
                            ((List<HashMap<String, Object>>) student.get("Assigned Books")).add(bookToAssign);
                            bookToAssign.put("availability", false); // Mark book as unavailable
                            System.out.println("Book assigned successfully!");
                            return;
                        }
                    }
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Book not found or not available.");
                }
                return;
            }
        }
        System.out.println("School not found.");
    }

    public static void returnBook() {
        System.out.println("Enter the school name:");
        String schoolName = scanner.nextLine();
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();

        for (HashMap<String, Object> school : schools) {
            if (school.get("school name").equals(schoolName)) {
                List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");

                for (HashMap<String, Object> student : students) {
                    if (student.get("student name").equals(studentName)) {
                        List<HashMap<String, Object>> assignedBooks = (List<HashMap<String, Object>>) student.get("Assigned Books");

                        if (assignedBooks == null || assignedBooks.isEmpty()) {
                            System.out.println("No assigned books found for this student.");
                            return;
                        }

                        System.out.println("Assigned books for this student:");
                        for (HashMap<String, Object> book : assignedBooks) {
                            System.out.println("Book Name: " + book.get("book name"));
                        }

                        System.out.println("Enter book name to return:");
                        String bookName = scanner.nextLine();
                        HashMap<String, Object> bookToReturn = null;

                        for (HashMap<String, Object> book : assignedBooks) {
                            if (book.get("book name").equals(bookName)) {
                                bookToReturn = book;
                                break;
                            }
                        }
                        if (bookToReturn != null) {
                            assignedBooks.remove(bookToReturn);
                            bookToReturn.put("availability", true);
                            System.out.println("Book returned successfully!");
                            return;
                        } else {
                            System.out.println("Book ID not found in assigned books.");
                        }
                        return;
                    }
                }
                System.out.println("Student not found.");
                return;
            }
        }
        System.out.println("School not found.");
    }

    public static void listAssignedBooksForStudent() {
        System.out.println("Enter the school name:");
        String schoolName = scanner.nextLine();
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();

        for (HashMap<String, Object> school : schools) {
            if (school.get("school name").equals(schoolName)) {
                List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");

                for (HashMap<String, Object> student : students) {
                    if (student.get("student name").equals(studentName)) {
                        List<HashMap<String, Object>> assignedBooks = (List<HashMap<String, Object>>) student.get("Assigned Books");
                        System.out.println("Assigned books for student " + studentName + ":");

                        if (assignedBooks == null || assignedBooks.isEmpty()) {
                            System.out.println("No assigned books.");
                        } else {
                            for (HashMap<String, Object> book : assignedBooks) {
                                System.out.println("Book name: " + book.get("book name"));
                            }
                        }
                        return;
                    }
                }
                System.out.println("Student not found.");
                return;
            }
        }
        System.out.println("School not found.");
    }


    public static List<HashMap<String, Object>> getTeachers() {
        List<HashMap<String, Object>> listOfTeachers = new ArrayList<>();
        boolean continueEnteringTeachers = true;

        while (continueEnteringTeachers) {
            System.out.println("1- Do you want to enter a new Teacher? (yes/no)");
            String response = scanner.nextLine();
            HashMap<String, Object> teacher = new HashMap<>();

            if (!response.equalsIgnoreCase("no")) {
                System.out.println("Enter Teacher name: ");
                teacher.put("teacher name", scanner.nextLine());

                teacher.put("Subjects for teacher", getSubjectsForTeacher());
            } else {
                continueEnteringTeachers = false;
            }


            listOfTeachers.add(teacher);
        }

        return listOfTeachers;
    }


    public static List<HashMap<String, Object>> getSubjectsForTeacher() {
        List<HashMap<String, Object>> listOfTeacherSubjects = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to enter a new subject for this teacher? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            HashMap<String, Object> subjectForTeacher = new HashMap<>();
            System.out.println("Enter subject name: ");
            subjectForTeacher.put("Teacher's Subject Name", scanner.nextLine());

            listOfTeacherSubjects.add(subjectForTeacher);
        }
        return listOfTeacherSubjects;
    }

    public static List<HashMap<String, Object>> getStudents(List<HashMap<String, Object>> teachers) {
        List<HashMap<String, Object>> listOfStudents = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to enter a new student? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            HashMap<String, Object> student = new HashMap<>();
            System.out.println("Enter student name: ");
            student.put("student name", scanner.nextLine());
            student.put("Student's Subjects", getStudentSubjects(teachers));
            listOfStudents.add(student);
        }
        return listOfStudents;
    }

    public static List<HashMap<String, Object>> getStudentSubjects(List<HashMap<String, Object>> teachers) {
        List<HashMap<String, Object>> listOfSubjects = new ArrayList<>();

        while (true) {
            System.out.println("Do you want to enter a new subject for the student? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            } else {
                Set<String> offeredSubjects = new HashSet<>();
                for (HashMap<String, Object> teacher : teachers) {
                    List<HashMap<String, Object>> subjectsForTeacher = (List<HashMap<String, Object>>) teacher.get("Subjects for teacher");
                    if (subjectsForTeacher != null) {
                        for (HashMap<String, Object> subject : subjectsForTeacher) {
                            String subjectName = (String) subject.get("Teacher's Subject Name");
                            offeredSubjects.add(subjectName);
                        }
                    }
                }


                if (offeredSubjects.isEmpty()) {
                    System.out.println("No subjects are offered by teachers in this school.");
                    continue;
                }

                System.out.println("Subjects offered by teachers in this school:");
                for (String subjectName : offeredSubjects) {
                    System.out.println("- " + subjectName);
                }

                HashMap<String, Object> subject = new HashMap<>();
                System.out.println("Enter subject name from the offered list:");
                String subjectName = scanner.nextLine();
                if (!offeredSubjects.contains(subjectName)) {
                    System.out.println("Invalid subject. Please choose a subject from the offered list.");
                    continue;
                }
                subject.put("Subject Name", subjectName);

                subject.put("Marks", getMarks());
                listOfSubjects.add(subject);
            }
        }
        return listOfSubjects;
    }


    public static List<HashMap<String, Object>> getMarks() {
        List<HashMap<String, Object>> listOfMarks = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to enter a new test? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            HashMap<String, Object> marks = new HashMap<>();
            System.out.println("Enter test name:");
            marks.put("Test Name", scanner.nextLine());
            System.out.println("Enter marks:");
            marks.put("Marks", scanner.nextInt());
            scanner.nextLine();
            listOfMarks.add(marks);
        }
        return listOfMarks;
    }
}
