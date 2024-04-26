package Project2Part3JARs;

//Import statements for the Apache Commons Math mean and sine methods/functions.
import org.apache.commons.math4.legacy.analysis.function.Sin;
import org.apache.commons.math4.legacy.stat.descriptive.moment.Mean;

//Import statements for the Apache Commons random number generator.
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

//Import statements for ArrayLists, writing to a file, and making sure the file exists.
import java.io.*;
import java.util.ArrayList;

/**
 * @author Mia Watts
 * This class is the Apache Commons plotter, salter, and smoother. Imported methods are used to
 * recreate the original plotter, salter, and smoother. To lessen the amount of repetitive code,
 * I decided to program the sine function only. This sine function is slightly
 * different from the other in that it is sin(2x + 1) instead of sin(2x). This is to add
 * variability to the program. To see the other functions and how
 * they look after being salted and smoothed, see the Java iteration documentation or files.
 */
public class ApacheCommonsPlotterSalterSmoother {
    //Creates the mean object that will be used to help recreate the methods.
    Mean mean = new Mean();
    //Creates the sine object that will be used to help calculate the result.
    Sin sine = new Sin();
    //Creates the result array that will store results calculated from the formula.
    ArrayList<Double> resultArray = new ArrayList<>();
    //Creates the array that will store salted values.
    ArrayList<Double> saltArray = new ArrayList<>();
    //Creates the array that will store smoothed values.
    ArrayList<Double> smoothedArray = new ArrayList<>();

    /**
     * This method is the Apache sine plotter. It uses Apache Math Commons's sine method when
     * calling the sineFormula rather than Java's Math.sin.
     * @param start - beginning increment.
     * @param end - ending increment.
     * @throws FileNotFoundException - in case file is not found when being written to.
     */
    public void apacheSinePlotter(double start, double end) throws FileNotFoundException {
        //Creates a PrintWriter object that takes the name of a CSV file as a parameter.
        PrintWriter writer = new PrintWriter("ApacheSinePlotterResults.csv");
        //Uses the start and end increment to calculate results from the polynomial formula.
        for(int i = (int) start; i <= end; i++) {
            //Stores the current result.
            double result = sineFormula(i);
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
     * This method calculates the result of inputting an x-value into sin(2x + 1).
     * It uses the Apache Math Commons sine method rather than Java's Math sine method.
     * @param increment - represents the x-value given to the equation.
     * @return the result of calculating the equation with the given x-value.
     */
    public double sineFormula(double increment) {
        return sine.value((2 * increment) + 1);
    }

    /**
     * Salts the values calculated from the sine formula. If the index in the iteration
     * is even, the randomly generated salt value is added to the original value. If the index
     * of the iteration is odd, the randomly generated salt value is subtracted from the original
     * value. Reads information from the plotter result file.
     * @param file - file name that will be read.
     * @throws IOException - in case the file to be read cannot be found.
     */
    public void apacheSineSalter(String file) throws IOException {
        //Creates a new BufferedReader object that will read the plotter results file.
        BufferedReader reader = new BufferedReader(new FileReader(file));
        //Declares a variable that will hold the current line in the file.
        String currentLine;
        //While loop that continues until the next line is empty.
        while((currentLine = reader.readLine()) != null) {
            //Stores values found within the file into an array, splitting each by commas.
            String[] values = currentLine.split(",");
            //For loop that adds all values in the array to the result ArrayList.
            for (String value : values) {
                //Adds information to the result array.
                resultArray.add(Double.valueOf(value));
            }
        }
        //Creates the PrintWriter object that will be used to write values to the CSV file.
        PrintWriter writer = new PrintWriter("ApacheSineSalterResults.csv");
        //Salts the values by randomly generating a number.
        for(int i = 0; i < resultArray.size(); i++) {
            UniformRandomProvider rng = RandomSource.XO_RO_SHI_RO_128_PP.create();
            double randomNumber = rng.nextDouble(50);
            //If the index is even, add the randomly generated salt value to the original value.
            if(i % 2 == 0) {
                saltArray.add(resultArray.get(i) + randomNumber);
            }
            //If the index is odd, subtract the randomly generated salt value from the original value.
            else {
                saltArray.add(resultArray.get(i) - randomNumber);
            }
        }
        //Writes the new, salted values to the file.
        for (Double number : saltArray) {
            writer.println(number);
        }
        //Closes the file to avoid leaks.
        writer.close();
    }

    /**
     * This method is an Apache data smoother for the sine equation results after they have
     * been salted. The method reads the data from the CSV salt file, smooths it, then writes
     * the new, smoothed values to a new CSV file.
     * @param file - file to be read.
     * @param window - the range of values to the left and right that will be averaged.
     * @throws IOException - in case the file cannot be found, read, or written to.
     */
    public void apacheSineSmoother(String file, int window) throws IOException {
        //Creates a new BufferedReader object that will read the plotter results file.
        BufferedReader reader = new BufferedReader(new FileReader(file));
        //Declares a variable that will hold the current line in the file.
        String currentLine;
        //While loop that continues until the next line is empty.
        while((currentLine = reader.readLine()) != null) {
            //Stores values found within the file into an array, splitting each by commas.
            String[] values = currentLine.split(",");
            //For loop that adds all values in the array to the result ArrayList.
            for (String value : values) {
                //Adds information to the result array.
                saltArray.add(Double.valueOf(value));
            }
        }
        //Creates the PrintWriter object that will be used to write values to the CSV file.
        PrintWriter writer = new PrintWriter("ApacheSineSmootherResults.csv");
        //Main for loop that will iterate through the values read from the salt file.
        for(int i = 0; i < saltArray.size(); i++) {
            //The next three variables, currentValue, leftSum, and rightSum, store the current index
            //in the array with the salted values, the sum of the values to the left of the
            //current index, and the sum of the values to the right of the current index, respectively.
            double currentValue = saltArray.get(i);
            double leftSum = 0.0;
            double rightSum = 0.0;
            //Represents the current amount of values that have been considered which
            //will help with calculating the average (i.e., add two numbers and divide by 2 to get average.
            //Two would be the count).
            int count = 1;
            //Keeps track of the bound to ensure values not needing to be added aren't.
            int bound = 1;
            //Checks to see if the current index is not 0 or not the last element.
            if (i != 0 && i != saltArray.size() - 1) {
                //While loop to ensure the bound never surpasses the window.
                while(bound <= window) {
                    //Checks to see if the index minus the bound is greater than 0.
                    if(i - bound >= 0) {
                        //Adds one to count and calculates the current sum of the elements to the left.
                        count = count + 1;
                        leftSum = leftSum + saltArray.get(i - bound);
                    }
                    //Checks to see if the index added to the bound is less than the array size.
                    else if(i + bound < saltArray.size()) {
                        //Adds one to count and calculates the current sum of the elements to the right.
                        count = count + 1;
                        rightSum = rightSum + saltArray.get(i + bound);
                    }
                    //Adds one to the bound so the while loop doesn't run forever.
                    bound++;
                }
            }
            //Next case which runs when the index is 0.
            else if (i == 0) {
                //While loop to ensure the bound never surpasses the window.
                while(bound <= window) {
                    //Checks to see if the index added to the bound is less than the size of the array.
                    if(i + bound < saltArray.size()) {
                        //Adds one to count and adds to the right sum.
                        count = count + 1;
                        rightSum = rightSum + saltArray.get(i + bound);
                    }
                    //Adds one to the bound.
                    bound++;
                }
            }
            //Final case to check if the index is the last element in the array.
            else if (i == saltArray.size() - 1) {
                //While loop to ensure the bound never surpasses the window.
                while(bound <= window) {
                    //Checks to see if the index minus the bound is greater than 0.
                    if (i - bound >= 0) {
                        //Adds one to count and adds to the left sum.
                        count = count + 1;
                        leftSum = leftSum + saltArray.get(i - bound);
                    }
                    //Adds one to the bound.
                    bound++;
                }
            }
            //Adds the left sum, right sum, and current value to an array.
            double[] meanValues = {leftSum, rightSum, currentValue};
            //Calculates the moving average, i.e., the new value with Apache Commons Math.
            double smoothedValue = mean.evaluate(meanValues);
            //Adds the smoothed value to the array.
            smoothedArray.add(smoothedValue);
        }
        //Writes the new, smoothed values to the file.
        for (Double number : smoothedArray) {
            writer.println(number);
        }
        //Closes the file to avoid leaks.
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        //Creates a test object that will be used to test the methods.
        ApacheCommonsPlotterSalterSmoother test = new ApacheCommonsPlotterSalterSmoother();
        //Tests the polynomial apache plotter, salter, and smoother.
        test.apacheSinePlotter(-50, 50);
        //Tests the sine apache plotter, salter, and smoother.
        test.apacheSineSalter("ApacheSinePlotterResults.csv");
        //Tests the cosine apache plotter, salter, and smoother.
        test.apacheSineSmoother("ApacheSineSalterResults.csv", 8);
    }
}
