package Project2Part3JARs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class JFreeChartPlotterSalterSmoother {
    public void jPolynomialPlotter() {
        DefaultCategoryDataset values = new DefaultCategoryDataset();
        for(int x = -25; x <= 25; x++) {
            double result = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            values.addValue(result, "Y-Values", String.valueOf(x));
        }
        JFreeChart graph = ChartFactory.createLineChart("Data Plotter for 0.1x^2 - 0.5x - 2",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void jSinePlotter() {
        DefaultCategoryDataset values = new DefaultCategoryDataset();
        for(int x = -25; x <= 25; x++) {
            double result = Math.sin(2 * x);
            values.addValue(result, "Y-Values", String.valueOf(x));
        }
        JFreeChart graph = ChartFactory.createLineChart("Data Plotter for sin(2x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void jCosineWavesPlotter() {
        DefaultCategoryDataset values = new DefaultCategoryDataset();
        for(int x = -25; x <= 25; x++) {
            double result = (3 * Math.cos(x)) - (5 * Math.cos(2 * x))
                    - (2 * Math.cos(3 * x)) - (Math.cos(4 * x));;
            values.addValue(result, "Y-Values", String.valueOf(x));
        }
        JFreeChart graph = ChartFactory
                .createLineChart("Data Plotter for 3cos(x) - 5cos(2x) - 2cos(3x) - cos(4x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JFreeChartPlotterSalterSmoother test = new JFreeChartPlotterSalterSmoother();
        test.jPolynomialPlotter();
        test.jSinePlotter();
        test.jCosineWavesPlotter();
    }
}
