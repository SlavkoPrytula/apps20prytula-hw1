package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * This is the class used to perform different
 * calculations and transformations with arrays
 * and its values
 *
 * @author Yaroslav Prytula
 * @version 1.0
 */
public class TemperatureSeriesAnalysis {
    // define locals
    private double[] temperatureSeries;
    private int index;
    private final int lowerBound = -273;

    /**
     * constructor with parameters
     *
     * @param temperatureSeries - array of temperatures
     */
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        // constructor with parameters
        this.temperatureSeries = temperatureSeries;
        this.index = temperatureSeries.length;
    }

    public TemperatureSeriesAnalysis() {
        // default constructor
        this.temperatureSeries = new double[0];
        this.index = 0;
    }

    /**
     * vget average temperature
     *
     * @return average
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public double average() throws IllegalArgumentException {
        // get average temperature
        throwException();
        int size = temperatureSeries.length;
        double sum = sum();
        return sum / size;
    }

    /**
     * get the deviation of the temperature
     *
     * @return deviation
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public double deviation() throws IllegalArgumentException {
        // get the deviation of the temperature
        throwException();
        double deviation;
        double mean = average();
        double summation = 0;
        for (double temp : temperatureSeries) {
            summation += (temp - mean) * (temp - mean);
        }
        deviation = Math.sqrt(summation / temperatureSeries.length);
        return deviation;
    }

    /**
     * find the minimum value
     *
     * @return min
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public double min() throws IllegalArgumentException {
        // find the minimum value
        throwException();
        double min = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    /**
     * find the maximum value
     *
     * @return max
     * @throws IllegalArgumentException IllegalArgumentException
     */
    public double max() throws IllegalArgumentException {
        // find the maximum value
        throwException();
        double max = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    /**
     * find the closest to zero temperature
     *
     * @return closest value to zero
     */
    public double findTempClosestToZero() {
        // find the closest to zero temperature
        return findTempClosestToValue(0);
    }

    /**
     * find the closest to a given value temperature
     *
     * @return closest value to a value
     */
    public double findTempClosestToValue(double tempValue)
        // find the closest to a given value temperature
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

    /**
     * find such elements that are smaller than the given value
     *
     * @param tempValue tempValue
     * @return array of elements smaller then value
     */
    public double[] findTempsLessThen(double tempValue) {
        // find such elements that are smaller than the given value
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

    /**
     * find such elements that are greater than the given value
     *
     * @param tempValue tempValue
     * @return array of elements greater then value
     */
    public double[] findTempsGreaterThen(double tempValue) {
        // find such elements that are greater than the given value
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

    /**
     * returns an immutable instance of a class
     *
     * @return summaryStatistics
     */
    public TempSummaryStatistics summaryStatistics() {
        throwException();
        // returns an immutable instance of a class
        return TempSummaryStatistics.createNewInstance(average(),
                deviation(),
                min(),
                max());
    }

    /**
     * add new temperatures
     *
     * @param temps temps
     * @return length of new array
     */
    public int addTemps(double[] temps) {
        // add new temperatures
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

    /**
     * check for correct bounds
     *
     * @param temps temps
     * @return true / false
     */
    public boolean checkBounds(double[] temps) {
        // check for correct bounds
        for (double temp : temps) {
            if (temp < lowerBound) {
                return false;
            }
        }
        return true;
    }

    public void throwException() {
        // throws exception if the list is empty
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void sortTemps() {
        // sort array
        Arrays.sort(temperatureSeries);
    }

    /**
     * find the total sum of elements in the array
     *
     * @return sum
     */
    public double sum() {
        // find the total sum of elements in the array
        double sum = 0.0;
        for (double temp: temperatureSeries) {
            sum += temp;
        }
        return sum;
    }

    /**
     * find the mean value of elements in the array
     *
     * @return mean
     */
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
