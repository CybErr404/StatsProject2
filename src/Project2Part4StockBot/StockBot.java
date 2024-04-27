package Project2Part4StockBot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
public class StockBot {
    public void stockBotFileReader(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        Stack<String> stockData = new Stack<>();
        while((currentLine = reader.readLine()) != null) {
            String[] values = currentLine.split(",");
            for (String value : values) {
                stockData.push(value);
            }
        }
        System.out.println(stockData);
    }

    public static double calculateRSI(List<StockReader> Data, int quarter) {
        // Ensure enough data is available
        if (Data.size() < quarter) {
            throw new IllegalArgumentException("Insufficient data for RSI calculation");
        }

        double averageGain = 0, averageLoss = 0;

        // Initial average gain/loss calculation
        for (int i = 1; i <= quarter; i++) {
            double Change = Data.get(i).getClosePrice() - Data.get(i - 1).getClosePrice();
            if (Change > 0) {
                averageGain += Change;
            } else {
                averageLoss += Math.abs(Change);
            }
        }

        averageGain /= quarter;
        averageLoss /= quarter;

        // Continued calculation for the remaining days
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

        double rs = (averageLoss == 0) ? 100 : averageGain / averageLoss;
        return 100 - (100 / (1 + rs));
    }

    public static void main(String[] args) {
        String csvFilePath = "NTDOY.csv";

        // Use CSVReader to get the stock data
        Map<String, StockReader> stockMap = StockEvaluator.readData(csvFilePath);
        List<StockReader > stockData = new ArrayList<>(stockMap.values());

        // Sort the list by date
        stockData.sort(Comparator.comparing(StockReader::getDate));

        try {
            int periodLength = 14; // Typical RSI period length
            double rsi = calculateRSI(stockData, periodLength);
            System.out.println("RSI: " + rsi);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
