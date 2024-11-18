package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.CircleData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class AreaOfCircleCalculator implements CalculatorServiceInterface {

    private final CircleData circleData = new CircleData();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void calculate() {
        System.out.println("enter radius (r):");
        circleData.setRadius(scanner.nextFloat());

        Float area = (float) (Math.PI * (circleData.getRadius() * circleData.getRadius()));
        System.out.println("Area of Circle: " + area + " square units");
    }
}

