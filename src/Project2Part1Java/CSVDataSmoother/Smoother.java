package Project2Part1Java.CSVDataSmoother;

import java.io.*;
import java.util.ArrayList;

public class Smoother {
    ArrayList<Double> saltArray = new ArrayList<>();
    ArrayList<Double> smoothedArray = new ArrayList<>();
    public void polynomialDataSmoother(String file) throws IOException {
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
        PrintWriter writer = new PrintWriter("PolynomialSmootherResults.csv");
    }

    public void sineDataSmoother(String file) throws IOException {
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
        PrintWriter writer = new PrintWriter("SineSmootherResults.csv");
    }

    public void cosineDataSmoother(String file) throws IOException {
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
        PrintWriter writer = new PrintWriter("CosineSmootherResults.csv");
    }
}
