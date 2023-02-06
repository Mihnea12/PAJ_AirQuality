package airQuality;

import java.util.ArrayList;

public class CO2Sensor extends  AbstractSensor{
    public CO2Sensor(float currentValue, String timeStamp, ArrayList<Double> last12Values) {
        super(currentValue, timeStamp, last12Values);
    }

    @Override
    public float getValue() {
        return currentValue / 2;
    }

    @Override
    public String toString() {
        return "CO2Sensor{" + super.toString() + "}";
    }

    @Override
    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public void setValue(float value) {
        this.currentValue = value;
    }

    @Override
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
