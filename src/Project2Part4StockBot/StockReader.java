package Project2Part4StockBot;

public class StockReader  {
    private String date;
    private double open;
    private double close;

    public StockReader (String date, double open, double close) {
        this.date = date;
        this.open = open;
        this.close = close;
    }

    public String getDate() {
        return date;
    }

    public double getOpenPrice() {
        return open;
    }

    public double getClosePrice() {
        return close;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setOpenPrice(double openPrice) {
        this.open = openPrice;
    }

    public void setAdjClosePrice(double closePrice) {
        this.close = closePrice;
    }

    @Override
    public String toString() {
        return "StockData{" +
                "date='" + date + '\'' +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}