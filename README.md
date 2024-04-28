**PROJECT 2 - MIA W.**

**WELCOME TO THE PROBABILITY AND APPLIED STATISTICS PROJECT 2 REPOSITORY!**
This repository contains documentation, .csv files, a data plotter, salter, and smoother, a formula sheet, and a stats library. Other programs include a MATLAB
data plotter, salter, and smoother, a .jar file plotter, salter, and smoother (one from JFreeChart and the other from Apache Commons Math), a Stock Bot to determine
when to buy or sell stocks, and a dataset paper that visualizes data from a Goodreads book dataset and tells a story about the data through statistics problems.

**NAVIGATION -** Go through the src folder to find code related items. Go through WrittenWorks to find documentation, CSV files, written reports, and results.

**CONTRIBUTORS -** To program the Stock Bot, I worked with / helped Garret Chmielewski, received help from Jake Cubernot, and worked alongside Heather Krencicki who
is not currently in the class. Thank you to Jake, Heather, and Garret!

**CODE -**
Contains code from the updated Stats Library and a .csv file Plotter, Salter, and Smoother written in Java. Along with a Java plotter, salter, and smoother,
there is a MATLAB and .jar file plotter, salter, and smoother as mentioned above. The MATLAB version was written after following a tutorial, and the .jar versions were created by using .jar files downloaded from JFreeChart (https://sourceforge.net/projects/jfreechart/files/) and Apache Commons Math (https://commons.apache.org/proper/commons-math/index.html).

**Stats Library -** This includes a full list of the following:
Poisson distribution, the expected, variance, and standard deviation of Poisson distribution, Tchebysheff's (or Chebyshev's) theorem, how to calculate the k
value of Chebyshev's theorem, Uniform Distribution, the expected value, variance, and standard deviation of Uniform Distribution, the expected value, variance, and
standard deviation of Gamma Distribution, Exponential Distribution, the expected, variance, and standard deviation of Exponential Distribution, conditional density for
x and y values, and independency for functions, densities, probabilities, and distributions.

**Project 2 Part 1 Java -** This folder contains programs that will plot output in a .csv file (Plotter and TestPlotter),
salt the data (i.e., add "garbage" values to the data to avoid detection) by taking a .csv file and updating the values
(Salter and TestSalter), then smooth the data by averaging the salted values (Smoother and TestSmoother).

**Project 2 Part 2 MATLAB -** This folder contains a .txt and .mlx file that can be used within MATLAB's Live Editor. The code shown in this
folder is another version of the original plotter, salter, and smoother, just with MATLAB instead of Java.

**Project 2 Part 3 JARs -** This folder contains code used to create both a JFreeChart plotter, salter, and smoother and an Apache Commons Math plotter, salter, and
smoother. These programs require external .jar files to run which can be found through the links listed under "CODE." The JFreeChart version plots the data using
XYSeries and graph objects, and the Apache Commons Math version uses a random number generator, a sine method, and a mean / smoothing method that is different
than those within Java's classes.

**Project 2 Part 4 Stock Bot -** This folder contains both the Stock Bot main class and the Stock Bot tester class that are used to track stock trends to determine whether
someone should buy or sell at a specific point. The bot uses RSI (Relative Strength Index) to help with eventually calculating a moving average which is similar
to the original data smoother written in Java (no .jar files). To program the Stock Bot, I worked with Garret Chmielewski, Heather Krencicki (not currently in stats), and
Jake Cubernot. Huge thanks to everyone who worked with me or helped!


**WRITTEN WORKS -**
This sections consists of program documentation, written reports, results, and a formula sheet that contains all formulas covered in the course thus far.

**CSV Practice File -** This folder contains a .csv file that was created in class one day to practice plotting data.

**CSV Result Files -** The result file contains Apache Commons graph results and documentation, polynomial PSS results, sine PSS results, cosine PSS results, a master
Excel sheet which holds all data and a graph that contains each series.

**CSV Trial Files -** For anyone who is interested, the files found within this folder are those generated after running the original plotter, salter, and smoother
before edits had been made. These were tests to make sure the program was working.

**Documentation -** This folder contains documentation for the Java plotter, salter, and smoother, documentation for the Apache Commons Math and JFreeChart plotters, 
salters, and smoothers, and Stats Library results and documentation. It also includes Stock Bot documentation and results, including graphs, method descriptions, and 
images that show what the output looks like when the program is run within the console.

**Formula Sheet -** Holds the current formula sheet that has all formulas covered in the course up to this point.

**Goodreads Dataset Report -** This folder holds the .csv file that contains all books in the Goodreads site database along with the report that tells a story about
the data contained within the .csv file.

**MATLAB Reports -** This folder consists of the MATLAB Onramp tutorial report along with the file that contains documentation and results for the MATLAB 
plotter, salter, and smoother.
