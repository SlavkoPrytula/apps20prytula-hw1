package ua.edu.ucu.tempseries;


import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    // define
    private double[] temperatureSeries;
    private int Index;

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        // constructor with parameters
        this.temperatureSeries = temperatureSeries;
        System.out.println(Arrays.toString(temperatureSeries));
        System.out.println(Arrays.toString(temperatureSeries));
        this.Index = temperatureSeries.length;
    }

    public TemperatureSeriesAnalysis() {
        // default constructor
        this.temperatureSeries = new double[0];
        this.Index = 0;
    }

    public double average() throws IllegalArgumentException {
        int size = temperatureSeries.length;
        double sum = sum();
        return sum / size;
    }

    public double deviation() throws IllegalArgumentException {
        double deviation;
        double mean = mean();
        double summation = 0;
        for (double temp : temperatureSeries) {
            summation += Math.pow( temp - mean, 2);
        }
        deviation = Math.sqrt(summation / temperatureSeries.length);
        return deviation;
    }

    public double min() throws IllegalArgumentException {
        double min = temperatureSeries[0];
        for(double temp : temperatureSeries) {
            if(temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public double max() throws IllegalArgumentException {
        double max = temperatureSeries[0];
        for(double temp : temperatureSeries) {
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) throws IllegalArgumentException {
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
        if (Math.abs(closestLeft - tempValue) < Math.abs(closestRight - tempValue)) {
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
                tempsLessThen = Arrays.copyOf(tempsLessThen, tempsLessThen.length + 1);
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
                tempsGreaterThen = Arrays.copyOf(tempsGreaterThen, tempsGreaterThen.length + 1);
                tempsGreaterThen[ind++] = temp;
            }
        }
        return tempsGreaterThen;
    }

    public TempSummaryStatistics summaryStatistics() {
        return TempSummaryStatistics.createNewInstance(average(), deviation(), min(), max());
    }

    public int addTemps(double[] temps) {
        // Assertions are removed at runtime unless you explicitly specify
        // to "enable assertions" when compiling your code
        if(!checkBounds(temps)) {
            throw new InputMismatchException();
        }
        // increase buff size
        while (temperatureSeries.length < Index + temps.length) {
            temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length * 2);
        }
        // insert new elements
        for (double temp : temps) {
            temperatureSeries[Index++] = temp;
        }
        return Index;
    }

    public boolean checkBounds(double[] temps) {
        // check for correct bounds
        for(double temp : temps) {
            if(temp < -273) {
                return false;
            }
        }
        return true;
    }
    public void sortTemps() {
        // sort array
        Arrays.sort(temperatureSeries);
    }

    public double sum() {
        // find the total sum of elements in the array
        double sum = 0.0;
        for(double temp: temperatureSeries) {
            sum += temp;
        }
        return sum;
    }

    public double mean() {
        // find the mean value of elements in the array
        if (temperatureSeries.length % 2 == 0) {
            return (temperatureSeries[(temperatureSeries.length - 1) / 2 - 1] +
                    temperatureSeries[(temperatureSeries.length - 1) / 2]) / 2;
        } else {
            return temperatureSeries[(temperatureSeries.length - 1) / 2];
        }
    }
}
