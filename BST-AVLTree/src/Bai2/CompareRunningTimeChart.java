package Bai2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CompareRunningTimeChart {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chart comparing the execution time of search algorithms: ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1500, 800));

        int[] inputSizes = {100, 1000, 10000};

        XYSeries linear_search = new XYSeries("Linear Search");
        XYSeries binary_search = new XYSeries("Binary Search");
        XYSeries binary_search_tree = new XYSeries("Binary Search Tree");

        for (int size : inputSizes) {
            int[] arr = getArray(size);
            int randomIdxToSearch = (int) (Math.random() * size);
            int randomNumToSearch = arr[randomIdxToSearch];

            linear_search.add(size, linear(arr, randomNumToSearch));
            binary_search.add(size, binarySearch(arr, randomNumToSearch));
            binary_search_tree.add(size, binarySearchTree(arr, randomNumToSearch));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(linear_search);
        dataset.addSeries(binary_search);
        dataset.addSeries(binary_search_tree);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Searching Algorithm",
                "Length Of Array",
                "Running Time",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        XYPlot plot = chart.getXYPlot();
        XYSplineRenderer renderer = new XYSplineRenderer();
        plot.setRenderer(renderer);
        Plot plot1 = chart.getPlot();
        plot1.setBackgroundPaint(Color.WHITE);

        ChartPanel chartPanel = new ChartPanel(chart);
        frame.getContentPane().add(chartPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private static long linear(int[] array, int num) {
        LinearSearch<Integer> linear = new LinearSearch<>();
        for (int element : array) {
            linear.add(element);
        }
        return linear.getTime(num);
    }

    private static long binarySearch(int[] array, int num) {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        for (int element : array) {
            binarySearch.add(element);
        }
        return binarySearch.getTime(num);
    }

    private static long binarySearchTree(int[] array, int num) {
        SearchBinaryTree<Integer> bst = new SearchBinaryTree<>();
        for (int i : array) {
            bst.insert(i);
        }
        return bst.getTime(num);
    }


    public static int[] getArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = inputNonDup(array, new Random(), i , 100000);
        }
        return array;
    }

    public static int inputNonDup(int[] array, Random random, int i, int bound) {
        if (array == null) {
            System.out.println("Empty array!");
            System.exit(0);
        }
        int num = random.nextInt(bound);
        while (isDuplicate(array, i, num)) {
            num = random.nextInt(bound);
        }
        return num;
    }

    public static boolean isDuplicate(int[] array, int i, int num) {
        if (array == null) {
            System.out.println("Empty array!");
            System.exit(0);
        }
        for (int j = 0; j < i; j++) {
            if (array[j] == num) {
                return true;
            }
        }
        return false;
    }
}
