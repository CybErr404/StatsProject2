package Project2Part5StockBot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

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
}
