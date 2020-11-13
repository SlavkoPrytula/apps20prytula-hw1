package ua.edu.ucu.tempseries;

/**
 * Immutable instance of a class.
 *
 * @author Yaroslav Prytula
 * @version 1.0
 */
// make class final to make it immutable
public final class TempSummaryStatistics {
    // define immutable variables
    private final double avrTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    /**
     * Constructor for statistics class.
     *
     * @param avrTemp avrTemp
     * @param devTemp devTemp
     * @param minTemp minTemp
     * @param maxTemp maxTemp
     */
    public TempSummaryStatistics(double avrTemp, double devTemp,
                                 double minTemp, double maxTemp) {
        this.avrTemp = avrTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    /**
     * Returns new instance of a class.
     *
     * @param avrTemp avrTemp
     * @param devTemp devTemp
     * @param minTemp minTemp
     * @param maxTemp maxTemp
     * @return TempSummaryStatistics
     */
    public static TempSummaryStatistics createNewInstance(double avrTemp,
                                                          double devTemp,
                                                          double minTemp,
                                                          double maxTemp) {
        return new TempSummaryStatistics(avrTemp, devTemp, minTemp, maxTemp);
    }

    /**
     * get average temperature.
     *
     * @return avrTemp
     */
    // local methods
    public double getAvrTemp() {
        return avrTemp;
    }

    /**
     * get temperature deviation.
     *
     * @return devTemp
     */
    public double getDevTemp() {
        return devTemp;
    }

    /**
     * get min temperature.
     *
     * @return minTemp
     */
    public double getMinTemp() {
        return minTemp;
    }

    /**
     * get max temperature.
     *
     * @return maxTemp
     */
    public double getMaxTemp() {
        return maxTemp;
    }

    /**
     * represent class as a string.
     *
     * @return String
     */
    @Override
    public String toString() {
        // represent statistics
        return "Average: " + getAvrTemp() + "\n"
                + "Deviation: " + getDevTemp() + "\n"
                + "Min: " +  getMinTemp() + "\n"
                + "Max: " + getMaxTemp();
    }
}

