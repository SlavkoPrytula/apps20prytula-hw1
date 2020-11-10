package ua.edu.ucu.tempseries;


public final class TempSummaryStatistics {
    private final double avrTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(double avrTemp, double devTemp, double minTemp, double maxTemp) {
        this.avrTemp = avrTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public static TempSummaryStatistics createNewInstance(double avrTemp, double devTemp, double minTemp, double maxTemp) {
        return new TempSummaryStatistics(avrTemp, devTemp, minTemp, maxTemp);
    }

    public double setAvrTemp() {
        return avrTemp + 10;
    }

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
        return "Average: " + getAvrTemp() + "\n" +
                "Deviation: " + getDevTemp() + "\n" +
                "Min: " +  getMinTemp() + "\n" +
                "Max: " + getMaxTemp();
    }
}

