package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.PhysicsData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class DensityCalculator implements CalculatorServiceInterface {
    Scanner scanner = new Scanner(System.in);

    private final PhysicsData physicsData = new PhysicsData();

    @Override
    public void calculate() {
        System.out.println("enter mass (M):");
        physicsData.setMass(scanner.nextFloat());
        System.out.println("enter volume (V):");
        physicsData.setVolume(scanner.nextFloat());

        Float density = physicsData.getMass() / physicsData.getVolume();
        System.out.println("Density: " + density + " Kg/m^3");

    }
}
