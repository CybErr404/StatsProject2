package Project2Part1Java.CSVDataPlotter;

//These import statements are used for the CSV file writer, which will add values to a CSV file when run.
import java.io.FileNotFoundException;
import java.io.PrintWriter;
//This statement is used to import ArrayLists which are used in this case to store incremental results.
import java.util.ArrayList;

/**
 * @author Mia Watts
 * This is the Plotter class for Project 2 Part 1. This class was created to run three formulas,
 * a polynomial formula, a sine formula, and a cosine formula, and store the results in a result array.
 * Once the results have been stored, the program writes these values into a CSV file with a name
 * designated by the user within the code. Three methods were programmed to write information to the
 * files, and three methods were programmed underneath these to calculate results from formulas.
 */
public class Plotter {
    //ArrayList that stores the results calculated from each formula.
    ArrayList<Double> resultArray = new ArrayList<>();

    /**
     * This method is a polynomial plotter. It takes a formula, calculates values,
     * adds the values to an ArrayList, and writes the values to a CSV file for graphing use.
     * @param start - starting increment value.
     * @param end - ending increment value.
     * @throws FileNotFoundException - a file is written to, so the exception was added just in case.
     */
    public void polynomialPlotter(double start, double end) throws FileNotFoundException {
        //Creates a PrintWriter object that takes the name of a CSV file as a parameter.
        PrintWriter writer = new PrintWriter("PolynomialPlotterResults.csv");
        //Uses the start and end increment to calculate results from the polynomial formula.
        for(int i = (int) start; i <= end; i++) {
            //Stores the current result.
            double result = polynomialFormula(i);
            //Adds the result to the array.
            resultArray.add(result);
        }
        //Writes the values in the array into the CSV file.
        for (Double number : resultArray) {
            writer.println(number);
        }
        //Closes the writer to avoid leaks.
        writer.close();
    }

    /**
     * This method is a sine plotter. It takes a formula, calculates values,
     * adds the values to an ArrayList, and writes the values to a CSV file for graphing use.
     * @param start - starting increment value.
     * @param end - ending increment value.
     * @throws FileNotFoundException - a file is written to, so the exception was added just in case.
     */
    public void sinePlotter(double start, double end) throws FileNotFoundException {
        //Creates a PrintWriter object that takes the name of a CSV file as a parameter.
        PrintWriter writer = new PrintWriter("SinePlotterResults.csv");
        //Uses the start and end increment to calculate results from the sine formula.
        for(int i = (int) start; i <= end; i++) {
            //Stores the current result.
            double result = sineFormula(i);
            //Adds the current result to the ArrayList.
            resultArray.add(result);
        }
        //Writes the values in the array into the CSV file.
        for (Double number : resultArray) {
            writer.println(number);
        }
        //Closes the writer to avoid leaks.
        writer.close();
    }

    /**
     * This method is a cosine plotter. It takes a formula, calculates values,
     * adds the values to an ArrayList, and writes the values to a CSV file for graphing use.
     * @param start - starting increment value.
     * @param end - ending increment value.
     * @throws FileNotFoundException - a file is written to, so the exception was added just in case.
     */
    public void cosineWavesPlotter(double start, double end) throws FileNotFoundException {
        //Creates a PrintWriter object that takes the name of a CSV file as a parameter.
        PrintWriter writer = new PrintWriter("CosinePlotterResults.csv");
        //Uses the start and end increment to calculate results from the sine formula.
        for(int i = (int) start; i <= end; i++) {
            //Stores the current result.
            double result = cosineWavesFormula(i);
            //Adds the current result to the ArrayList.
            resultArray.add(result);
        }
        //Writes the values in the array into the CSV file.
        for (Double number : resultArray) {
            writer.println(number);
        }
        //Closes the writer to avoid leaks.
        writer.close();
    }

    /**
     * This method calculates the result of inputting an x-value into 0.1x^2 - 0.5x - 2.
     * @param increment - represents the x-value given to the equation.
     * @return the result of calculating the equation with the given x-value.
     */
    public double polynomialFormula(double increment) {
        return Math.pow((0.1 * increment), 2) - (0.5 * increment) - 2;
    }

    /**
     * This method calculates the result of inputting an x-value into sin(2x).
     * @param increment - represents the x-value given to the equation.
     * @return the result of calculating the equation with the given x-value.
     */
    public double sineFormula(double increment) {
        return Math.sin(2 * increment);
    }

    /**
     * This method calculates the result of inputting an x-value into
     * 3cos(x) - 5cos(2x) - 2cos(3x) - cos(4x).
     * @param increment - represents the x-value given to the equation.
     * @return the result of calculating the equation with the given x-value.
     */
    public double cosineWavesFormula(double increment) {
        return (3 * Math.cos(increment)) - (5 * Math.cos(2 * increment))
                - (2 * Math.cos(3 * increment)) - (Math.cos(4 * increment));
    }
}
