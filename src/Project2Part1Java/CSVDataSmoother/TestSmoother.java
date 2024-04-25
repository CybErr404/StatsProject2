package Project2Part1Java.CSVDataSmoother;

import java.io.IOException;

public class TestSmoother {
    public static void main(String[] arg) throws IOException {
        Smoother test = new Smoother();
        test.polynomialDataSmoother("PolynomialSalterResults.csv");
        test.sineDataSmoother("SineSalterResults.csv");
        test.cosineDataSmoother("CosineSalterResults.csv");
    }
}
