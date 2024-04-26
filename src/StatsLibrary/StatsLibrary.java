package StatsLibrary;

//Import statement for the BigInteger class.
import java.math.BigInteger;

//The StatsLibrary class is a comprehensive collection of formulas that have been taught
//in Probability and Applied Statistics. END OF CHAPTER 3 AND ALL OF CHAPTER 4 AND 5 ONLY!!

//A full list of everything that has been programmed into the StatsLibrary would include the following:
//Poisson distribution, the expected value, variance, and standard deviation for Poisson distribution,
//Tchebysheff's theorem, Tchebysheff's k-value, Uniform Distribution, the expected, variance, and
//standard deviation of uniform distribution, the expected value, variance, and standard deviation
//of Gamma Distribution, exponential distribution, and the expected, variance, and standard deviation
//of exponential distribution.

/**
 * @author Mia Watts
 */
public class StatsLibrary {
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

    /**
     * This method calculates the Uniform Probability Distribution value.
     * @param a - first value of the interval.
     * @param b - second value of the interval.
     * @return the uniform distribution value, calculated by dividing 1 by b - a.
     */
    public double uniformDistribution(double a, double b) { return 1 / (b - a); }

    /**
     * This method returns the expected value calculated from Uniform Probability Distribution.
     * @param theta1 - the first value used within the calculation.
     * @param theta2 - the second value used within the calculation.
     * @return the expected value, which also happens to be the actual average.
     */
    public double expectedValueUniformDistribution(double theta1, double theta2) {
        return (theta1 + theta2) / 2;
    }

    /**
     * This method returns the variance value obtained from the Uniform Probability Distribution formula.
     * @param theta1 - the first value used within the calculation.
     * @param theta2 - the second value used within the calculation.
     * @return the variance value, which is the way it is because of a proof.
     */
    public double varianceValueUniformDistribution(double theta1, double theta2) {
        return (Math.pow(theta2 - theta1, 2)) / 12;
    }

    /**
     * This method calculates the standard deviation of a Uniform Distribution.
     * It takes the square root of the variance, which is the method shown above this one.
     * @param theta1 - the first value used within the calculation.
     * @param theta2 - the second value used within the calculation.
     * @return the standard deviation of a Uniform Probability Distribution.
     */
    public double standardDeviationUniformDistribution(double theta1, double theta2) {
        return Math.sqrt((Math.pow(theta2 - theta1, 2)) / 12);
    }

    /**
     * This method calculates the expected value as it relates to Gamma Distribution.
     * @param alpha - the alpha value used to calculate the expected value.
     * @param beta - the beta (mean) value used to calculate the expected value.
     * @return the result of multiplying alpha and beta, which is the expected value.
     */
    public double expectedValueGammaDistribution(double alpha, double beta) {
        return alpha * beta;
    }

    /**
     * This method calculates the variance of a Gamma Distribution.
     * @param alpha - the alpha value used to calculate the variance.
     * @param beta - the beta (mean) value used to calculate the variance.
     * @return the result of multiplying alpha by beta squared, which is the variance.
     */
    public double varianceValueGammaDistribution(double alpha, double beta) {
        return alpha * (Math.pow(beta, 2));
    }

    /**
     * This method calculates the standard deviation of a Gamma Distribution, which is
     * the square root of the variance.
     * @param alpha - the alpha value used to calculate the standard deviation.
     * @param beta - the beta (mean) value used to calculate the standard deviation.
     * @return the square root of the variance, which is the standard deviation.
     */
    public double standardDeviationGammaDistribution(double alpha, double beta) {
        return Math.sqrt(alpha * (Math.pow(beta, 2)));
    }

    /**
     * This method calculates the result of an exponential distribution with a beta (mean) and y value.
     * This can only occur if alpha is equal to 1.
     * @param beta - the beta value associated with exponential distribution (the mean).
     * @param y - the y value associated with exponential distribution.
     * @return the exponential distribution result. If alpha is not 1, the program returns
     * a statement that tells the user that the problem they gave is not exponential in its distribution.
     */
    public String exponentialDistribution(double alpha, double beta, double y) {
        if(alpha != 1.0) {
            return "An alpha value of " + alpha + " is not possible. Alpha must be 1.";
        }
        return "Alpha is 1, so the result can be calculated: " + (1 / beta) * (Math.pow(Math.E, (-y / beta)));
    }

    /**
     * This method returns the expected value of an exponential distribution which also happens
     * to be the beta value given, or the mean.
     * @param beta - the mean value associated with exponential distribution.
     * @return the beta value, which is the expected value related to exponential distribution.
     */
    public double expectedValueED(double beta) {
        return beta;
    }

    /**
     * This method calculates the variance of an exponential distribution, which is beta multiplied by beta.
     * @param beta - the mean value associated with exponential distribution.
     * @return the variance value, which is beta squared.
     */
    public double varianceValueED(double beta) {
        return Math.pow(beta, 2);
    }

    /**
     * This method calculates the standard deviation of an exponential distribution instance.
     * @param beta - the mean value associated with exponential distribution.
     * @return the standard deviation of an exponential distribution.
     */
    public double standardDeviationED(double beta) {
        return beta;
    }

    /**
     * This method determines the conditional density of y.
     * @param jointDensity - joint density function.
     * @param yDensity - density of just y.
     * @return the joint density function divided by the density function of y.
     */
    public double conditionalDensity1(double jointDensity, double yDensity) {
        return jointDensity / yDensity;
    }

    /**
     * This method determines the conditional density of x.
     * @param jointDensity - joint density function.
     * @param xDensity - density of just x.
     * @return the joint density function divided by the density function of x.
     */
    public double conditionalDensity2(double jointDensity, double xDensity) {
        return jointDensity / xDensity;
    }

    /**
     * This method determines whether a joint distribution function is independent and/or
     * whether X and Y are independent.
     * @param jointDistribution - joint distribution function.
     * @param xDistribution - distribution of x.
     * @param yDistribution - distribution of y.
     * @return true if the result says they are independent and false otherwise.
     */
    public boolean independency1(double jointDistribution, double xDistribution, double yDistribution) {
        return jointDistribution == (xDistribution * yDistribution);
    }

    /**
     * This method determines whether a joint probability function is independent and/or
     * whether X and Y are independent.
     * @param jointProbability - joint probability function.
     * @param xProbability - distribution of x.
     * @param yProbability - distribution of y.
     * @return true if the result says they are independent and false otherwise.
     */
    public boolean independency2(double jointProbability, double xProbability, double yProbability) {
        return jointProbability == (xProbability * yProbability);
    }

    /**
     * This method determines whether a joint density function is independent and/or
     * whether X and Y are independent.
     * @param jointDensity - joint density function.
     * @param xDensity - density of x.
     * @param yDensity - density of y.
     * @return true if the result says they are independent and false otherwise.
     */
    public boolean independency3(double jointDensity, double xDensity, double yDensity) {
        return jointDensity == (xDensity * yDensity);
    }

    /**
     * This method determines whether two functions are independent.
     * @param jointDensity - joint density function.
     * @param xFunction - function of x.
     * @param yFunction - function of y.
     * @return true if the result says they are independent and false otherwise.
     */
    public boolean independency4(double jointDensity, double xFunction, double yFunction) {
        return jointDensity == (xFunction * yFunction);
    }
}
