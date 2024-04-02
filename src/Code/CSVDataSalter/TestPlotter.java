package Code.CSVDataSalter;

import java.io.FileNotFoundException;

public class TestPlotter {
    public static void main(String[] args) throws FileNotFoundException {
        Plotter test = new Plotter();
        test.plotter(1, 10);
    }
}
