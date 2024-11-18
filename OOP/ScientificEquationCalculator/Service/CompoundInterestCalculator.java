package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.InterestData;
import OOP.ScientificEquationCalculator.Entities.MotionData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class CompoundInterestCalculator implements CalculatorServiceInterface {

    private final InterestData interestData = new InterestData();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void calculate() {

        System.out.println("enter principle (P):");
        interestData.setPrinciple(scanner.nextFloat());
        System.out.println("enter rate (R):");
        interestData.setRate(scanner.nextFloat());
        System.out.println("enter time (T):");
        interestData.setTime(scanner.nextFloat());

        Float compoundInterest = (float) (interestData.getPrinciple() *
                Math.pow((1 + interestData.getRate() / 100), interestData.getTime()) - interestData.getPrinciple());
        System.out.println("compound interest: " + compoundInterest);
    }
}