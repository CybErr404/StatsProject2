package Code.CSVDataSalter;

import java.io.FileNotFoundException;

public class TestPlotter {
    public static void main(String[] args) throws FileNotFoundException {
        Plotter testFormula1 = new Plotter();
        Plotter testFormula2 = new Plotter();
        testFormula1.polynomialPlotter(1, 10);
        testFormula2.sinePlotter(1, 10);
    }
}
