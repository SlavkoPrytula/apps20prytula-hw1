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
//        assertEquals(expResult, actualResult, 0.00001);
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
//        assertEquals(expResult, actualResult, 0.00001);
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



    //  --------------------- FOR EMPTY LIST ---------------------

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
//        double actualResult = seriesAnalysis.average();
//        Exception expResult = new IllegalArgumentException();
//
//        assertEquals(expResult, actualResult);
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
        double[] expResult = {15.3, 10.9, 20.4, 19.9, 20.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);

        // compare expected result with actual result
//        assertEquals(expResult, actualResult, 0.00001);
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
//        assertEquals(expResult, actualResult, 0.00001);
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



}
