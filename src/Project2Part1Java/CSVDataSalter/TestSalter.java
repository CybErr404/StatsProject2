package Project2Part1Java.CSVDataSalter;

import Project2Part1Java.CSVDataPlotter.Plotter;

import java.io.FileNotFoundException;

public class TestSalter {
    public static void main(String[] args) throws FileNotFoundException {
        Salter polynomialFormulaSalt = new Salter();
        Salter sineFormulaSalt = new Salter();
        Salter cosineFormulaSalt = new Salter();
        polynomialFormulaSalt.polynomialSalter(-100, 100);
        sineFormulaSalt.sineSalter(-100, 100);
        cosineFormulaSalt.cosineWavesSalter(-100, 100);
    }
}
