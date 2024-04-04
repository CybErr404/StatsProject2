package Code.CSVDataSalter;

import java.io.FileNotFoundException;

public class TestSalter {
    public static void main(String[] args) throws FileNotFoundException {
        Salter testFormula1 = new Salter();
        Salter testFormula2 = new Salter();
        testFormula1.salter1(1, 10);
        testFormula2.salter2(1, 10);
    }
}
