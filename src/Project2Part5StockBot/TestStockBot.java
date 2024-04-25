package Project2Part5StockBot;

import java.io.IOException;

public class TestStockBot {
    public static void main(String[] args) throws IOException {
        StockBot bot = new StockBot();
        bot.stockBotFileReader("NTDOY.csv");
    }
}
