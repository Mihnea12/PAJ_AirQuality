package airQuality;

import java.util.ArrayList;

public abstract class AbstractSensor implements Sensor {
    float currentValue;
    String timeStamp;
    ArrayList<Double> last12Values;

    @Override
    public String toString() {
        return "AbstractSensor{" +
                "currentValue=" + currentValue +
                ", timeStamp='" + timeStamp + '\'' +
                ", last12Values=" + last12Values +
                '}';
    }

    public AbstractSensor(float currentValue, String timeStamp, ArrayList<Double> last12Values) {
        this.currentValue = currentValue;
        this.timeStamp = timeStamp;
        this.last12Values = last12Values;
    }
}
