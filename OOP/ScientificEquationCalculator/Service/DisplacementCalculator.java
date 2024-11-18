package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.MotionData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class DisplacementCalculator implements CalculatorServiceInterface {

    private final MotionData motionData = new MotionData();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void calculate() {
        System.out.println("enter initial velocity (u):");
        motionData.setInitialVelocity(scanner.nextFloat());
        System.out.println("enter acceleration (a):");
        motionData.setAcceleration(scanner.nextFloat());
        System.out.println("enter time (t) :");
        motionData.setTime(scanner.nextFloat());

        Float displacement = (float) (motionData.getInitialVelocity() * motionData.getTime()
                + 0.5 * motionData.getAcceleration() * Math.pow(motionData.getTime(), 2));
        System.out.println("Displacement: " + displacement + "m");
    }
}
