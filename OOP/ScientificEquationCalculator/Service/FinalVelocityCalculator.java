package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.MotionData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class FinalVelocityCalculator implements CalculatorServiceInterface {

    private final MotionData motionData = new MotionData();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void calculate() {
        System.out.println("enter initial velocity (u):");
        motionData.setInitialVelocity(scanner.nextFloat());
        System.out.println("enter acceleration (a):");
        motionData.setAcceleration(scanner.nextFloat());
        System.out.println("enter time (t):");
        motionData.setTime(scanner.nextFloat());

        Float finalVelocity = motionData.getInitialVelocity() +
                (motionData.getAcceleration() * motionData.getTime());
        System.out.println("Final Velocity: " + finalVelocity + " m/s");

    }
}
