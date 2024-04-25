package Project2Part1Java.CSVDataSalter;

//Import statement for FileNotFoundExceptions since the program deals with files.
import java.io.*;
//Import statement for the PrintWriter which writes information to the CSV file.
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
     * value. Reads information from the plotter result file.
     * @param file - file name that will be read.
     * @throws IOException - in case the file to be read cannot be found.
     */
    public void polynomialSalter(String file) throws IOException {
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
        PrintWriter writer = new PrintWriter("PolynomialSalterResults.csv");
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
     * value. Reads information from the plotter result file.
     * @param file - file name that will be read.
     * @throws IOException - in case the file to be read cannot be found.
     */
    public void sineSalter(String file) throws IOException {
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
        PrintWriter writer = new PrintWriter("SineSalterResults.csv");
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
     * Salts the values calculated from the cosine formula. If the index in the iteration
     * is even, the randomly generated salt value is added to the original value. If the index
     * of the iteration is odd, the randomly generated salt value is subtracted from the original
     * value. Reads information from the plotter result file.
     * @param file - file name that will be read.
     * @throws IOException - in case the file to be read cannot be found.
     */
    public void cosineWavesSalter(String file) throws IOException {
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
        PrintWriter writer = new PrintWriter("CosineSalterResults.csv");
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
}
