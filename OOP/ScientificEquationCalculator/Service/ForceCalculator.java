package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.PhysicsData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class ForceCalculator implements CalculatorServiceInterface {
    Scanner scanner = new Scanner(System.in);

    private final PhysicsData physicsData = new PhysicsData();

    @Override
    public void calculate() {
        System.out.println("enter acceleration (a):");
        physicsData.setAcceleration(scanner.nextFloat());
        System.out.println("enter mass (M):");
        physicsData.setMass(scanner.nextFloat());

        Float force = physicsData.getMass() * physicsData.getAcceleration();
        System.out.println("Force: " + force + " N");

    }
}
