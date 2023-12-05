package Bai3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Chart {
    public static void main(String[] args) {
//        JFrame frame = new JFrame("Compare Running time of sorting algorithm");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setPreferredSize(new Dimension(10000, 1100));
//
//        JFreeChart barChart = ChartFactory.createBarChart(
//                "Chart comparing the execution time of sorting algorithms",
//                "Length Of Array",
//                "Running Time",
//                dataset,
//                PlotOrientation.VERTICAL,
//                true, true, false
//        );

//        XYSeries bubbleSortRunningTime = new XYSeries("Bubble Sort");
//        XYSeries selectionSortRunningTime = new XYSeries("Selection Sort");
//        XYSeries insertionSortRunningTime = new XYSeries("Insertion Sort");
//        XYSeries heapSortRunningTime = new XYSeries("HeapSort");
//        XYSeries quickSortRunningTime = new XYSeries("Quick Sort");
//        XYSeries mergeSortRunningTime = new XYSeries("Merge Sort");


//        int[] arr = generateRandomArray();

//            long startTimeBubble = System.currentTimeMillis();
//            Sort bubbleSort = new BubbleSort();
//            bubbleSort.sort(arrBubble);
//            long endTimeBubble = System.currentTimeMillis();



//            long startTimeSelection = System.currentTimeMillis();
//            Sort selectionSort = new SelectionSort();
//            selectionSort.sort(arrSelection);
//            long endTimeSelection = System.currentTimeMillis();

//            long startTimeInsertion = System.currentTimeMillis();
//            Sort insertionSort = new InsertionSort();
//            insertionSort.sort(arrInsertion);
//            long endTimeInsertion = System.currentTimeMillis();

//            long startTimeQuick = System.currentTimeMillis();
//            Sort quickSort = new QuickSort();
//            quickSort.sort(arrQuick);
//            long endTimeQuick = System.currentTimeMillis();

//            long startTimeMerge = System.currentTimeMillis();
//            Sort mergeSort = new MergeSort();
//            mergeSort.sort(arrMerge);
//            long endTimeMerge = System.currentTimeMillis();

//        sort.setSort(new SelectionSort(), arr);
//        sort.setSort(new InsertionSort(), arr);
//        sort.setSort(new HeapSort(), arr);
//        sort.setSort(new QuickSort(), arr);
//        sort.setSort(new MergeSort(), arr);
//
//
//
//
//        ChartPanel chartPanel = new ChartPanel(barChart);
//        frame.getContentPane().add(chartPanel);
//
//        frame.pack();
//        frame.setVisible(true);
//
//        XYPlot plot = barChart.getXYPlot();
//        XYSplineRenderer renderer = new XYSplineRenderer();
//        plot.setRenderer(renderer);
//        Plot plot1 = barChart.getPlot();
//        plot1.setBackgroundPaint(Color.WHITE);
        JFrame frame = new JFrame("Compare Running time of sorting algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(10000, 1100));

        ChartPanel chartPanel = new ChartPanel(createChart());
        frame.getContentPane().add(chartPanel);

        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private static CategoryDataset createDataset(int[] arr) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SetSort sort = new SetSort();

        int[] arrBubble = Arrays.copyOf(arr, arr.length);
        int[] arrSelection = Arrays.copyOf(arr, arr.length);
        int[] arrInsertion = Arrays.copyOf(arr, arr.length);
        int[] arrHeap = Arrays.copyOf(arr, arr.length);
        int[] arrQuick = Arrays.copyOf(arr, arr.length);
        int[] arrMerge = Arrays.copyOf(arr, arr.length);

        sort.setSort(new BubbleSort(), arrBubble);
        dataset.addValue(sort.getTime(), "Running Time", "Bubble Sort");

        sort.setSort(new SelectionSort(), arrSelection);
        dataset.addValue(sort.getTime(), "Running Time", "Selection Sort");

        sort.setSort(new InsertionSort(), arrInsertion);
        dataset.addValue(sort.getTime(), "Running Time", "Insertion Sort");

        sort.setSort(new HeapSort(), arrHeap);
        dataset.addValue(sort.getTime(), "Running Time", "Heap Sort");

        sort.setSort(new QuickSort(), arrQuick);
        dataset.addValue(sort.getTime(), "Running Time", "Quick Sort");

        sort.setSort(new MergeSort(), arrMerge);
        dataset.addValue(sort.getTime(), "Running Time", "Merge Sort");

        return dataset;
    }

    private static JFreeChart createChart() {
        CategoryDataset dataset = createDataset(generateRandomArray());

        return ChartFactory.createBarChart(
                "Chart comparing the execution time of sorting algorithms",
                "Length Of Array",
                "Running Time",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
    }

    private static int[] generateRandomArray() {
        int[] arrayRandom = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arrayRandom[i] = (int) (Math.random() * 1000);
        }
        return arrayRandom;
    }

}
