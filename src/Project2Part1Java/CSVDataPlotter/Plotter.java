package Project2Part1Java.CSVDataPlotter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plotter {
    ArrayList<Double> resultArray = new ArrayList<>();
    public void polynomialPlotter(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("PolynomialPlotterResults.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = polynomialFormula(i);
            resultArray.add(result);
        }
        for (Double number : resultArray) {
            writer.println(number);
        }
        writer.close();
    }

    public void sinePlotter(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("SinePlotterResults.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = sineFormula(i);
            resultArray.add(result);
        }
        for (Double number : resultArray) {
            writer.println(number);
        }
        writer.close();
    }

    public void cosineWavesPlotter(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("CosinePlotterResults.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = cosineWavesFormula(i);
            resultArray.add(result);
        }
        for (Double number : resultArray) {
            writer.println(number);
        }
        writer.close();
    }

    public double polynomialFormula(double increment) {
        return Math.pow((0.1 * increment), 2) - (0.5 * increment) - 2;
    }

    public double sineFormula(double increment) {
        return Math.sin(2 * increment);
    }

    public double cosineWavesFormula(double increment) {
        return (3 * Math.cos(increment)) - (5 * Math.cos(2 * increment))
                - (2 * Math.cos(3 * increment)) - (Math.cos(4 * increment));
    }
}
