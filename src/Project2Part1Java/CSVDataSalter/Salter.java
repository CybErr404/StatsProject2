package Project2Part1Java.CSVDataSalter;

//Import statement for FileNotFoundExceptions since the program deals with files.
import java.io.FileNotFoundException;
//Import statement for the PrintWriter which writes information to the CSV file.
import java.io.PrintWriter;
//Import statement for the ArrayList class so values can be stored for future reference.
import java.util.ArrayList;
//Import statement for the Random class so random salt values can be generated.
import java.util.Random;

/**
 * @author Mia Watts
 * This class is a Java Data Salter, which takes information calculated from the three
 * formulas and alters each value to make them unrecognizable. After doing so, the program
 * adds the values into a CSV file for graphing.
 * For specifics, the salt values are added to the regular value if the index is even,
 * and the salt values are subtracted from the regular value if the index is odd.
 */
public class Salter {
    //Stores the results of calculating the vanilla (original, generic, etc.) values.
    ArrayList<Double> resultArray = new ArrayList<>();
    //Stores the results of the salting.
    ArrayList<Double> saltArray = new ArrayList<>();

    /**
     * Salts the values calculated from the polynomial formula. If the index in the iteration
     * is even, the randomly generated salt value is added to the original value. If the index
     * of the iteration is odd, the randomly generated salt value is subtracted from the original
     * value.
     * @param start - starting increment value.
     * @param end - ending increment value.
     * @throws FileNotFoundException - a file is written to, so the exception was added just in case.
     */
    public void polynomialSalter(double start, double end) throws FileNotFoundException {
        //Creates the PrintWriter object that will be used to write values to the CSV file.
        PrintWriter writer = new PrintWriter("PolynomialSalterResults.csv");
        //Increments from the start to the end, calculating the value at each increment.
        for(int i = (int) start; i <= end; i++) {
            //Stores the result of the polynomial calculation.
            double result = polynomialFormula(i);
            //Adds the value into the result array.
            resultArray.add(result);
        }
        //Salts the values by randomly generating a number.
        for(int i = 0; i < resultArray.size(); i++) {
            //Creates a random number object.
            Random randomNumber = new Random();
            //Generates a random number with which to salt the current value.
            int randomSaltValue = randomNumber.nextInt(200);
            //If the index is even, add the randomly generated salt value to the original value.
            if(i % 2 == 0) {
                saltArray.add(resultArray.get(i) + randomSaltValue);
            }
            //If the index is odd, subtract the randomly generated salt value from the original value.
            else {
                saltArray.add(resultArray.get(i) - randomSaltValue);
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
     * Salts the values calculated from the sine formula. If the index in the iteration
     * is even, the randomly generated salt value is added to the original value. If the index
     * of the iteration is odd, the randomly generated salt value is subtracted from the original
     * value.
     * @param start - starting increment value.
     * @param end - ending increment value.
     * @throws FileNotFoundException - a file is written to, so the exception was added just in case.
     */
    public void sineSalter(double start, double end) throws FileNotFoundException {
        //Creates a PrintWriter object used to write values to the specified CSV file.
        PrintWriter writer = new PrintWriter("SineSalterResults.csv");
        //Increments through the start and end values to store all results in an array.
        for(int i = (int) start; i <= end; i++) {
            //Stores the result in a variable.
            double result = sineFormula(i);
            //Adds results to a result array.
            resultArray.add(result);
        }
        //Salts the data.
        for(int i = 0; i < resultArray.size(); i++) {
            //Creates a random number object.
            Random randomNumber = new Random();
            //Generates a random number to be used as the salt value.
            int randomSaltValue = randomNumber.nextInt(200);
            //If the index is even, add the random salt value to the original value.
            if(i % 2 == 0) {
                saltArray.add(resultArray.get(i) + randomSaltValue);
            }
            //If the index is odd, subtract the random salt value from the original value.
            else {
                saltArray.add(resultArray.get(i) - randomSaltValue);
            }
        }
        //Writes the values to a CSV file.
        for (Double number : saltArray) {
            writer.println(number);
        }
        //Closes the file to avoid leaks.
        writer.close();
    }

    /**
     * Salts the values calculated from the cosine formula. If the index in the iteration
     * is even, the randomly generated salt value is added to the original value. If the index
     * of the iteration is odd, the randomly generated salt value is subtracted from the original
     * value.
     * @param start - starting increment value.
     * @param end - ending increment value.
     * @throws FileNotFoundException - a file is written to, so the exception was added just in case.
     */
    public void cosineWavesSalter(double start, double end) throws FileNotFoundException {
        //Creates a PrintWriter object used to write values to the specified CSV file.
        PrintWriter writer = new PrintWriter("CosineSalterResults.csv");
        //Increments through the start and end values to store all results in an array.
        for(int i = (int) start; i <= end; i++) {
            //Stores the result in a variable.
            double result = cosineWavesFormula(i);
            //Adds results to a result array.
            resultArray.add(result);
        }
        //Salts the data.
        for(int i = 0; i < resultArray.size(); i++) {
            //Creates a random number object.
            Random randomNumber = new Random();
            //Generates a random number to be used as the salt value.
            int randomSaltValue = randomNumber.nextInt(200);
            //If the index is even, add the random salt value to the original value.
            if(i % 2 == 0) {
                saltArray.add(resultArray.get(i) + randomSaltValue);
            }
            //If the index is odd, subtract the random salt value from the original value.
            else {
                saltArray.add(resultArray.get(i) - randomSaltValue);
            }
        }
        //Writes the values to a CSV file.
        for (Double number : saltArray) {
            writer.println(number);
        }
        //Closes the file to avoid leaks.
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
