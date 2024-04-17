package Project2Part1Java.CSVDataPlotter;

import java.io.FileNotFoundException;

public class TestPlotter {
    public static void main(String[] args) throws FileNotFoundException {
        Plotter polynomialFormulaPlot = new Plotter();
        Plotter sineFormulaPlot = new Plotter();
        Plotter cosineFormulaPlot = new Plotter();
        polynomialFormulaPlot.polynomialPlotter(-8, 8);
        sineFormulaPlot.sinePlotter(-5, 5);
        cosineFormulaPlot.cosineWavesPlotter(-10, 10);
    }
}
