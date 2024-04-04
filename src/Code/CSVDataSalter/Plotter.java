package Code.CSVDataSalter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plotter {
    ArrayList<Double> resultArray = new ArrayList<>();
    public void plotter1(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("data1.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = formula1(i);
            resultArray.add(result);
        }
        for (Double number : resultArray) {
            writer.println(number);
        }
        writer.close();
    }

    public void plotter2(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("data2.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = formula2(i);
            resultArray.add(result);
        }
        for (Double number : resultArray) {
            writer.println(number);
        }
        writer.close();
    }

    public double formula1(double increment) {
        return Math.pow(increment, 2) + (3 * increment) + 5;
    }

    public double formula2(double increment) { return Math.sin(increment); }
}
