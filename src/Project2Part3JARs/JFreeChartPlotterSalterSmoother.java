package Project2Part3JARs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JFreeChartPlotterSalterSmoother {
    public void jPolynomialPlotter() {
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        for(int x = -50; x <= 50; x++) {
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            original.add(x, y);
        }
        values.addSeries(original);

        for(int x = -50; x <= 50; x++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            double y = Math.pow((0.1 * x), 2) - (0.5 * x) - 2;
            if(x % 2 == 0) {
                y = y + randomSaltValue;
            }
            else {
                y = y - randomSaltValue;
            }
            salted.add(x, y);
        }
        values.addSeries(salted);
        values.addSeries(smoothed);

        JFreeChart graph = ChartFactory.createXYLineChart("Data Plotter for sin(2x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void jSinePlotter() {
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        for(int x = -50; x <= 50; x++) {
            double y = Math.sin(2 * x);
            original.add(x, y);
        }
        values.addSeries(original);

        for(int x = -50; x <= 50; x++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            double y = Math.sin(2 * x);
            if(x % 2 == 0) {
                y = y + randomSaltValue;
            }
            else {
                y = y - randomSaltValue;
            }
            salted.add(x, y);
        }
        values.addSeries(salted);
        values.addSeries(smoothed);

        JFreeChart graph = ChartFactory.createXYLineChart("Data Plotter for sin(2x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
        jFrame.setContentPane(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void jCosineWavesPlotter() {
        XYSeriesCollection values = new XYSeriesCollection();
        XYSeries original = new XYSeries("Original Function");
        XYSeries salted = new XYSeries("Salted Function");
        XYSeries smoothed = new XYSeries("Smoothed Function");
        for(int x = -50; x <= 50; x++) {
            double y = (3 * Math.cos(x)) - (5 * Math.cos(2 * x))
                    - (2 * Math.cos(3 * x)) - (Math.cos(4 * x));
            original.add(x, y);
        }
        values.addSeries(original);

        for(int x = -50; x <= 50; x++) {
            Random randomNumber = new Random();
            int randomSaltValue = randomNumber.nextInt(100);
            double y = (3 * Math.cos(x)) - (5 * Math.cos(2 * x))
                    - (2 * Math.cos(3 * x)) - (Math.cos(4 * x));
            if(x % 2 == 0) {
                y = y + randomSaltValue;
            }
            else {
                y = y - randomSaltValue;
            }
            salted.add(x, y);
        }
        values.addSeries(salted);
        values.addSeries(smoothed);

        JFreeChart graph = ChartFactory.createXYLineChart("Data Plotter for sin(2x)",
                "X-Value (Increment)", "Y-Value (Result)", values);

        ChartPanel panel = new ChartPanel(graph);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setBackground(Color.white);
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
