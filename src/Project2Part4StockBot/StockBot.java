package Project2Part4StockBot;

//Import statements for ArrayLists, Comparator, List, and Map.
//Also imports file reading and writing classes that will be important for the stock smoother.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Mia Watts, Garret Chmielewski, Heather Krencicki
 * This file contains a base version of a stock bot that calculates the RSI (Relative Strength Index)
 * and determines whether to buy or sell from the index and moving average.
 * Jake Cubernot helped me understand how the 70 30 rule works (and how to implement it).
 */
public class StockBot {
    //Helper comments from Jake Cubernot to explain the 70-30 rule in stocks.
    //Above 70 sell, below 30 buy.

    //Creates the stock array that will hold closing values to be smoothed.
    ArrayList<Double> stockValueArray = new ArrayList<>();

    ArrayList<Double> smoothedStockValueArray = new ArrayList<>();

    /**
     * This method is a trade evaluator which determines whether someone should sell, buy, or
     * hold, then calculates what their worth would be after selling, buying, or holding.
     * @param currentShares - the amount of shares owned at the time of program execution.
     * @param currentRSI - the RSI value calculated from the stock data.
     * @param budget - how much money you can spend on stocks.
     * @param currentPrice - current price of a Nintendo stock.
     * @return a String that gives details on the starting budget, new budget, whether to hold stocks,
     * and
     */
    public String tradeEvaluator(int currentShares, double currentRSI, double budget, double currentPrice) {
        //Holds the current budget after selling, buying, or holding.
        double currentBudget;
        //String flag that will be set to "Y" if stocks are held and "N" if they aren't.
        String hold = "";
        //How many stocks are being held at once.
        int held = 0;
        //How many stocks are being sold at once.
        int sold = 0;
        //How many stocks are being bought at once.
        int bought = 0;
        //Initially set to "N," this tells the user whether they've bought too much and have no money.
        String bankrupt = "N";
        //Checks to see if RSI is less than 30. (Buy)
        if(currentRSI < 30) {
            //Calculates the shares that can be bought with the given budget.
            bought = (int) (budget / currentPrice);
            //Calculates the total price of all stocks that can be bought.
            double stockTotal = currentPrice * bought;
            //Updates the budget to what it would be after buying.
            currentBudget = (budget - stockTotal);
            //Calculates the current share amount by adding the bought shares to the current shares.
            currentShares = (currentShares + bought);
            //Sets the holding flag to no since no stocks were held.
            hold = "N";
            //If the current budget is less than 0, the user is bankrupt.
            if(currentBudget < 0) {
                bankrupt = "Y";
            }
        }
        //Checks to see if the RSI is greater than 70. (Sell)
        else if(currentRSI > 70) {
            //Calculates the current budget by adding the total sell price to the budget.
            currentBudget = budget + (currentShares * currentPrice);
            //Sets the amount sold to the amount of current shares (sells everything).
            sold = currentShares;
            //Sets holding flag to no since nothing is held.
            hold = "N";
            //Sets current shares to 0 since all have been sold.
            currentShares = 0;
        }
        //This code runs if RSI is in between 30 and 70.
        else {
            //The current budget stays the same.
            currentBudget = budget;
            //All stocks are held, so hold is set to yes.
            hold = "Y";
            //All stocks are held, so the held amount is the total number of stocks.
            held = currentShares;
        }
        //Returns the String that updates the user on their trade.
        return "\nStarting budget: " + budget + "\nCurrent budget: " + currentBudget
                + "\nHold? (Y/N): " + hold + "\nAmount sold: " + sold + "\nAmount bought: "
                + bought + "\nAmount held: " + held + "\nCurrent shares: " + currentShares
                + "\nBankrupt? (Y/N): " + bankrupt;
    }

    /**
     * This method calculates the RSI value following the instruction file given in class.
     * @param Data - list of data files from the stock file.
     * @param quarter - N value as described on the instruction file given (days).
     * @return the RSI value for the given stock data.
     */
    public static double calculateRSI(List<StockReader> Data, int quarter) {
        //Checks to see if there is data present (enough data to work).
        if (Data.size() < quarter) {
            throw new IllegalArgumentException("Insufficient data for RSI calculation. Try again.");
        }

        double averageGain = 0, averageLoss = 0;

        //Initial average gain/loss calculation.
        for (int i = 1; i <= quarter; i++) {
            //Gets change value (calculation from site).
            double Change = Data.get(i).getClosePrice() - Data.get(i - 1).getClosePrice();
            if (Change > 0) {
                averageGain += Change;
            } else {
                averageLoss += Math.abs(Change);
            }
        }

        //Divides average gains and losses by the quarter value.
        averageGain /= quarter;
        averageLoss /= quarter;

        //Continues the calculation for the remaining days.
        for (int i = quarter; i < Data.size(); i++) {
            double Change = Data.get(i).getClosePrice() - Data.get(i - 1).getClosePrice();
            if (Change > 0) {
                averageGain = ((averageGain * (quarter - 1)) + Change) / quarter;
                averageLoss = (averageLoss * (quarter - 1)) / quarter;
            } else {
                averageLoss = ((averageLoss * (quarter - 1)) + Math.abs(Change)) / quarter;
                averageGain = (averageGain * (quarter - 1)) / quarter;
            }
        }
        //Stores the Relative Strength in a double variable (calculated based on the site).
        double rs = (averageLoss == 0) ? 100 : averageGain / averageLoss;
        //Returns the RSI.
        return 100 - (100 / (1 + rs));
    }

    /**
     * Tells the user whether to buy, sell, or hold based on the calculated RSI.
     * Jake Cubernot helped with this in that he assisted in helping me understand how
     * this part of the stock bot is supposed to work.
     * @param rsi - rsi value calculated in the RSI calculator.
     * @return whether the buy, sell, or hold.
     */
    public static String buySellHold(double rsi) {
        if(rsi > 70) {
            return "Sell Stock";
        }
        else if(rsi < 30) {
            return "Buy Stock";
        }
        else {
            return "Hold Stock";
        }
    }

    /**
     * This method is a data smoother for the stock closing prices. The method reads the
     * data from the CSV stock file, smooths it, then writes the new, smoothed values to a new CSV file.
     * @param file - file to be read.
     * @param window - the range of values to the left and right that will be averaged.
     * @throws IOException - in case the file cannot be found, read, or written to.
     */
    public void stockDataSmoother(String file, int window) throws IOException {
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
                stockValueArray.add(Double.valueOf(value));
            }
        }
        //Creates the PrintWriter object that will be used to write values to the CSV file.
        PrintWriter writer = new PrintWriter("StockSmootherResults.csv");
        //Main for loop that will iterate through the values read from the salt file.
        for(int i = 0; i < stockValueArray.size(); i++) {
            //The next three variables, currentValue, leftSum, and rightSum, store the current index
            //in the array with the salted values, the sum of the values to the left of the
            //current index, and the sum of the values to the right of the current index, respectively.
            double currentValue = stockValueArray.get(i);
            double leftSum = 0.0;
            double rightSum = 0.0;
            //Represents the current amount of values that have been considered which
            //will help with calculating the average (i.e., add two numbers and divide by 2 to get average.
            //Two would be the count).
            int count = 1;
            //Keeps track of the bound to ensure values not needing to be added aren't.
            int bound = 1;
            //Checks to see if the current index is not 0 or not the last element.
            if (i != 0 && i != stockValueArray.size() - 1) {
                //While loop to ensure the bound never surpasses the window.
                while(bound <= window) {
                    //Checks to see if the index minus the bound is greater than 0.
                    if(i - bound >= 0) {
                        //Adds one to count and calculates the current sum of the elements to the left.
                        count = count + 1;
                        leftSum = leftSum + stockValueArray.get(i - bound);
                    }
                    //Checks to see if the index added to the bound is less than the array size.
                    else if(i + bound < stockValueArray.size()) {
                        //Adds one to count and calculates the current sum of the elements to the right.
                        count = count + 1;
                        rightSum = rightSum + stockValueArray.get(i + bound);
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
                    if(i + bound < stockValueArray.size()) {
                        //Adds one to count and adds to the right sum.
                        count = count + 1;
                        rightSum = rightSum + stockValueArray.get(i + bound);
                    }
                    //Adds one to the bound.
                    bound++;
                }
            }
            //Final case to check if the index is the last element in the array.
            else if (i == stockValueArray.size() - 1) {
                //While loop to ensure the bound never surpasses the window.
                while(bound <= window) {
                    //Checks to see if the index minus the bound is greater than 0.
                    if (i - bound >= 0) {
                        //Adds one to count and adds to the left sum.
                        count = count + 1;
                        leftSum = leftSum + stockValueArray.get(i - bound);
                    }
                    //Adds one to the bound.
                    bound++;
                }
            }
            //Calculates the moving average, i.e., the new value.
            double smoothedValue = (leftSum + rightSum + currentValue) / count;
            //Adds the smoothed value to the array.
            smoothedStockValueArray.add(smoothedValue);
        }
        //Writes the new, smoothed values to the file.
        for (Double number : smoothedStockValueArray) {
            writer.println(number);
        }
        //Closes the file to avoid leaks.
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        //Holds the budget that determines how many stocks I can buy.
        double stockBudget = 1000.0;
        //Holds the current price of one Nintendo stock.
        double stockPrice = 12.25;
        //Saves file path.
        String csvFilePath = "src/Project2Part4StockBot/NTDOY.csv";
        //Creates a StockBot object that will be used when smoothing occurs.
        StockBot test = new StockBot();

        //Uses reader to get the stock data and store it.
        Map<String, StockReader> stockMap = StockEvaluator.readData(csvFilePath);
        List<StockReader> stockData = new ArrayList<>(stockMap.values());
        //Sorts the list by date.
        stockData.sort(Comparator.comparing(StockReader::getDate));

        //Attempts to calculate RSI for a given stock set.
        try {
            int periodLength = 14; // Typical RSI period length
            double rsi = calculateRSI(stockData, periodLength);
            System.out.println("RSI: " + rsi);
            System.out.println(buySellHold(rsi));
            System.out.println(test.tradeEvaluator(10, rsi, stockBudget, stockPrice));
        }
        //Catches errors if any occur.
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        //Calls the stock data smoother on the stock file's closing values with a window of 2.
        test.stockDataSmoother("src/Project2Part4StockBot/NTDOYClosingValues.csv", 2);
    }
}
