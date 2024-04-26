package Project2Part3JARs;

//Import statements for the JFreeChart additions. These include charts and XYSeries.
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//Import statements for Java Swing (GUI), ArrayLists, and the Random class.
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Mia Watts
 * This class is the JFreeChart plotter, salter, and smoother in which external .jar files
 * are used to help with the plotting, salting, and smoothing process. Each method deals with
 * a different formula to ensure that three figures are created that display the graphs with
 * the original values, salted values, and smoothed values.
 */
public class JFreeChartPlotterSalterSmoother {
    //Window variable used for all smoothing sections in the methods.
    int window = 4;

    /**
     * This is the polynomial plotter method. It calculates the values from the original formula,
     * Math.pow((0.1 * x), 2) - (0.5 * x) - 2, salts these values, and smooths them. After
     * doing this, the method displays the results using JFreeChart.
     */
    public void jPolynomialPlotter() {
        //Creates XYSeries that are used for the graphing process.
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        //Sets the smoothed value to 0 to start.
        double smoothedValue = 0;
        //Iterates through x-values from -50 to 50.
        for(int x = -50; x <= 50; x++) {
            //Calculates the y-value and adds x and y to the original dataset.
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            original.add(x, y);
        }
        //Adds the original values to the series.
        values.addSeries(original);

        //Creates an array to store the salted values.
        ArrayList<Double> saltedArray = new ArrayList<>();
        //Iterates through the x-values.
        for(int x = -50; x <= 50; x++) {
            //Creates a random number object.
            Random randomNumber = new Random();
            //Creates a random number.
            int randomSaltValue = randomNumber.nextInt(100);
            //Calculates the y-value.
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            if(x % 2 == 0) {
                //Adds the salt value to the original and saves the result in an array.
                y = y + randomSaltValue;
                saltedArray.add(y);
            }
            else {
                //Subtracts the salt value from the original and saves the result in an array.
                y = y - randomSaltValue;
                saltedArray.add(y);
            }
            //Adds x and y values to the salted dataset.
            salted.add(x, y);
        }
        //Adds salted values to the series.
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
            //Adds x and y values to the series.
            smoothed.add(x, smoothedValue);
        }
        //Adds the smoothed values series to the overall values that will be displayed.
        values.addSeries(smoothed);

        //Creates a graph with a title, lines, and axis labels.
        JFreeChart graph = ChartFactory.createXYLineChart("Data Plotter for 0.1x^2 - 0.5x - 2",
                "X-Value (Increment)", "Y-Value (Result)", values);

        //Displays the graph properly by setting the background color, panels, location, and visibility.
        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    /**
     * This is the sine plotter method. It calculates the values from the original formula,
     * sin(2x), salts these values, and smooths them. After doing this, the method displays the
     * results using JFreeChart.
     */
    public void jSinePlotter() {
        //Creates XYSeries that are used for the graphing process.
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        //Sets the smoothed value to 0.
        double smoothedValue = 0;
        //Iterates through x-values between and including -50 and 50.
        for(int x = -50; x <= 50; x++) {
            //Caculates the result and adds the x and y values to the original dataset.
            double y = Math.sin(2 * x);
            original.add(x, y);
        }
        //Adds the original dataset to the overal series.
        values.addSeries(original);

        //Creates the ArrayList that will store salted values.
        ArrayList<Double> saltedArray = new ArrayList<>();
        //Iterates through x-values between and including -50 and 50.
        for(int x = -50; x <= 50; x++) {
            //Generates a random number.
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            //Calculates the y-value.
            double y = Math.sin(2 * x);
            if(x % 2 == 0) {
                //Adds the salt value to y and stores it in the salted values array.
                y = y + randomSaltValue;
                saltedArray.add(y);
            }
            else {
                //Subtracts the salt value from y and stores it in the salted values array.
                y = y - randomSaltValue;
                saltedArray.add(y);
            }
            //Adds the x and y values to the series.
            salted.add(x, y);
        }
        //Adds the salted series to the values collection.
        values.addSeries(salted);

        //Iterates through x-values of -50 and 50 once more.
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
        //Adds the smoothed series to the collection.
        values.addSeries(smoothed);

        //Creates a graph with a title, the value series collection, and axis labels.
        JFreeChart graph = ChartFactory.createXYLineChart("Data Plotter for sin(2x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        //Sets chart parameters such as the color, size, panel, and location.
        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    /**
     * This is the cosine plotter method. It calculates the values from the original formula,
     * (3 * Math.cos(x)) - (5 * Math.cos(2 * x) - (2 * Math.cos(3 * x)) - (Math.cos(4 * x)),
     * salts these values, and smooths them. After doing this, the method displays the results
     * using JFreeChart.
     */
    public void jCosineWavesPlotter() {
        //Creates the XYSeries collection and original, salted, and smoothed series.
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        //Stores the smoothed value and sets it to 0.
        double smoothedValue = 0;
        //Iterates through -50 and 50.
        for(int x = -50; x <= 50; x++) {
            //Calculates the y-value and adds the x and y values to the original series.
            double y = (3 * Math.cos(x)) - (5 * Math.cos(2 * x))
                    - (2 * Math.cos(3 * x)) - (Math.cos(4 * x));
            original.add(x, y);
        }
        //Adds the original series to the collection.
        values.addSeries(original);

        //Creates an ArrayList that will store the salted results.
        ArrayList<Double> saltedArray = new ArrayList<>();
        //Iterates through -50 and 50.
        for(int x = -50; x <= 50; x++) {
            //Creates a random number generation.
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            //Calculates y-value for salting.
            double y = (3 * Math.cos(x)) - (5 * Math.cos(2 * x))
                    - (2 * Math.cos(3 * x)) - (Math.cos(4 * x));
            if(x % 2 == 0) {
                //Adds the salt value to y and stores it in the salted values array.
                y = y + randomSaltValue;
                saltedArray.add(y);
            }
            else {
                //Subtracts the salt value from y and stores it in the salted values array.
                y = y - randomSaltValue;
                saltedArray.add(y);
            }
            //Adds x and y to the salted series.
            salted.add(x, y);
        }
        //Adds the salted series to the collection.
        values.addSeries(salted);

        //Iterates through -50 and 50.
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
            //Adds the x and y values to the smoothed series.
            smoothed.add(x, smoothedValue);
        }
        //Adds the smoothed series to the collection.
        values.addSeries(smoothed);

        //Creates a graph with a title, axis labels, and a series collection.
        JFreeChart graph =
                ChartFactory.createXYLineChart("Data Plotter for 3cos(x) - 5cos(2x) - 2cos(3x) - cos(4x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        //Formats the graph with background colors, size, and panels.
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
        //Creates a new object to be tested.
        JFreeChartPlotterSalterSmoother test = new JFreeChartPlotterSalterSmoother();
        //Tests the polynomial JFreeChart plotter, salter, and smoother.
        test.jPolynomialPlotter();
        //Tests the sine JFreeChart plotter, salter, and smoother.
        test.jSinePlotter();
        //Tests the cosine JFreeChart plotter, salter, and smoother.
        test.jCosineWavesPlotter();
    }
}
