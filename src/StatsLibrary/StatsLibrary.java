package Code.StatsLibrary;

//Import statement for the arrays and BigInteger class.
import java.math.BigInteger;
import java.util.Arrays;
//Import statement for the TreeMaps used within the mode method.
import java.util.TreeMap;

//The StatsLibrary class is a comprehensive collection of formulas that have been taught
//in Probability and Applied Statistics. Central tendencies, Probability Mass Functions (PMFs),
//and more are included in this class.

//A full list of everything that has been programmed into the StatsLibrary would include the following:
//Mean, median, mode, classic variance, classic standard deviation, the mn rule, permutations,
//combinations, a factorial method using both Longs and BigInteger, conditional probability formulas
//(both P(A|B) and P(B|A)), an independent and dependent checker, the Multiplicative Law of
//Probability, the General Addition Rule Axiom, the odds of something not occurring,
//the Theorem of Total Probability, Bayes Theorem, the combinatorial PMF, the Binomial Distribution PMF,
//the expected value, variance, and standard deviation for binomial distribution, the Geometric
//Distribution PMF, the expected value, variance, and standard deviation for geometric distribution,
//the Hypergeometric Distribution PMF, the expected value, variance, and standard deviation for
//hypergeometric distribution, the Negative Binomial Distribution PMF, and the expected value,
//variance, and standard deviation for negative binomial distribution.

/**
 * @author Mia Watts
 */
public class StatsLibrary {

    /**
     * This methods finds the mean.
     * @param userInput - array that takes integer values
     * @return the mean result, or the sum divided by the length of the array
     */
    public double findMean(int[] userInput) {

        //Find the sum.
        double sum = 0;
        for (int j : userInput) {
            sum = j + sum; //or +=, either works! but I just used regular adding
        }

        //returns the sum divided by the array length
        return sum / userInput.length;
    }

    /**
     * This method finds the median.
     * @param userArray - array parameter that has integer values
     * @return median (middle value if odd array length and result of dividing two middle numbers
     * after adding them together if even)
     */
    //Median = the middle of the list of numbers (exact middle if odd, average of left and right middle if even).
    public double findMedian(int[] userArray) {
        //Sort the array from smallest to biggest.
        Arrays.sort(userArray);

        //Check whether the array is even (if so, we need to take the average of the middle two numbers).
        //If the array is odd, then we can simply return the middle number.
        if(userArray.length % 2 == 0) {
            int halfLength = userArray.length / 2; //Splits the array length in half and stores the result.
            double middle1 = userArray[halfLength]; //Assigns the first middle number to the division result.
            double middle2 = userArray[halfLength - 1]; //Assigns the second middle number to the one next to the middle.
            return (middle1 + middle2) / 2; //Returning the median.
        }
        else {
            return userArray[(userArray.length / 2)]; //Returns the median.
        }
    }

    /**
     * This method finds the mode.
     *
     * @param userArray - array of integer values
     * @return the mode
     */
    //Mode = finding the most common number in a list.
    public String findMode(int[] userArray) {
        TreeMap<Integer, Integer> modeTreeMap = new TreeMap<>();
        String mode = "none";
        int maximumCount = 0;
        for (int j : userArray) {
            if (!(modeTreeMap.get(j) == null)) {
                int temporary = modeTreeMap.get(j);
                temporary = temporary + 1;
                if (temporary > maximumCount) {
                    maximumCount = temporary;
                    mode = String.valueOf(j);
                }
            } else {
                modeTreeMap.put(j, 1);
            }
        }
        return mode;
    }

    /**
     * This finds the variance.
     * @param array - integer array parameter
     * @return - returns the variance of the values in the array
     */
    public double findVariance(int[] array) {
        double n = array.length; //n represents the size of the array.
        double side1 = (1/(n - 1)); //side1 represents the first side to be multiplied, i.e., 1/(n-1).
        double side2 = 0.0; //side2 represents the summation in the formula.
        double sum = 0.0; //sum represents the sum of all array values.
        double mean = 0.0; //mean is the sum of all array elements divided by how many elements there are. (average but not).
        double variance = 0.0; //variance is the variable that is returned that will contain the variance value.

        //adds all numbers in the array
        for (int k : array) {
            sum = sum + k;
        }

        mean = findMean(array); //assigns mean to the findMean method result

        //computes the sum of the squares
        for (int j : array) {
            side2 = side2 + Math.pow(j - mean, 2);
        }

        //computes the variance and returns it
        variance  = (side1 * side2);
        return variance;
    }

    /**
     * This finds the standard deviation.
     * @param array - integer array
     * @return - returns the standard deviation
     */
    public double findStandardDeviation(int[] array) {
        double standardDeviation = 0.0; //defines standard deviation double variable.
        standardDeviation = Math.sqrt(findVariance(array)); //Finds standard deviation by calculating square root of variance
        return standardDeviation; //returns the standard deviation
    }

    /**
     * This finds the result of the mxn rule.
     * @param m - first value
     * @param n - second value
     * @return - double value of m * n
     */
    public double mxnRule(double m, double n) {
        return m * n;
    }

    /**
     * This method finds the factorial result using longs.
     * @param number - value to be calculated in factorial method.
     * @return - long value of the factorial result.
     */
    public long longFactorial(double number) {
        long result = 1; //stored result as 1, so it doesn't multiply the factorial by 0.
        //calculate factorial by using a loop that goes from the number to 1, multiplying the result by
        //the result * the current value of the loop, i.
        for(int i = (int) number; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    /**
     * This finds the result of a factorial using BigInteger.
     * @param number - value to be used as the factorial number
     * @return - BigInteger value that holds the result of the factorial.
     */
    public BigInteger bigIntegerFactorial(int number) {
        BigInteger result = BigInteger.ONE; //store BigInteger value as 1.
        //calculates factorial by multiplying each number by one less (i.e., 7*6*5*4*...*1*1.
        for(int i = 1; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * This calculates a permutation.
     * @param n - total items
     * @param r - how many we're choosing
     * @return factorial method of the total items divided by the factorial method of total - how many were chosen.
     */
    public BigInteger permutations(int n, int r) {
        return ((bigIntegerFactorial(n)).divide(bigIntegerFactorial(n - r)));
    }

    /**
     * This calculates the combinations given the total items and how many are chosen.
     * @param n - total items
     * @param r - how many we're choosing
     * @return factorial method of the total items divided by the factorial method of how many
     * we're choosing * total - how many we're choosing
     */
    public BigInteger combinations(int n, int r) {
        BigInteger numerator = (bigIntegerFactorial(n));
        BigInteger denominator = (bigIntegerFactorial(r)).multiply((bigIntegerFactorial(n - r)));
        return numerator.divide(denominator);
    }

    /**
     * This calculates combinations using longs.
     * @param n - total items.
     * @param r - how many are chosen
     * @return the combination result of n choose r
     */
    public long combinationsLong(int n, int r) {
        double numerator = longFactorial(n);
        double denominator = longFactorial(r) * longFactorial(n - r);
        return (long) (numerator / denominator);
    }

    /**
     * This method returns the probability of P(A|B).
     * @param b - probability of b
     * @param aIntersectionB - intersection of a and b
     * @return the intersection of a and b divided by b. if b is equal to 0, the program just
     * returns 0 to avoid any errors that may appear
     */
    public double conditionalProbability1(double b, double aIntersectionB) {
        if(b == 0) {
            return 0.00;
        }
        return (aIntersectionB / b);
    }

    /**
     * This method returns the conditional probability of (B|A).
     * @param a - probability of a
     * @param aIntersectionB - intersection of a and b
     * @return the intersection of a and b divided by a, and returns 0 if a is equal to 0 to
     * avoid any errors that will be thrown if the result is being divided by 0.
     */
    public double conditionalProbability2(double a, double aIntersectionB) {
        if(a == 0) {
            return 0.00;
        }
        return (aIntersectionB / a);
    }

    /**
     * This method returns the independence of a set of values.
     * @param aGivenB - conditional probability result of A given B has occurred
     * @param bGivenA - conditional probability result of B given A has occurred
     * @param a - probability of a
     * @param b - probability of b
     * @param aIntersectionB - intersection of a and b
     * @return true if the values are independent and false if they are dependent.
     */
    public boolean independenceChecker(double aGivenB, double bGivenA, double a, double b,
                                       double aIntersectionB) {
        return aGivenB == a || bGivenA == b || aIntersectionB == (a * b);
    }

    /**
     * This method returns the first condition of the multiplicative law of probability.
     * @param a - probability of a
     * @param bGivenA - conditional probability of b given a has already occurred
     * @return the multiplication of a and bGivenA
     */
    public double multiplicativeLawOfProbability1(double a, double bGivenA) {
        return a * bGivenA;
    }

    /**
     * This method returns the second condition of the multiplicative law of probability.
     * @param a - probability of a
     * @param aGivenB - conditional probability of a given b has already occurred
     * @return the result of multiplying a and aGivenB.
     */
    public double multiplicativeLawOfProbability2(double a, double aGivenB) {
        return a * aGivenB;
    }

    /**
     *
     * @param a - probability of a
     * @param b - probability of b
     * @return the result of multiplying a and b together
     */
    public double multiplicativeLawOfProbability3(double a, double b) {
        return a * b;
    }

    /**
     * This returns the first condition of the additive law of probability where the intersection
     * must be subtracted because it is being counted twice.
     * @param a - probability of a
     * @param b - probability of b
     * @param aIntersectionB - the intersection of a and b
     * @return the addition of a and b minus the intersection of a and b
     */
    public double additiveLawOfProbability1(double a, double b, double aIntersectionB) {
        return a + b - aIntersectionB;
    }

    /**
     * This method returns the second version of the additive law of probability where
     * the intersection is not included twice and therefore doesn't need to be subtracted.
     * @param a - probability of a
     * @param b - probability of b
     * @return the addition of a and b without subtracting the intersection
     */
    public double additiveLawOfProbability2(double a, double b) {
        return a + b;
    }

    /**
     * This method returns the complement or the odds of something not happening.
     * @param aBar - the complement of a
     * @return the subtraction of 1 and aBar, returning the complement of aBar which is just a.
     */
    public double oddsOfSomethingNotHappening(double aBar) {
        return 1.0 - aBar;
    }

    /**
     * This calculates the result of the theorem of total probability.
     * @param aGivenB - conditional probability of a given b has occurred
     * @param b - probability of b
     * @param bBar - complement of b
     * @param aGivenBBar - conditional probability of a given BBar has occurred
     * @return the conditional probability of a given b * b divided by a given b * b + a given
     * bBar * bBar, or the result of the theorem of total probability
     */
    public double theoremOfTotalProbability(double aGivenB, double b, double bBar, double aGivenBBar) {
        return ((aGivenB) * (b)) / (((aGivenB) * (b)) + ((aGivenBBar) * (bBar)));
    }

    /**
     * This is a method that computes the result of Bayes Theorem.
     * @param a - probability of a
     * @param b - probability of b
     * @param aGivenB - conditional probability of a given b has occurred
     * @return the conditional probability of a given b times b divided by a (Bayes theorem definition)
     */
    public double bayesTheorem(double a, double b, double aGivenB) {
        return ((aGivenB) * (b)) / a;
    }

    /**
     * This computes the combinatorial probability mass function result.
     * @param N - total items
     * @param nR - total red balls (made sense to me to do it this way based on
     *           an example from our notes)
     * @param nB - total black balls
     * @param y - number of wanted red balls
     * @param s - amount of balls selected from a bag
     * @return combination of number of red choose y * number of black choose selected minus y
     * divided by total choose selected (returns the combinatorial result)
     */
    public double combinatorialPMF(int N, int nR, int nB, int y, int s) {
        return (double) ((combinationsLong(nR, y)) * (combinationsLong(nB, (s - y)))) / (combinationsLong(N, s));
    }

    /**
     * This calculates the binomial distribution of values based on the formula.
     * @param p - success probability
     * @param q - fail probability
     * @param n - trials
     * @param y - successes
     * @return the binomial distribution result
     */
    public double binomialDistributionPMF(double p, double q, int n, int y) {
        return (combinationsLong(n, y)) * (Math.pow(p, y)) * (Math.pow(q, (n - y)));
    }

    /**
     * Calculates the expected value from binomial distribution.
     * @param n - trials
     * @param p - success probability
     * @return number of trials * success probability
     */
    public double expectedValueBDPMF(double n, double p) {
        return n * p;
    }

    /**
     * Computes the variance based on the binomial distribution function.
     * @param n - trials
     * @param p - success probability
     * @param q - fail probability
     * @return trials * success probability * fail probability
     */
    public double varianceValueBDPMF(double n, double p, double q) {
        return n * p * q;
    }

    /**
     * This calculates the standard deviation based on the binomial distribution formula.
     * @param n - trials
     * @param p - success probability
     * @param q - fail probability
     * @return the square root of the variance which is the standard deviation
     */
    public double standardDeviationValueBDPMF(double n, double p, double q) {
        return Math.sqrt(varianceValueBDPMF(n, p, q));
    }

    /**
     * This computes the result of geometric distribution.
     * @param p - success probability
     * @param q - fail probability
     * @param y - trials
     * @return the result of the geometric distribution formula by multiplying the success probability
     * by the fail probability raised to the y-1 power (one less than total trials)
     */
    public double geometricDistributionPMF(double p, double q, int y) {
        return (Math.pow(q, (y - 1))) * p;
    }

    /**
     * This computes the expected value of the geometric distribution formula.
     * @param p - success probability
     * @return 1 divided by the success probability (returns the mean, or expected value)
     */
    public double expectedValueGDPMF(double p) {
        return 1 / p;
    }

    /**
     * This returns the variance of the geometric distribution result.
     * @param p - success probability
     * @return the fail probability divided by p raised to the second power
     */
    public double varianceValueGDPMF(double p) {
        return (1 - p)/(Math.pow(p, 2));
    }

    /**
     * This returns the standard deviation of the geometric distribution.
     * @param p - success probability
     * @return the square root of the variance
     */
    public double standardDeviationValueGDPMF(double p) {
        return Math.sqrt(varianceValueGDPMF(p));
    }

    /**
     * Finds the hypergeometric distribution from the PMF.
     * @param r - available items of first type
     * @param y - number of second type items chosen
     * @param N - total items
     * @param n- number of items picked
     * @return the result after computing the hypergeometric distribution
     */
    public long hypergeometricDistributionPMF(int r, int y, int N, int n) {
        return ((combinationsLong(r, y)) * (combinationsLong(N - r, n - y))) /
                (combinationsLong(N, n));
    }

    /**
     * This method returns the expected value that would come from the hypergeometric distribution result.
     * @param n - number of items picked
     * @param r - available items of first type
     * @param N - total items
     * @return the number of items picked * total items of first type / total items (returns mean)
     */
    public double expectedValueHGDPMF(double n, double r, double N) {
        return (n * r) / N;
    }

    /**
     * This returns the variance for the hypergeometric distribution pmf.
     * @param n - number of items picked
     * @param r - available items of first type
     * @param N - total items
     * @return the variance of the values from hypergeometric distribution
     */
    public double varianceValueHGDPMF(double n, double r, double N) {
        return n * (r / N) * ((N - r) / N) * ((N - n) / (N - 1));
    }

    /**
     * Finds the standard deviation from the hypergeometric distribution pmf.
     * @param n - number of items picked
     * @param r - available items of first type
     * @param N - total items
     * @return the square root of the variance which returns the standard deviation
     */
    public double standardDeviationValueHGDPMF(double n, double r, double N) {
        return Math.sqrt(varianceValueHGDPMF(n, r, N));
    }

    /**
     * This returns the resulting value after calculating distributions using the
     * negative binomial distribution pmf.
     * @param p - success probability
     * @param q - fail probability
     * @param y - total trials run
     * @param r - how many times we'd like to "win"
     * @return the result of performing negative binomial distribution on values
     */
    public double negativeBinomialDistributionPMF(double p, double q, int  y, int r) {
        double combination = combinationsLong(y - 1, r - 1);
        return combination * (Math.pow(p, r)) * (Math.pow(q, y - r));
    }

    /**
     * This computes the expected value relating to the negative binomial distribution pmf.
     * @param p - success probability
     * @param r - how many times we'd like to "win"
     * @return the expected value related to the negative binomial distribution pmf (wins / success)
     */
    public double expectedValueNBDPMF(double p, int r) {
        return r / p;
    }

    /**
     * This computes the variance of the negative binomial distribution formula.
     * @param p - success probability
     * @param r - number of "wins"
     * @return the variance relating to the negative binomial distribution formula
     */
    public double varianceValueNBDPMF(double p, int r) {
        return (r * (1 - p)) / (Math.pow(p, 2));
    }

    /**
     * This calculates the standard deviation as it relates to the negative binomial distribution pmf.
     * @param p - success probability
     * @param r - number of "wins"
     * @return the square root of the variance which returns the standard deviation
     */
    public double standardDeviationValueNBDPMF(double p, int r) {
        return Math.sqrt(varianceValueNBDPMF(p, r));
    }

    /**
     * This calculates the Poisson Distribution probability.
     * @param mean - represents the mean, or average value, of the given problem.
     * @param y - represents the trial number, or what Y is equal to in P(Y = ?).
     * @return the Poisson distribution probability for a given event.
     */
    public double poissonDistribution(double mean, double y) {
        return ((Math.pow(mean, y)) / (longFactorial(y))) * (Math.pow(Math.E, -mean));
    }

    /**
     * This calculates the expected value for Poisson Distribution.
     * @param mean - represents the mean, or average value.
     * @return the expected value, which is equal to the mean.
     */
    public double expectedValuePoissonDistribution(double mean) {
        return mean;
    }

    /**
     * This calculates the variance of a Poisson Distribution problem.
     * @param mean - represents the mean, or average value.
     * @return the variance value, which is equal to the mean.
     */
    public double varianceValuePoissonDistribution(double mean) {
        return mean;
    }

    /**
     * This calculates the standard deviation of a Poisson Distribution problem.
     * @param mean - represents the mean, or average value.
     * @return the standard deviation, or the square root of the mean.
     */
    public double standardDeviationValuePoissonDistribution(double mean) {
        return Math.sqrt(mean);
    }

    /**
     * This calculates the results of running Tchebysheff's, or Chebyshev's, theorem.
     * @param k - represents the "within" number divided by the standard deviation.
     * @return the result of computing Tchebysheff's theorem on some k.
     */
    public double tchebysheffsTheorem(double k) {
        return 1 - (1 / Math.pow(k, 2));
    }

    /**
     * This method calculates what the "k" value in Tchebysheff's theorem represents.
     * @param within - the "within" number, or how far each value is from the mean.
     * @param standardDeviation - the standard deviation of the problem.
     * @return the k value, which is the within number divided by the standard deviation.
     */
    public double k(double within, double standardDeviation) {
        return within / standardDeviation;
    }
}