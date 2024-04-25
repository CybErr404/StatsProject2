package Project2Part1Java.CSVDataSmoother;

import java.io.IOException;

public class TestSmoother {
    public static void main(String[] arg) throws IOException {
        Smoother test = new Smoother();
        test.polynomialDataSmoother("PolynomialSalterResults.csv", 4);
        test.sineDataSmoother("SineSalterResults.csv", 4);
        test.cosineDataSmoother("CosineSalterResults.csv", 4);
    }
}
