import java.util.*;

public class SchoolSystemWithOutUsingOOP {

    static Scanner scanner = new Scanner(System.in);
    static List<HashMap<String, Object>> schools = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
        scanner.close();

    }

    public static void mainMenu() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1- Add new school");
            System.out.println("2- Print schools");
            System.out.println("3- retrieve Marks For Student In Subject");
            System.out.println("4- calculate Average Marks For Student");
            System.out.println("5- Exit");
            System.out.print("Choose an option (1-5): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    getSchools();
                    break;
                case 2:
                    System.out.println(schools);
                    break;
                case 3:
                    retrieveMarksForStudentInSubject();
                    break;
                case 4:
                    calculateAverageMarksForStudent();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void getSchools() {
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

            school.put("Students", getStudents());
            schools.add(school);
            //listOfSchools.add(school);
        }
        //return listOfSchools;
    }

    public static List<HashMap<String, Object>> getStudents() {
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

            student.put("Subjects", getSubjects());
            listOfStudents.add(student);
        }
        return listOfStudents;
    }

    public static List<HashMap<String, Object>> getSubjects() {
        List<HashMap<String, Object>> listOfSubjects = new ArrayList<>();
        while (true) {
            System.out.println("Do you want to enter a new subject? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            HashMap<String, Object> subject = new HashMap<>();
            System.out.println("Enter subject name: ");
            subject.put("Subject Name", scanner.nextLine());

            subject.put("Marks", getMarks());
            listOfSubjects.add(subject);
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

    public static void retrieveMarksForStudentInSubject() {
        while (true) {
            System.out.println("Do you want to retrieve Marks For Student In Subject? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Enter school name:");
            String schoolName = scanner.nextLine();
            System.out.println("Enter student name:");
            String studentName = scanner.nextLine();
            System.out.println("Enter subject name:");
            String subjectName = scanner.nextLine();

            boolean found = false;
            for (HashMap<String, Object> school : schools) {
                if (school.get("school name").equals(schoolName)) {
                    List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");
                    for (HashMap<String, Object> student : students) {
                        if (student.get("student name").equals(studentName)) {
                            List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("Subjects");
                            for (HashMap<String, Object> subject : subjects) {
                                if (subject.get("Subject Name").equals(subjectName)) {
                                    List<HashMap<String, Object>> marks = (List<HashMap<String, Object>>) subject.get("Marks");
                                    System.out.println("Marks for " + subjectName + ": " + marks);
                                    found = true;
                                    break;
                                }
                            }
                            if (found) break;
                        }
                    }
                    if (found) break;
                }
            }
            if (!found) {
                System.out.println("No data found for the specified student and subject.");
            }
        }
    }

    public static void calculateAverageMarksForStudent() {
        while (true) {
            System.out.println("Do you want to calculate Average Marks For Student? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Enter school name:");
            String schoolName = scanner.nextLine();
            System.out.println("Enter student name:");
            String studentName = scanner.nextLine();

            boolean isStudentInfoFounded= false;
            for (HashMap<String, Object> school : schools) {
                if (school.get("school name").equals(schoolName)) {
                    List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");
                    for (HashMap<String, Object> student : students) {
                        if (student.get("student name").equals(studentName)) {
                            List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("Subjects");
                            int totalMarks = 0;
                            int count = 0;
                            for (HashMap<String, Object> subject : subjects) {
                                List<HashMap<String, Object>> marksList = (List<HashMap<String, Object>>) subject.get("Marks");
                                for (HashMap<String, Object> marks : marksList) {
                                    totalMarks += (int) marks.get("Marks");
                                    count++;
                                }
                            }
                            if (count > 0) {
                                double averageMarks = (double) totalMarks / count;
                                System.out.println("Average Marks for student " + studentName + ": " + averageMarks);
                            } else {
                                System.out.println("No marks isStudentInfoFounded for the specified student.");
                            }
                            isStudentInfoFounded = true;
                            break;
                        }
                    }
                    if (isStudentInfoFounded) break;
                }
            }
            if (!isStudentInfoFounded) {
                System.out.println("No data isStudentInfoFounded for the specified student.");
            }
        }
    }
}
