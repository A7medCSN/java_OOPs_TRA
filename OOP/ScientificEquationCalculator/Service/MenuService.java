package OOP.ScientificEquationCalculator.Service;

import OOP.SchoolSystem.Interfaces.MenuServicesInterface;
import OOP.ScientificEquationCalculator.Interface.CalculatorMenuServiceInterface;
import OOP.ScientificEquationCalculator.Interface.CalculatorServiceInterface;

import java.util.Scanner;

public class MenuService implements CalculatorMenuServiceInterface {
    static CalculatorServiceInterface finalVelocityInterface = new FinalVelocityCalculator();
    static CalculatorServiceInterface displacementInterface = new DisplacementCalculator();
    static CalculatorServiceInterface finalVelocitySquaredInterface = new FinalVelocitySquaredCalculator();
    static CalculatorServiceInterface areaOfCircleInterface = new AreaOfCircleCalculator();
    static CalculatorServiceInterface simpleInterestInterface = new SimpleInterestCalculator();
    static CalculatorServiceInterface forceInterface = new ForceCalculator();
    static CalculatorServiceInterface compoundInterestInterface = new CompoundInterestCalculator();
    static CalculatorServiceInterface densityInterface = new DensityCalculator();

    @Override
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Final Velocity (v = u + at)");
            System.out.println("2. Displacement (s = ut + ½at²)");
            System.out.println("3. Final Velocity Squared (v² = u² + 2as)");
            System.out.println("4. Area of a Circle (A = πr²)");
            System.out.println("5. Simple Interest (SI = P × R × T ÷ 100)");
            System.out.println("6. Force (F = ma)");
            System.out.println("7. Density (Density = Mass ÷ Volume)");
            System.out.println("8. Compound Interest (CI = P × (1 + R ÷ 100)^T - P)");
            System.out.println("9. Exit");
            System.out.println("Choose option (1-9)");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    finalVelocityInterface.calculate();
                    break;
                case 2:
                    displacementInterface.calculate();
                    break;
                case 3:
                    finalVelocitySquaredInterface.calculate();
                    break;
                case 4:
                    areaOfCircleInterface.calculate();
                    break;
                case 5:
                    simpleInterestInterface.calculate();
                    break;
                case 6:
                    forceInterface.calculate();
                    break;
                case 7:
                    densityInterface.calculate();
                    break;
                case 8:
                    compoundInterestInterface.calculate();
                    break;
                case 9:
                    System.out.println("Exiting ...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");

            }

        }

    }
}
