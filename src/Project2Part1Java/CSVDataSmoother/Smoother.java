package Project2Part1Java.CSVDataSmoother;

//Import statements for reading/writing files and using ArrayLists.
import java.io.*;
import java.util.ArrayList;

/**
 * @author Mia Watts
 * This is a Java data smoother. Each method reads a CSV file with salted data, smooths the data,
 * and writes the results to a new CSV file. Smoothing, in this case, is a moving average
 * in which averages are calculated by adding numbers to the left and right of a certain index
 * then averaging them and updating the result to the smoothed number. The program attempts to
 * return the salted data to a version close to the original.
 */
public class Smoother {
    //Creates an ArrayList that will hold the salted values read from the CSV file.
    ArrayList<Double> saltArray = new ArrayList<>();
    //Creates an ArrayList that will hold the smoothed values that will be written to a new file.
    ArrayList<Double> smoothedArray = new ArrayList<>();

    /**
     * This method is a data smoother for the polynomial equation results after they have
     * been salted. The method reads the data from the CSV salt file, smooths it, then writes
     * the new, smoothed values to a new CSV file.
     * @param file - file to be read.
     * @param window - the range of values to the left and right that will be averaged.
     * @throws IOException - in case the file cannot be found, read, or written to.
     */
    public void polynomialDataSmoother(String file, int window) throws IOException {
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
            //Calculates the moving average, i.e., the new value.
            double smoothedValue = (leftSum + rightSum + currentValue) / count;
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

    /**
     * This method is a data smoother for the sine equation results after they have
     * been salted. The method reads the data from the CSV salt file, smooths it, then writes
     * the new, smoothed values to a new CSV file.
     * @param file - file to be read.
     * @param window - the range of values to the left and right that will be averaged.
     * @throws IOException - in case the file cannot be found, read, or written to.
     */
    public void sineDataSmoother(String file, int window) throws IOException {
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
            //Calculates the moving average, i.e., the new value.
            double smoothedValue = (leftSum + rightSum + currentValue) / count;
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

    /**
     * This method is a data smoother for the cosine equation results after they have
     * been salted. The method reads the data from the CSV salt file, smooths it, then writes
     * the new, smoothed values to a new CSV file.
     * @param file - file to be read.
     * @param window - the range of values to the left and right that will be averaged.
     * @throws IOException - in case the file cannot be found, read, or written to.
     */
    public void cosineDataSmoother(String file, int window) throws IOException {
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
            //Calculates the moving average, i.e., the new value.
            double smoothedValue = (leftSum + rightSum + currentValue) / count;
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
}
