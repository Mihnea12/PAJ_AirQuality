package airQuality;

import java.util.ArrayList;

public class COSensor extends AbstractSensor{
    public COSensor(float currentValue, String timeStamp, ArrayList<Double> last12Values) {
        super(currentValue, timeStamp, last12Values);
    }

    @Override
    public String toString() {
        return "COSensor{" + super.toString() + "}";
    }

    @Override
    public float getValue() {
        return currentValue / 4;
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
