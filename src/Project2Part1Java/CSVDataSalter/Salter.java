package Project2Part1Java.CSVDataSalter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Salter {
    ArrayList<Double> resultArray = new ArrayList<>();
    ArrayList<Double> saltArray = new ArrayList<>();
    public void polynomialSalter(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("PolynomialSalterResults.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = polynomialFormula(i);
            resultArray.add(result);
        }
        for(int i = 0; i < resultArray.size(); i++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(200);
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

    public void sineSalter(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("SineSalterResults.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = sineFormula(i);
            resultArray.add(result);
        }
        for(int i = 0; i < resultArray.size(); i++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(200);
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

    public void cosineWavesSalter(double start, double end) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("CosineSalterResults.csv");
        for(int i = (int) start; i <= end; i++) {
            double result = cosineWavesFormula(i);
            resultArray.add(result);
        }
        for(int i = 0; i < resultArray.size(); i++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(200);
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
