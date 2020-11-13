package ua.edu.ucu.tempseries;

// make class final to make it immutable
public final class TempSummaryStatistics {
    // define immutable variables
    private final double avrTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    /**
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
     *
     * @return avrTemp
     */
    // local methods
    public double getAvrTemp() {
        return avrTemp;
    }

    /**
     *
     * @return devTemp
     */
    public double getDevTemp() {
        return devTemp;
    }

    /**
     *
     * @return minTemp
     */
    public double getMinTemp() {
        return minTemp;
    }

    /**
     *
     * @return maxTemp
     */
    public double getMaxTemp() {
        return maxTemp;
    }

    /**
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

