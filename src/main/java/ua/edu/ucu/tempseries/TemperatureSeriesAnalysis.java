package ua.edu.ucu.tempseries;


import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    // define
    private double[] temperatureSeries;
    private int index;
    public final int LOWER_BOUND = -273;

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        // constructor with parameters
        this.temperatureSeries = temperatureSeries;
        System.out.println(Arrays.toString(temperatureSeries));
        System.out.println(Arrays.toString(temperatureSeries));
        this.index = temperatureSeries.length;
    }

    public TemperatureSeriesAnalysis() {
        // default constructor
        this.temperatureSeries = new double[0];
        this.index = 0;
    }

    public double average() throws IllegalArgumentException {
        throwException();
        int size = temperatureSeries.length;
        double sum = sum();
        return sum / size;
    }

    public double deviation() throws IllegalArgumentException {
        throwException();
        double deviation;
        double mean = mean();
        double summation = 0;
        for (double temp : temperatureSeries) {
            summation += (temp - mean) * (temp - mean);
        }
        deviation = Math.sqrt(summation / temperatureSeries.length);
        return deviation;
    }

    public double min() throws IllegalArgumentException {
        throwException();
        double min = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public double max() throws IllegalArgumentException {
        throwException();
        double max = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue)
            throws IllegalArgumentException {
        throwException();
        double closestLeft = Double.MAX_VALUE;
        double closestRight = Double.MAX_VALUE;
        // sort array to filter temperatures from the smallest to greatest
        sortTemps();
        for (double temp : temperatureSeries) {
            if (temp < tempValue) {
                closestLeft = temp;
            } else {
                closestRight = temp;
                break;
            }
        }
        // compare results
        if (Math.abs(closestLeft - tempValue)
                < Math.abs(closestRight - tempValue)) {
            return closestLeft;
        } else {
            return closestRight;
        }
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] tempsLessThen = new double[0];
        int ind = 0;
        for (double temp : temperatureSeries) {
            if (temp < tempValue) {
                // increase buff size by 1 and add
                tempsLessThen = Arrays.copyOf(tempsLessThen,
                        tempsLessThen.length + 1);
                tempsLessThen[ind++] = temp;
            }
        }
        return tempsLessThen;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] tempsGreaterThen = new double[0];
        int ind = 0;
        for (double temp : temperatureSeries) {
            if (temp > tempValue) {
                // increase buff size by 1 and add
                tempsGreaterThen = Arrays.copyOf(tempsGreaterThen,
                        tempsGreaterThen.length + 1);
                tempsGreaterThen[ind++] = temp;
            }
        }
        return tempsGreaterThen;
    }

    public TempSummaryStatistics summaryStatistics() {
        throwException();
        // returns an immutable instance of a class
        return TempSummaryStatistics.createNewInstance(average(),
                deviation(),
                min(),
                max());
    }

    public int addTemps(double[] temps) {
        if (!checkBounds(temps)) {
            throw new InputMismatchException();
        }
        // set buff to 2
        if (temperatureSeries.length == 0) {
            temperatureSeries = Arrays.copyOf(temperatureSeries, 2);
        }
        // increase buff size
        while (temperatureSeries.length < index + temps.length) {
            temperatureSeries = Arrays.copyOf(temperatureSeries,
                    temperatureSeries.length * 2);
        }
        // insert new elements
        for (double temp : temps) {
            temperatureSeries[index++] = temp;
        }
        return index;
    }

    public boolean checkBounds(double[] temps) {
        // check for correct bounds
        for (double temp : temps) {
            if (temp < LOWER_BOUND) {
                return false;
            }
        }
        return true;
    }

    public void throwException() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void sortTemps() {
        // sort array
        Arrays.sort(temperatureSeries);
    }

    public double sum() {
        // find the total sum of elements in the array
        double sum = 0.0;
        for (double temp: temperatureSeries) {
            sum += temp;
        }
        return sum;
    }

    public double mean() {
        // find the mean value of elements in the array
        if (temperatureSeries.length % 2 == 0) {
            return (temperatureSeries[(temperatureSeries.length - 1) / 2]
                    + temperatureSeries[(temperatureSeries.length - 1) / 2
                    + 1]) / 2;
        } else {
            return temperatureSeries[(temperatureSeries.length - 1) / 2];
        }
    }
}
