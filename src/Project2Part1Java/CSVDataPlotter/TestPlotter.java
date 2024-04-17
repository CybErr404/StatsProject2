package Project2Part1Java.CSVDataPlotter;

import java.io.FileNotFoundException;

public class TestPlotter {
    public static void main(String[] args) throws FileNotFoundException {
        Plotter polynomialFormulaPlot = new Plotter();
        Plotter sineFormulaPlot = new Plotter();
        Plotter cosineFormulaPlot = new Plotter();
        polynomialFormulaPlot.polynomialPlotter(-100, 100);
        sineFormulaPlot.sinePlotter(-100, 100);
        cosineFormulaPlot.cosineWavesPlotter(-100, 100);
    }
}
