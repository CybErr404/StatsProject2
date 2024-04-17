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

        //TESTING THE MEAN METHOD...
        System.out.println("MEAN, MEDIAN, AND MODE");
        //Initializes a double variable called storeMeanResults with the result of
        //calling the findMean method on the numbersArray variable.
        double storeMeanResults = test.findMean(numbersArray1);
        //Prints the mean of the array.
        System.out.println("The mean of the array is: " + storeMeanResults);

        //TESTING THE MODE METHOD...
        //Declares and initializes a variable called storeModeResults1 that stores
        //the result of taking the mode of an array with two repeating values of the same count.
        double storeModeResults1 = Double.parseDouble(test.findMode(numbersArray1));
        //Declares and initializes a variable called storeModeResults2 that stores
        //the result of taking the mode of an array with no mode.
        String storeModeResults2 = test.findMode(numbersArray2);
        //Declares and initializes a variable called storeModeResults3 that stores
        //the result of taking the mode of an array with one clear mode.
        double storeModeResults3 = Double.parseDouble(test.findMode(numbersArray3));
        //Prints the mode of an array with two repeating values of the same count.
        System.out.println("The mode of an array with two repeating values is: " + storeModeResults1);
        //Prints the mode of an array with no mode.
        System.out.println("The mode of an array with no mode is: " + storeModeResults2);
        //Prints the mode of an array that has one clear mode.
        System.out.println("The mode of an array with one mode is: " + storeModeResults3);

        //TESTING THE MEDIAN METHOD...
        //Declares and initializes a variable called storeMedianResults1 that stores
        //the result of taking the median of an array with an odd number of values.
        double storeMedianResults1 = test.findMedian(numbersArray1);
        //Declares and initializes a variable called storeMedianResults2 that stores
        //the result of taking the median of an array with an even number of values.
        double storeMedianResults2 = test.findMedian(numbersArray3);
        //Prints the median of the array with an odd number of values.
        System.out.println("The median of an odd array is: " + storeMedianResults1);
        //Prints the median of the array with an even number of values.
        System.out.println("The median of an even array is: " + storeMedianResults2 + "\n");

        //TESTING THE VARIANCE AND STANDARD DEVIATION...
        System.out.println("VARIANCE AND STANDARD DEVIATION");
        //The next two statements initialize and declare a variable that will store the variance
        //as well as print the result.
        double storeVarianceResults = test.findVariance(numbersArray1);
        System.out.println("The variance of " + Arrays.toString(numbersArray1) + " is: "
                + storeVarianceResults);

        //This statement declares and initializes a variable that stores the standard deviation.
        double storeStandardDeviationResults = test.findStandardDeviation(numbersArray1);
        //The following statement prints the result.
        System.out.println("The standard deviation of " + Arrays.toString(numbersArray1) +
                " is: " + storeStandardDeviationResults + "\n");

        //TESTING MN RULE...
        System.out.println("MN RULE");
        //This statement stores the result of the mn rule method into a double variable.
        double storeMNRuleResults = test.mxnRule(4, 6);
        //Prints the result of the mn rule.
        System.out.println("The results of an mn rule computation: " +
                storeMNRuleResults + "\n");

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

        //TESTING PERMUTATIONS AND COMBINATIONS...
        System.out.println("PERMUTATIONS AND COMBINATIONS");
        //Stores the result of the BigInteger permutation method into a BigInteger variable.
        BigInteger storePermutationsResults = test.permutations(5, 3);
        //Prints the result of the permutation.
        System.out.println("The result of a permutations test is: " + storePermutationsResults);

        //Stores the result of the long combination method into a double variable.
        double storeCombinationsResults1 = test.combinationsLong(6, 2);
        //Prints the result of the combination.
        System.out.println("The result of a combinations test is: " + storeCombinationsResults1);

        //Stores the result of the BigInteger combination method into a BigInteger variable.
        BigInteger storeCombinationsResults2 = test.combinations(6, 2);
        //Prints the result of the combination.
        System.out.println("The result of a combinations test is: " + storeCombinationsResults2 + "\n");

        //TESTING CONDITIONAL PROBABILITY...
        System.out.println("CONDITIONAL PROBABILITY");
        //This statement stores the result of P(A|B) into a double variable.
        double storeConditionalProbabilityResults1 = test.conditionalProbability1(.624, .334);
        //Prints the result of P(A|B).
        System.out.println("The results of doing P(A|B) type conditional probability are: "
                + storeConditionalProbabilityResults1);
        //This statement stores the result of P(B|A) into a double variable.
        double storeConditionalProbabilityResults2 = test.conditionalProbability2(.624, .334);
        //Prints the result of P(B|A).
        System.out.println("The results of doing P(B|A) type conditional probability are: "
                + storeConditionalProbabilityResults2 + "\n");

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

        //TESTING THE MULTIPLICATIVE LAW OF PROBABILITY...
        System.out.println("MULTIPLICATIVE LAW OF PROBABILITY");
        //The next three lines starting with "double" store each of the differing multiplicative law versions,
        //the first being the multiplication between event a and the conditional result of b given a,
        //the second being the multiplication between event a and the conditional result of a given b,
        //and the third being the multiplication between events a and b.
        double storeMultiplicativeResults1 = test.multiplicativeLawOfProbability1(0.24, 0.62);
        double storeMultiplicativeResults2 = test.multiplicativeLawOfProbability2(0.24, 0.38);
        double storeMultiplicativeResults3 = test.multiplicativeLawOfProbability3(0.6, 0.4);
        //The following three lines print the results of the multiplicative law methods.
        System.out.println("The results of doing the first multiplicative law are: " + storeMultiplicativeResults1);
        System.out.println("The results of doing the second multiplicative law are: " + storeMultiplicativeResults2);
        System.out.println("The results of doing the third multiplicative law are: " + storeMultiplicativeResults3
                + "\n");

        //TESTING THE ADDITIVE LAW OF PROBABILITY...
        System.out.println("ADDITIVE LAW OF PROBABILITY");
        //Stores the result of the first additive law property, which adds events a and b and
        //subtracts from the result the intersection of a and b.
        double storeAdditiveResults1 = test.additiveLawOfProbability1(0.7, 0.3, .48);
        //Stores the result of the second additive law property, which adds events a and b.
        double storeAdditiveResults2 = test.additiveLawOfProbability2(0.7, 0.3);
        //The next two statements print the results of both additive law properties,
        //the first returning the addition between a and b minus the intersection of a and b and the
        //second returning the addition between a and b.
        System.out.println("The result of doing the first additive law is: " + storeAdditiveResults1);
        System.out.println("The result of doing the second additive law is: " + storeAdditiveResults2 + "\n");

        //TESTING THE COMPLEMENT OR ODDS OF SOMETHING NOT HAPPENING...
        System.out.println("COMPLEMENT / ODDS OF SOMETHING NOT HAPPENING");
        //Stores the result of the method that takes aBar and subtracts it from 1 to find
        //the complement.
        double oddsOfSomethingNotHappening = test.oddsOfSomethingNotHappening(.55);
        //Prints the result of the complement.
        System.out.println("The result of calculating the complement of a value is: " + oddsOfSomethingNotHappening
                + "\n");

        //TESTING THEOREM OF TOTAL PROBABILITY...
        System.out.println("THEOREM OF TOTAL PROBABILITY");
        //Stores the value gotten from the theorem of total probability into a double.
        double theoremOfTotalProbResults = test.theoremOfTotalProbability(0.27, 0.75, 0.25, 0.62);
        System.out.println("The result for the theorem of total probability is: " + theoremOfTotalProbResults + "\n");

        //TESTING BAYES THEOREM...
        System.out.println("BAYES THEOREM");
        //Stores the value obtained from running the Bayes Theorem method.
        double bayesTheoremResults = test.bayesTheorem(0.1667, 0.5, 0.33);
        System.out.println("The result for Bayes is: " + bayesTheoremResults + "\n");

        //TESTING COMBINATORIAL PMF...
        System.out.println("COMBINATORIAL PMF");
        //Stores the combinatorial analysis results in a double variable.
        double combinatorialPMFResults = test.combinatorialPMF(12, 7, 5, 3, 4);
        System.out.println("The result for combinatorial analysis is: " + combinatorialPMFResults + "\n");

        //TESTING BINOMIAL DISTRIBUTION...
        System.out.println("BINOMIAL DISTRIBUTION");
        //The next four statements store the results of binomial distribution, the expected
        //value given what has been calculated for binomial distribution, the variance of the same
        //problem, and the standard deviation.
        double binomialDistributionResults = test.binomialDistributionPMF(0.8, 0.2, 10, 7);
        double binomialExpectedResults = test.expectedValueBDPMF(10, 0.8);
        double binomialVarianceResults = test.varianceValueBDPMF(10, 0.8, 0.2);
        double binomialStandardResults = test.standardDeviationValueBDPMF(10, 0.8, 0.2);
        //The next four statements print the binomial distribution, the expected value, the variance,
        //and the standard deviation.
        System.out.println("The result of calculating binomial distribution is: " + binomialDistributionResults);
        System.out.println("The expected value is: " + binomialExpectedResults);
        System.out.println("The variance value is: " + binomialVarianceResults);
        System.out.println("The standard deviation is: " + binomialStandardResults + "\n");

        //TESTING GEOMETRIC DISTRIBUTION...
        System.out.println("GEOMETRIC DISTRIBUTION");
        //The next four statements store the results of geometric distribution, the expected value,
        //the variance, and the standard deviation in double variables.
        double geometricDistributionResults = test.geometricDistributionPMF(0.45, 0.55, 3);
        double geometricExpectedResults = test.expectedValueGDPMF(0.45);
        double geometricVarianceResults = test.varianceValueBDPMF(0.45, 0.55, 3);
        double geometricStandardResults = test.standardDeviationValueGDPMF(0.45);
        //The following four statements print the results of geometric distribution, the expected value,
        //the variance, and the standard deviation.
        System.out.println("The result of calculating geometric distribution is: " + geometricDistributionResults);
        System.out.println("The expected value is: " + geometricExpectedResults);
        System.out.println("The variance value is: " + geometricVarianceResults);
        System.out.println("The standard deviation is: " + geometricStandardResults + "\n");

        //TESTING HYPERGEOMETRIC DISTRIBUTION...
        System.out.println("HYPERGEOMETRIC DISTRIBUTION");
        //These four statements store the hypergeometric distribution result, the expected value,
        //the variance, and the standard deviation into double variables.
        double hyperDistributionResults = test.hypergeometricDistributionPMF(6, 4, 20, 5);
        double hyperExpectedResults = test.expectedValueHGDPMF(6, 4, 20);
        double hyperVarianceResults = test.varianceValueHGDPMF(6, 4, 20);
        double hyperStandardResults = test.standardDeviationValueHGDPMF(6, 4, 20);
        //These four statements print the results of hypergeometric distribution, expected values,
        //the variance, and the standard deviation.
        System.out.println("The result of calculating hypergeometric distribution is: " + hyperDistributionResults);
        System.out.println("The expected value is: " + hyperExpectedResults);
        System.out.println("The variance value is: " + hyperVarianceResults);
        System.out.println("The standard deviation is: " + hyperStandardResults + "\n");

        //TESTING NEGATIVE BINOMIAL DISTRIBUTION...
        System.out.println("NEGATIVE BINOMIAL DISTRIBUTION");
        //The next four statements store the negative binomial distribution results, the expected value,
        //the variance results, and the standard deviation in double variables.
        double negativeDistributionResults = test.negativeBinomialDistributionPMF(0.2, 0.8, 5, 3);
        double negativeExpectedResults = test.expectedValueNBDPMF(0.2, 3);
        double negativeVarianceResults = test.varianceValueNBDPMF(0.2, 3);
        double negativeStandardResults = test.standardDeviationValueNBDPMF(0.2, 3);
        //These four statements print the results of negative binomial distribution results, the
        //expected value, the variance, and the standard deviation.
        System.out.println("The result of calculating negative binomial distribution is: "
                + negativeDistributionResults);
        System.out.println("The expected value is: " + negativeExpectedResults);
        System.out.println("The variance value is: " + negativeVarianceResults);
        System.out.println("The standard deviation is: " + negativeStandardResults + "\n");

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
                standardDeviationExponentialDistributionResults);
    }
}
