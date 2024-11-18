package OOP.ScientificEquationCalculator;

import OOP.ScientificEquationCalculator.Interface.CalculatorMenuServiceInterface;
import OOP.ScientificEquationCalculator.Service.MenuService;


public class ScientificEquationCalculatorDriver {
    static CalculatorMenuServiceInterface IMenu=new MenuService();

    public static void main(String[] args) {
        IMenu.showMenu();

    }
}
