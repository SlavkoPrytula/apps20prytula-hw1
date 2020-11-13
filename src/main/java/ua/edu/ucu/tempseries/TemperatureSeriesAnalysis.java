package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * This is the class used to perform different
 * calculations and transformations with arrays
 * and its values.
 *
 * @author Yaroslav Prytula
 * @version 1.0
 */
public class TemperatureSeriesAnalysis {
    // define locals
    static final int LOWER_BOUND = -273;
    private double[] resultTemps = new double[0];
    private double[] temperatureSeries;
    private int index;

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        // constructor with parameters
        this.temperatureSeries = temperatureSeries;
        checkBounds(temperatureSeries);
        this.index = temperatureSeries.length;
    }

    public TemperatureSeriesAnalysis() {
        // default constructor
        this.temperatureSeries = new double[0];
        this.index = 0;
    }

    public double average() throws IllegalArgumentException {
        // get average temperature
        throwException();
        int size = temperatureSeries.length;
        double sum = sum();
        return sum / size;
    }

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

    public double findTempClosestToZero() {
        // find the closest to zero temperature
        return findTempClosestToValue(0);
    }

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

    public int getBuff(int indicator, double tempValue) {
        int addBuff = 0;
        if (indicator == 1) {
            for (double temp : temperatureSeries) {
                if (temp > tempValue) {
                    addBuff++;
                }
            }
        } else {
            for (double temp : temperatureSeries) {
                if (temp < tempValue) {
                    addBuff++;
                }
            }
        }
        return addBuff;
    }

    public double[] findTempsLessThen(double tempValue) {
        // find such elements that are smaller than the given value
        int ind = 0;
        resultTemps = Arrays.copyOf(resultTemps,
                resultTemps.length + getBuff(-1, tempValue));
        for (double temp : temperatureSeries) {
            if (temp < tempValue) {
                resultTemps[ind++] = temp;
            }
        }
        return resultTemps;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        // find such elements that are greater than the given value
        int ind = 0;
        resultTemps = Arrays.copyOf(resultTemps,
                resultTemps.length + getBuff(1, tempValue));
        for (double temp : temperatureSeries) {
            if (temp > tempValue) {
                resultTemps[ind++] = temp;
            }
        }
        return resultTemps;
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
        // add new temperatures
        int buffCounter = temperatureSeries.length;
        if (!checkBounds(temps)) {
            throw new InputMismatchException();
        }

        // reduce extra amount
        if (temperatureSeries.length == 0) {
            buffCounter++;
        }

        // increase buff size
        while (buffCounter <= index + temps.length) {
            buffCounter *= 2;
        }

        // copy to new array with new buff size
        temperatureSeries = Arrays.copyOf(temperatureSeries,
                temperatureSeries.length + buffCounter);
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
        // throws exception if the list is empty
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
