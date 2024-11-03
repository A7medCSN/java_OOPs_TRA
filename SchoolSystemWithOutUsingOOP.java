import java.util.*;

public class SchoolSystemWithOutUsingOOP {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<HashMap<String, Object>> schools = getSchools();
        System.out.println(schools);
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

            school.put("Students", getStudents());
            listOfSchools.add(school);
        }
        return listOfSchools;
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
            System.out.println("Enter student id: ");
            student.put("student id", scanner.nextLine());
            System.out.println("Enter student grade: ");
            student.put("grade", scanner.nextLine());
            System.out.println("Enter student age:");
            student.put("age", scanner.nextShort());
            scanner.nextLine();

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
            System.out.println("Enter teacher name: ");
            subject.put("Teacher's Name", scanner.nextLine());
            System.out.println("Enter credit hours: ");
            subject.put("Credit Hours", scanner.nextShort());
            scanner.nextLine();

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
            if (response.equalsIgnoreCase("no")){
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
