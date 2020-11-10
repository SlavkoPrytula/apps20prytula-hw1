package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;

public class TemperatureSeriesAnalysisTest {

    //  --------------------- FOR ONE ELEMENT LIST ---------------------

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call tested method
        double actualResult = seriesAnalysis.average();
        double expResult = -1.0;

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call tested method
        double actualResult = seriesAnalysis.min();
        double expResult = -1.0;

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Ignore
    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testClosestToZeroWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testClosestToValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(19.95);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testLessThenWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);
        System.out.println(Arrays.toString(actualResult));

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testGreaterThenWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);
        System.out.println(Arrays.toString(actualResult));

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testAddTempsWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        double[] newTemperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 5;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(newTemperatureSeries);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        String expResult = "Average: -1.0\n" +
                            "Deviation: 0.0\n" +
                            "Min: -1.0\n" +
                            "Max: -1.0";

        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        tryModification(actualResult.setAvrTemp(), actualResult.getDevTemp(), actualResult.getMinTemp(), actualResult.getMaxTemp());
        System.out.println(actualResult);

        // compare expected result with actual result
        assertEquals(expResult, actualResult.toString());
    }



    //  --------------------- FOR EMPTY LIST ---------------------

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call function
        seriesAnalysis.average();
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call function
        seriesAnalysis.deviation();
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call function
        seriesAnalysis.min();
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call function
        seriesAnalysis.max();
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testClosestToZeroWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call function
        seriesAnalysis.findTempClosestToZero();
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void closestToValueWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call function
        seriesAnalysis.findTempClosestToValue(0);
    }

    @Ignore
    @Test
    public void testLessThenWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testGreaterThenWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testAddTempsWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        double[] newTemperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 4;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(newTemperatureSeries);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // call tested method
        seriesAnalysis.summaryStatistics();
    }



    //  --------------------- FOR MANY ELEMENTS IN THE LIST ---------------------


    @Ignore
    @Test
    public void testAverage() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 8.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Ignore
    @Test
    public void testDeviation() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 12.170312239215558;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testMin() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -7.5;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testMax() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 20.4;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testClosestToZero() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.1;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testClosestToValue() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 20.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(19.95);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testLessThen() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-7.5, 0.1, -1.0, 0.9};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testGreaterThen() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {15.3, 10.9, 20.4, 19.9, 20.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testAddTemps() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        double[] newTemperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 14;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(newTemperatureSeries);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Ignore
    @Test
    public void testSummaryStatistics() {
        // setup input data and expected result
        double[] temperatureSeries = {-7.5, 0.1, -1.0, 1.0, 0.9, 15.3, 10.9, 20.4, 19.9, 20.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        String expResult = "Average: 8.0\n" +
                            "Deviation: 12.170312239215558\n" +
                            "Min: -7.5\n" +
                            "Max: 20.4";

        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        tryModification(actualResult.setAvrTemp(), actualResult.getDevTemp(), actualResult.getMinTemp(), actualResult.getMaxTemp());
        System.out.println(actualResult);

        // compare expected result with actual result
        assertEquals(expResult, actualResult.toString());
    }

    private static void tryModification(double avr, double dev, double min, double max) {
        avr = 100;
        dev = 100;
        min = 100;
        max = 100;
    }
}
