package Project2Part1Java.CSVDataSmoother;

import java.io.IOException;

public class TestSmoother {
    public static void main(String[] arg) throws IOException {
        Smoother test = new Smoother();
        test.smooth("SinePlotterResults", 5000, 5000);
    }
}
