package Project2Part4StockBot;

import java.io.IOException;

public class TestStockBot {
    public static void main(String[] args) throws IOException {
        StockBot bot = new StockBot();
        bot.stockBotFileReader("src/Project2Part4StockBot/NTDOY.csv");
    }
}
