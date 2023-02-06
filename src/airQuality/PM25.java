package airQuality;

import java.util.ArrayList;

public class PM25 extends  AbstractSensor{
    public PM25(float currentValue, String timeStamp, ArrayList<Double> last12Values) {
        super(currentValue, timeStamp, last12Values);
    }

    @Override
    public float getValue() {
        return currentValue / 25;
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
