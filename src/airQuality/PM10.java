package airQuality;

import java.util.ArrayList;

public class PM10 extends AbstractSensor{
    public PM10(float currentValue, String timeStamp, ArrayList<Double> last12Values) {
        super(currentValue, timeStamp, last12Values);
    }

    @Override
    public float getValue() {
        return currentValue / 10;
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
