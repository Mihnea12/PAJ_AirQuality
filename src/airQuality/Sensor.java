package airQuality;

public interface Sensor {
    public float getValue();
    public String getTimeStamp();
    public void setValue(float value);
    public void setTimeStamp(String timeStamp);
}
