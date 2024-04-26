package StatsLibrary;

//Used for permutations and combinations along with some of the probability mass functions.
import java.math.BigInteger;
//Used for the arrays that contain values to be tested in some cases.
import java.util.Arrays;

/**
 * @author Mia Watts
 */

//This class's purpose is to test all formulas and methods within the StatsLibrary class.
//See the StatsLibrary class for a programmed collection of all statistics formulas
//that have been covered in the course up to 3/7/2024.
public class TestStatsLibrary {
    public static void main(String[] args) {
        //Creates a new object named test of type StatsLibrary. Test will
        //be used to try each method written in the StatsLibrary class.
        StatsLibrary test = new StatsLibrary();
        //Creates an array called numbersArray that has two repeating numbers.
        //numbersArray is used to test the mean, median, and mode.
        int[] numbersArray1 = {1, 2, 3, 4, 4, 5, 6, 7, 7};
        int[] numbersArray2 = {1, 2, 3, 4, 5, 6, 7};
        int[] numbersArray3 = {2, 3, 4, 5, 5, 7, 8, 9};

        //TESTING FACTORIALS...
        System.out.println("LONG AND BIGINTEGER FACTORIAL METHODS");
        //Stores the result of the long factorial method into a double variable.
        double storeLongFactorialResults = test.longFactorial(5);
        //Prints the result of calculating factorials with a long.
        System.out.println("The results of calculating factorials with a long is: " +
                storeLongFactorialResults);
        //Stores the result of the BigInteger factorial method into a double variable.
        BigInteger storeBigIntegerFactorialResults = test.bigIntegerFactorial(4);
        //Prints the result of calculating factorials with the BigInteger class.
        System.out.println("The results of calculating factorials with BigInteger is: " +
                storeBigIntegerFactorialResults + "\n");

        //Stores the result of the long combination method into a double variable.
        double storeCombinationsResults1 = test.combinationsLong(6, 2);
        //Prints the result of the combination.
        System.out.println("The result of a combinations test is: " + storeCombinationsResults1);

        //Stores the result of the BigInteger combination method into a BigInteger variable.
        BigInteger storeCombinationsResults2 = test.combinations(6, 2);
        //Prints the result of the combination.
        System.out.println("The result of a combinations test is: " + storeCombinationsResults2 + "\n");

        //TESTING INDEPENDENCE...
        System.out.println("INDEPENDENCE OR DEPENDENCE");
        //Stores the result of the first run using a book problem into a boolean variable to test dependency.
        boolean storeIndependenceResults1 = test.independenceChecker(0, 0, 0.5, 0.5, 0);
        //Prints the result of whether the events are independent (true) or dependent (false).
        System.out.println("The results of checking independence on values is: " + storeIndependenceResults1);
        //Stores the result of the second run using a book problem into a boolean variable to test dependency.
        boolean storeIndependenceResults2 = test.independenceChecker(0.5, 0, 0.5, .33, 2);
        //Prints the result of whether the events are independent (true) or dependent (false).
        System.out.println("The results of checking independence on values is: " + storeIndependenceResults2 + "\n");

        //TESTING POISSON DISTRIBUTION...
        System.out.println("POISSON DISTRIBUTION");
        //The next four statements save the Poisson Distribution results to double variables.
        //The first statement stores the actual probability distribution, the second stores the
        //expected value, the third stores the variance, and the fourth stores the standard deviation.
        double poissonDistributionResults = test.poissonDistribution(2, 4);
        double poissonExpectedResults = test.expectedValuePoissonDistribution(2);
        double poissonVarianceResults = test.varianceValuePoissonDistribution(2);
        double poissonStandardDeviationResults = test.standardDeviationValuePoissonDistribution(2);
        //The next four statements print the results of performing Poisson distribution on a mean of 2 and
        //a Y value of 4. The print statements also return the results of calculating the expected
        //value, the variance, and the standard deviation.
        System.out.println("The result of calculating Poisson distribution with a mean of 2 and " +
                "a Y value of 4 is: " + poissonDistributionResults);
        System.out.println("The result of calculating the expected value for Poisson is: " + poissonExpectedResults);
        System.out.println("The result of calculating the variance for Poisson is: " + poissonVarianceResults);
        System.out.println("The result of calculating the standard deviation for Poisson is: "
                + poissonStandardDeviationResults + "\n");

        //TESTING TCHEBYSHEFF'S THEOREM...
        System.out.println("TCHEBYSHEFF'S, OR CHEBYSHEV'S, THEOREM");
        //These statements store the results of performing a Tchebysheff's calculation along with a k value calculation.
        double tchebysheffsResults = test.tchebysheffsTheorem(2);
        double tchebysheffsKValueResults = test.k(28, 14);
        //These two statements print the results of calculating a k value and performing a Tchebysheff's calculation.
        System.out.println("The result of calculating Tchebysheff's theorem is: " + tchebysheffsResults);
        System.out.println("The result of calculating a Tchebysheff's k value is: " + tchebysheffsKValueResults + "\n");

        //TESTING THE UNIFORM PROBABILITY DISTRIBUTION FORMULA...
        System.out.println("UNIFORM PROBABILITY DISTRIBUTION");
        //This statement stores the result calculated by using the Uniform Probability Distribution formula.
        double uniformResults = test.uniformDistribution(3, 10);
        //This statement prints the results of the Uniform Probability Distribution formula.
        System.out.println("The result of calculating the Uniform Probability Distribution with a = 3 and b = 10 is: "
                + uniformResults);
        //These statements store the results of calculating the expected value, variance, and standard deviation.
        double expectedValueUniformResults = test.expectedValueUniformDistribution(10, 5);
        double varianceValueUniformResults = test.varianceValueUniformDistribution(10, 5);
        double standardDeviationUniformResults = test.standardDeviationUniformDistribution(10, 5);
        //These statements print the results of the expected value, variance, and standard deviation.
        System.out.println("The result of calculating the expected value with thetas 10 and 5 is: "
                + expectedValueUniformResults);
        System.out.println("The result of calculating the variance with thetas 10 and 5 is: "
                + varianceValueUniformResults);
        System.out.println("The result of calculating the standard deviation with thetas 10 and 5 is: "
                + standardDeviationUniformResults + "\n");

        //TESTING GAMMA DISTRIBUTION...
        System.out.println("GAMMA DISTRIBUTION");
        //These statements store the results of calculating the expected value, variance, and standard
        //deviation of Gamma Distribution.
        double expectedValueGammaResults = test.expectedValueGammaDistribution(2, 1.6);
        double varianceValueGammaResults = test.varianceValueGammaDistribution(2, 1.6);
        double standardDeviationGammaResults = test.standardDeviationGammaDistribution(2, 1.6);
        //These statements print the results of the expected value, variance, and standard deviation.
        System.out.println("The result of calculating the expected value for an alpha of 2 and beta of 1.6 is: "
                + expectedValueGammaResults);
        System.out.println("The result of calculating the variance value for an alpha of 2 and beta of 1.6 is: "
                + varianceValueGammaResults);
        System.out.println("The result of calculating the standard deviation for an alpha of 2 and beta of 1.6 is: "
                + standardDeviationGammaResults + "\n");

        //TESTING EXPONENTIAL DISTRIBUTION...
        System.out.println("EXPONENTIAL DISTRIBUTION");
        //These statements store the results of calculating an exponential distribution, then the expected value,
        //variance, and standard deviation for the exponential distribution.
        //This statement says that since alpha isn't 1, there's no exponential distribution.
        String exponentialDistributionResults1 = test.exponentialDistribution(2, 44, 31);
        //This statement says that since alpha is 1, there is exponential distribution.
        String exponentialDistributionResults2 = test.exponentialDistribution(1, 44, 31);
        double expectedExponentialDistributionResults = test.expectedValueED(44);
        double varianceExponentialDistributionResults = test.varianceValueED(44);
        double standardDeviationExponentialDistributionResults = test.standardDeviationED(44);
        //These statements print the results associated with exponential distribution.
        System.out.println(exponentialDistributionResults1);
        System.out.println(exponentialDistributionResults2);
        System.out.println("The result of calculating the expected value is: " +
                expectedExponentialDistributionResults);
        System.out.println("The result of calculating the variance is: " + varianceExponentialDistributionResults);
        System.out.println("The result of calculating the standard deviation is: " +
                standardDeviationExponentialDistributionResults + "\n");

        //TESTING CONDITIONAL DENSITY...
        System.out.println("CONDITIONAL DENSITY");
        //These statements store the results of performing x and y conditional density.
        double conditionalDensityResults1 = test.conditionalDensity1(10, 3);
        double conditionalDensityResults2 = test.conditionalDensity2(10 , 5);
        //These statements print the results of calculating conditional density for x and y.
        System.out.println("The result of calculating conditional density for y is: " + conditionalDensityResults1);
        System.out.println("The result of calculating conditional density for x is: " + conditionalDensityResults2
                + "\n");

        //TESTING INDEPENDENCY...
        System.out.println("INDEPENDENCY");
        //These statements store the results of determining independency for density, probability,
        //distribution, and separate functions.
        boolean independentResults1 = test.independency1((1.0/36.0), (1.0/6.0), (1.0/6.0));
        boolean independentResults2 = test.independency2((1.0/36.0), (1.0/6.0), (1.0/4.0));
        boolean independentResults3 = test.independency3((50), (5), (10));
        boolean independentResults4 = test.independency4((39), (564), (23));
        //These statements print whether the specific item is independent or not.
        System.out.println("Are the x and y distributions independent? " + independentResults1);
        System.out.println("Are the x and y probabilities independent? " + independentResults2);
        System.out.println("Are the x and y densities independent? " + independentResults3);
        System.out.println("Are the x and y functions independent? " + independentResults4);
    }
}
