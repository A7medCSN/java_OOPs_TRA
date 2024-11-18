package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.MotionData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class FinalVelocitySquaredCalculator implements CalculatorServiceInterface {

    private final MotionData motionData = new MotionData();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void calculate() {
        System.out.println("enter initial velocity (u):");
        motionData.setInitialVelocity(scanner.nextFloat());
        System.out.println("enter acceleration (a):");
        motionData.setAcceleration(scanner.nextFloat());
        System.out.println("enter time (t) to calculate density (s):");
        motionData.setTime(scanner.nextFloat());


        Float displacement = (float) (motionData.getInitialVelocity() * motionData.getTime()
                + 0.5 * motionData.getAcceleration() * Math.pow(motionData.getTime(), 2));

        Float finalVelocitySquared = (float) (Math.pow(motionData.getInitialVelocity(), 2)
                + 2 * motionData.getAcceleration() * displacement);

        System.out.println("Final Velocity Squared: " + finalVelocitySquared + " (m/s)^2");
    }
}
