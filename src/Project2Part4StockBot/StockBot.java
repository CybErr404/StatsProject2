package Project2Part4StockBot;

//Import statements for ArrayLists, Comparator, List, and Map.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author Mia Watts, Garret Chmielewski, Heather Krencicki
 * This file contains a base version of a stock bot that calculates the RSI (Relative Strength Index)
 * and determines whether to buy or sell from the index and moving average.
 */
public class StockBot {
    //Helper comments from Jake Cubernot to explain the 70-30 rule in stocks.
    //Above 70 sell
    //below 30 buy

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

    public static void main(String[] args) {
        //Saves file path.
        String csvFilePath = "src/Project2Part4StockBot/NTDOY.csv";

        //Uses reader to get the stock data and store it.
        Map<String, StockReader> stockMap = StockEvaluator.readData(csvFilePath);
        List<StockReader > stockData = new ArrayList<>(stockMap.values());

        //Sorts the list by date.
        stockData.sort(Comparator.comparing(StockReader::getDate));

        //Attempts to calculate RSI for a given stock set.
        try {
            int periodLength = 14; // Typical RSI period length
            double rsi = calculateRSI(stockData, periodLength);
            System.out.println("RSI: " + rsi);
            System.out.println(buySellHold(rsi));
        }
        //Catches errors if any occur.
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
