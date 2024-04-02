package Code.CSVDataSalter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plotter {
    ArrayList<Double> resultArray = new ArrayList<>();
    public void plotter(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("data.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = formula(i);
            resultArray.add(result);
        }
        for (Double number : resultArray) {
            writer.println(number);
        }
        writer.close();
    }

    public double formula(double increment) {
        return Math.pow(increment, 2) + (3 * increment) + 5;
    }
}
