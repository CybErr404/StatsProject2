package Project2Part1Java.CSVDataPlotter;

//Import statement for the FileNotFoundException. Added since Plotter deals with files.
import java.io.FileNotFoundException;

/**
 * @author Mia Watts
 * This is the tester class for the Java Data Plotter. Objects are made to calculate values
 * from each formula, printing values into a CSV file in increments from -100 to 100.
 */
public class TestPlotter {
    public static void main(String[] args) throws FileNotFoundException {
        //Stores the plotting results of the polynomial formula.
        Plotter polynomialFormulaPlot = new Plotter();
        //Stores the plotting results of the sine formula.
        Plotter sineFormulaPlot = new Plotter();
        //Stores the plotting results of the cosine formula.
        Plotter cosineFormulaPlot = new Plotter();

        //Writes values calculated from the polynomial formula into a CSV file.
        polynomialFormulaPlot.polynomialPlotter(-100, 100);
        //Writes values calculated from the sine formula into a CSV file.
        sineFormulaPlot.sinePlotter(-100, 100);
        //Writes values calculated from the cosine formula into a CSV file.
        cosineFormulaPlot.cosineWavesPlotter(-100, 100);
    }
}
