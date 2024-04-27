package Project2Part4StockBot;

/**
 * @author Mia Watts, Garret Chmielewski, Heather Krencicki
 * This is a Stock Reader class that was built/edited by me, Garret, and Heather.
 * This class contains the getter and setter methods for the dates, opening, and closing prices
 * along with a constructor that initializes dates, open prices, and closing prices.
 */
public class StockReader  {
    //Stores a String date, double open price, and double closing price.
    private String date;
    private double open;
    private double close;

    /**
     *
     * @param date - current date of the stock prices.
     * @param open - opening price at the beginning of the day.
     * @param close - closing prices at the end of the day.
     */
    public StockReader (String date, double open, double close) {
        this.date = date;
        this.open = open;
        this.close = close;
    }

    /**
     * Getter method that gets the date.
     * @return the date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Getter method that gets the open price.
     * @return the opening price for the day.
     */
    public double getOpenPrice() {
        return open;
    }

    /**
     * Getter method that gets the close price.
     * @return the closing price for the day.
     */
    public double getClosePrice() {
        return close;
    }

    /**
     * This method sets the specified data to a new date.
     * @param date - new date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This methods sets the open price to something else.
     * @param openPrice - new open price to add.
     */
    public void setOpenPrice(double openPrice) {
        this.open = openPrice;
    }

    /**
     * This method sets the adjacent closing price to something else.
     * @param closePrice - new close price to add.
     */
    public void setAdjClosePrice(double closePrice) {
        this.close = closePrice;
    }

    /**
     * This method overrides the original toString method to create a String result that
     * closely fits the given information.
     * @return a String that contains stock data in a formatted manner.
     */
    @Override
    public String toString() {
        return "StockData{" +
                "date='" + date + '\'' +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}