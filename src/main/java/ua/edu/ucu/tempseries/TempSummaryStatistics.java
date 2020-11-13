package ua.edu.ucu.tempseries;

// make class final to make it immutable
public final class TempSummaryStatistics {
    // define immutable variables
    private final double avrTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(double avrTemp, double devTemp,
                                 double minTemp, double maxTemp) {
        this.avrTemp = avrTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public static TempSummaryStatistics createNewInstance(double avrTemp,
                                                          double devTemp,
                                                          double minTemp,
                                                          double maxTemp) {
        return new TempSummaryStatistics(avrTemp, devTemp, minTemp, maxTemp);
    }

    // local methods
    public double getAvrTemp() {
        return avrTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    @Override
    public String toString() {
        // represent statistics
        return "Average: " + getAvrTemp() + "\n"
                + "Deviation: " + getDevTemp() + "\n"
                + "Min: " +  getMinTemp() + "\n"
                + "Max: " + getMaxTemp();
    }
}

