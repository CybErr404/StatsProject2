package Project2Part4StockBot;

//Import statements for reading and writing to files along with handling missing files.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Import statements for HashMaps, Lists, and Maps which are used to store data from the stock file.
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mia Watts, Garret Chmielewski, Heather Krencicki
 * This class evaluates a stock at a current date and returns the opening price and closing price.
 */
public class StockEvaluator {
    /**
     * Reader method that reads a stock file and stores data into open and close arrays
     * to represent the opening and closing price for a given day.
     * @param file - stock file that is read.
     * @return the stock data read from the file.
     */
    public static Map<String, StockReader> readData(String file) {
        //Map that stores stock data.
        Map<String, StockReader > stockDataMap = new HashMap<>();

        //Try statement to prevent issues with reading from a file.
        try (BufferedReader objReader = new BufferedReader(new FileReader(file))) {
            //Reads the next line in the file.
            objReader.readLine();
            //Stores the current line into a String variable.
            String line;
            //While loop that runs until the end of the file is reached.
            while ((line = objReader.readLine()) != null) {
                //Column array that consists of the values split by commas.
                String[] columns = line.split(",");
                //Stores the date in a String variable.
                String date = columns[0];
                //Stores the open and closing prices in double variables.
                double open = Double.parseDouble(columns[1]);
                double close = Double.parseDouble(columns[2]);

                //Creates a variable that stores the retrieved date, open, and close.
                StockReader stockData = new StockReader(date, open, close);
                //Places the date and stock data into the stock map.
                stockDataMap.put(date, stockData);
            }
            //Catches errors.
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Returns the data map.
        return stockDataMap;
    }

    /**
     * Calculates the moving average using a method in the website.
     * @param cost - current cost of the stock.
     * @param total - range of total values.
     * @return the moving average for a specific cost.
     */
    public static double calculateMovingAverage(List<Double> cost, int total) {
        //Stores the sum.
        double sum = 0;
        //Iterates through the total values.
        for (int i = 0; i < total; i++) {
            //Calculates the sum by adding values to the original variable.
            sum += cost.get(i);
        }
        //Returns the average.
        return sum / total;
    }

    //Tester method that tests to see if the proper data is returned.
    public static void main(String[] args) {
        //Stores the file directory to a String file variable.
        String file = "src/Project2Part4StockBot/NTDOY.csv";
        //Reads data from the file and stores it into a map.
        Map<String, StockReader> stockDataMap = readData(file);
        //Prints the values found for the date specified.
        System.out.println(stockDataMap.get("4/17/2023"));
    }
}
