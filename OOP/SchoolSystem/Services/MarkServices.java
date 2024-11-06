package OOP.SchoolSystem.Services;

import OOP.SchoolSystem.Entities.Mark;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarkServices {
    static Scanner scanner = new Scanner(System.in);

    public static Mark getMark() {

        Mark mark = new Mark();
        System.out.println("Enter mark ");
        mark.marks = scanner.nextFloat();
        System.out.println("Enter grade ");
        mark.grade= scanner.nextLine();

        System.out.println("Enter description ");
        mark.description= scanner.nextLine();
        return mark;

    }

    public static List<Mark> addMark() {
        List<Mark> marks = new ArrayList<>();
        Boolean flag=true;
        while (flag) {
            System.out.println("do want to add new mark? (yes/no) ");
            String response=scanner.nextLine();
            if (response.equalsIgnoreCase("no")){
                flag=false;
            }
            else{
                marks.add(MarkServices.getMark());
            }}
        return marks;
    }
}
