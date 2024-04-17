package Project2Part1Java.CSVDataSalter;

//Imports FileNotFoundExceptions to avoid issues with writing to files.
import java.io.FileNotFoundException;

/**
 * @author Mia Watts
 * This is the tester class for the Java Data Salter. Objects are made and are then used to test
 * the salting methods, running each formula from its start point, -100, to its end point, 100.
 */
public class TestSalter {
    public static void main(String[] args) throws FileNotFoundException {
        //Creates a salter object for the polynomial formula.
        Salter polynomialFormulaSalt = new Salter();
        //Creates a salter object for the sine formula.
        Salter sineFormulaSalt = new Salter();
        //Creates a salter object for the cosine formula.
        Salter cosineFormulaSalt = new Salter();
        //Writes values calculated from salting the polynomial results from -100 to 100.
        polynomialFormulaSalt.polynomialSalter(-100, 100);
        //Writes values calculated from salting the sine results from -100 to 100.
        sineFormulaSalt.sineSalter(-100, 100);
        //Writes values calculated from salting the cosine results from -100 to 100.
        cosineFormulaSalt.cosineWavesSalter(-100, 100);
    }
}
