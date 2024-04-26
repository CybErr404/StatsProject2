package Project2Part3JARs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class JFreeChartPlotterSalterSmoother {
    int window = 4;
    public void jPolynomialPlotter() {
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        double smoothedValue = 0;
        for(int x = -50; x <= 50; x++) {
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            original.add(x, y);
        }
        values.addSeries(original);

        ArrayList<Double> saltedArray = new ArrayList<>();
        for(int x = -50; x <= 50; x++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            if(x % 2 == 0) {
                y = y + randomSaltValue;
                saltedArray.add(y);
            }
            else {
                y = y - randomSaltValue;
                saltedArray.add(y);
            }
            salted.add(x, y);
        }
        values.addSeries(salted);

        for(int x = -50; x <= 50; x++) {
            //Main for loop that will iterate through the salted values.
            for(int i = 0; i < saltedArray.size(); i++) {
                //The next three variables, currentValue, leftSum, and rightSum, store the current index
                //in the array with the salted values, the sum of the values to the left of the
                //current index, and the sum of the values to the right of the current index, respectively.
                double currentValue = saltedArray.get(i);
                double leftSum = 0.0;
                double rightSum = 0.0;
                //Represents the current amount of values that have been considered which
                //will help with calculating the average (i.e., add two numbers and divide by 2 to get average.
                //Two would be the count).
                int count = 1;
                //Keeps track of the bound to ensure values not needing to be added aren't.
                int bound = 1;
                //Checks to see if the current index is not 0 or not the last element.
                if (i != 0 && i != saltedArray.size() - 1) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index minus the bound is greater than 0.
                        if (i - bound >= 0) {
                            //Adds one to count and calculates the current sum of the elements to the left.
                            count = count + 1;
                            leftSum = leftSum + saltedArray.get(i - bound);
                        }
                        //Checks to see if the index added to the bound is less than the array size.
                        else if (i + bound < saltedArray.size()) {
                            //Adds one to count and calculates the current sum of the elements to the right.
                            count = count + 1;
                            rightSum = rightSum + saltedArray.get(i + bound);
                        }
                        //Adds one to the bound so the while loop doesn't run forever.
                        bound++;
                    }
                }
                //Next case which runs when the index is 0.
                else if (i == 0) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index added to the bound is less than the size of the array.
                        if (i + bound < saltedArray.size()) {
                            //Adds one to count and adds to the right sum.
                            count = count + 1;
                            rightSum = rightSum + saltedArray.get(i + bound);
                        }
                        //Adds one to the bound.
                        bound++;
                    }
                }
                //Final case to check if the index is the last element in the array.
                else if (i == saltedArray.size() - 1) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index minus the bound is greater than 0.
                        if (i - bound >= 0) {
                            //Adds one to count and adds to the left sum.
                            count = count + 1;
                            leftSum = leftSum + saltedArray.get(i - bound);
                        }
                        //Adds one to the bound.
                        bound++;
                    }
                }
                //Calculates the moving average, i.e., the new value.
                smoothedValue = (leftSum + rightSum + currentValue) / count;
            }
            smoothed.add(x, smoothedValue);
        }
        values.addSeries(smoothed);

        JFreeChart graph = ChartFactory.createXYLineChart("Data Plotter for 0.1x^2 - 0.5x - 2",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void jSinePlotter() {
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        double smoothedValue = 0;
        for(int x = -50; x <= 50; x++) {
            double y = Math.sin(2 * x);
            original.add(x, y);
        }
        values.addSeries(original);

        ArrayList<Double> saltedArray = new ArrayList<>();
        for(int x = -50; x <= 50; x++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            if(x % 2 == 0) {
                y = y + randomSaltValue;
                saltedArray.add(y);
            }
            else {
                y = y - randomSaltValue;
                saltedArray.add(y);
            }
            salted.add(x, y);
        }
        values.addSeries(salted);

        for(int x = -50; x <= 50; x++) {
            //Main for loop that will iterate through the salted values.
            for(int i = 0; i < saltedArray.size(); i++) {
                //The next three variables, currentValue, leftSum, and rightSum, store the current index
                //in the array with the salted values, the sum of the values to the left of the
                //current index, and the sum of the values to the right of the current index, respectively.
                double currentValue = saltedArray.get(i);
                double leftSum = 0.0;
                double rightSum = 0.0;
                //Represents the current amount of values that have been considered which
                //will help with calculating the average (i.e., add two numbers and divide by 2 to get average.
                //Two would be the count).
                int count = 1;
                //Keeps track of the bound to ensure values not needing to be added aren't.
                int bound = 1;
                //Checks to see if the current index is not 0 or not the last element.
                if (i != 0 && i != saltedArray.size() - 1) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index minus the bound is greater than 0.
                        if (i - bound >= 0) {
                            //Adds one to count and calculates the current sum of the elements to the left.
                            count = count + 1;
                            leftSum = leftSum + saltedArray.get(i - bound);
                        }
                        //Checks to see if the index added to the bound is less than the array size.
                        else if (i + bound < saltedArray.size()) {
                            //Adds one to count and calculates the current sum of the elements to the right.
                            count = count + 1;
                            rightSum = rightSum + saltedArray.get(i + bound);
                        }
                        //Adds one to the bound so the while loop doesn't run forever.
                        bound++;
                    }
                }
                //Next case which runs when the index is 0.
                else if (i == 0) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index added to the bound is less than the size of the array.
                        if (i + bound < saltedArray.size()) {
                            //Adds one to count and adds to the right sum.
                            count = count + 1;
                            rightSum = rightSum + saltedArray.get(i + bound);
                        }
                        //Adds one to the bound.
                        bound++;
                    }
                }
                //Final case to check if the index is the last element in the array.
                else if (i == saltedArray.size() - 1) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index minus the bound is greater than 0.
                        if (i - bound >= 0) {
                            //Adds one to count and adds to the left sum.
                            count = count + 1;
                            leftSum = leftSum + saltedArray.get(i - bound);
                        }
                        //Adds one to the bound.
                        bound++;
                    }
                }
                smoothedValue = (leftSum + rightSum + currentValue) / count;
            }
            //Adds the smoothed value to the array.
            smoothed.add(x, smoothedValue);
        }
        values.addSeries(smoothed);

        JFreeChart graph = ChartFactory.createXYLineChart("Data Plotter for sin(2x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void jCosineWavesPlotter() {
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        double smoothedValue = 0;
        for(int x = -50; x <= 50; x++) {
            double y = (3 * Math.cos(x)) - (5 * Math.cos(2 * x))
                    - (2 * Math.cos(3 * x)) - (Math.cos(4 * x));
            original.add(x, y);
        }
        values.addSeries(original);

        ArrayList<Double> saltedArray = new ArrayList<>();
        for(int x = -50; x <= 50; x++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            if(x % 2 == 0) {
                y = y + randomSaltValue;
                saltedArray.add(y);
            }
            else {
                y = y - randomSaltValue;
                saltedArray.add(y);
            }
            salted.add(x, y);
        }
        values.addSeries(salted);

        for(int x = -50; x <= 50; x++) {
            //Main for loop that will iterate through the salted values.
            for(int i = 0; i < saltedArray.size(); i++) {
                //The next three variables, currentValue, leftSum, and rightSum, store the current index
                //in the array with the salted values, the sum of the values to the left of the
                //current index, and the sum of the values to the right of the current index, respectively.
                double currentValue = saltedArray.get(i);
                double leftSum = 0.0;
                double rightSum = 0.0;
                //Represents the current amount of values that have been considered which
                //will help with calculating the average (i.e., add two numbers and divide by 2 to get average.
                //Two would be the count).
                int count = 1;
                //Keeps track of the bound to ensure values not needing to be added aren't.
                int bound = 1;
                //Checks to see if the current index is not 0 or not the last element.
                if (i != 0 && i != saltedArray.size() - 1) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index minus the bound is greater than 0.
                        if (i - bound >= 0) {
                            //Adds one to count and calculates the current sum of the elements to the left.
                            count = count + 1;
                            leftSum = leftSum + saltedArray.get(i - bound);
                        }
                        //Checks to see if the index added to the bound is less than the array size.
                        else if (i + bound < saltedArray.size()) {
                            //Adds one to count and calculates the current sum of the elements to the right.
                            count = count + 1;
                            rightSum = rightSum + saltedArray.get(i + bound);
                        }
                        //Adds one to the bound so the while loop doesn't run forever.
                        bound++;
                    }
                }
                //Next case which runs when the index is 0.
                else if (i == 0) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index added to the bound is less than the size of the array.
                        if (i + bound < saltedArray.size()) {
                            //Adds one to count and adds to the right sum.
                            count = count + 1;
                            rightSum = rightSum + saltedArray.get(i + bound);
                        }
                        //Adds one to the bound.
                        bound++;
                    }
                }
                //Final case to check if the index is the last element in the array.
                else if (i == saltedArray.size() - 1) {
                    //While loop to ensure the bound never surpasses the window.
                    while (bound <= window) {
                        //Checks to see if the index minus the bound is greater than 0.
                        if (i - bound >= 0) {
                            //Adds one to count and adds to the left sum.
                            count = count + 1;
                            leftSum = leftSum + saltedArray.get(i - bound);
                        }
                        //Adds one to the bound.
                        bound++;
                    }
                }
                smoothedValue = (leftSum + rightSum + currentValue) / count;
                //Adds the smoothed value to the array.
            }
            smoothed.add(x, smoothedValue);
        }
        values.addSeries(smoothed);

        JFreeChart graph =
                ChartFactory.createXYLineChart("Data Plotter for 3cos(x) - 5cos(2x) - 2cos(3x) - cos(4x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JFreeChartPlotterSalterSmoother test = new JFreeChartPlotterSalterSmoother();
        test.jPolynomialPlotter();
        test.jSinePlotter();
        test.jCosineWavesPlotter();
    }
}
