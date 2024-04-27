package Project2Part4StockBot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockEvaluator {
    public static Map<String, StockReader> readData(String file) {
        Map<String, StockReader > stockDataM = new HashMap<>();

        try (BufferedReader objReader = new BufferedReader(new FileReader(file))) {
            objReader.readLine();

            String line;
            while ((line = objReader.readLine()) != null) {
                String[] columns = line.split(",");

                String date = columns[0];
                double open = Double.parseDouble(columns[1]);
                double close = Double.parseDouble(columns[2]);

                StockReader  stockData = new StockReader(date, open, close);
                stockDataM.put(date, stockData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stockDataM;
    }

    public static double calculateMovingAverage(List<Double> cost, int time) {
        double sum = 0;
        for (int i = 0; i < time; i++) {
            sum += cost.get(i);
        }
        return sum / time;
    }

    public static void main(String[] args) {
        String File = "NTDOY.csv";
        Map<String, StockReader> stockDataM = readData(File);
        System.out.println(stockDataM.get("12/12/2022"));
        System.out.println();
    }
}
