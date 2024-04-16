package CSVJavaDataSalter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Salter {
    ArrayList<Double> resultArray = new ArrayList<>();
    ArrayList<Double> saltArray = new ArrayList<>();
    public void salter1(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("salt1.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = formula1(i);
            resultArray.add(result);
        }
        for(int i = 0; i < resultArray.size(); i++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(50);
            if(i % 2 == 0) {
                saltArray.add(resultArray.get(i) + randomSaltValue);
            }
            else {
                saltArray.add(resultArray.get(i) - randomSaltValue);
            }
        }
        for (Double number : saltArray) {
            writer.println(number);
        }
        writer.close();
    }

    public void salter2(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("salt2.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = formula2(i);
            resultArray.add(result);
        }
        for(int i = 0; i < resultArray.size(); i++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(50);
            if(i % 2 == 0) {
                saltArray.add(resultArray.get(i) + randomSaltValue);
            }
            else {
                saltArray.add(resultArray.get(i) - randomSaltValue);
            }
        }
        for (Double number : saltArray) {
            writer.println(number);
        }
        writer.close();
    }

    public double formula1(double increment) {
        return Math.pow(increment, 2) + (3 * increment) + 5;
    }

    public double formula2(double increment) { return Math.sin(increment); }
}
