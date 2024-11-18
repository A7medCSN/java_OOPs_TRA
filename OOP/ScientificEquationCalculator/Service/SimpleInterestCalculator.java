package OOP.ScientificEquationCalculator.Service;

import OOP.ScientificEquationCalculator.Entities.InterestData;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class SimpleInterestCalculator implements CalculatorServiceInterface {

    private final InterestData interestData = new InterestData();
    Scanner scanner = new Scanner(System.in);


    @Override
    public void calculate() {

        System.out.println("enter principle:");
        interestData.setPrinciple(scanner.nextFloat());
        System.out.println("enter rate:");
        interestData.setRate(scanner.nextFloat());
        System.out.println("enter time:");
        interestData.setTime(scanner.nextFloat());

        Float simpleInterest = (interestData.getPrinciple() * interestData.getRate() * interestData.getTime()) / 100;
        System.out.println("Simple Interest: " + simpleInterest);
    }
}
