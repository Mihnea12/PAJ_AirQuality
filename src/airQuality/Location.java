package airQuality;

import java.util.ArrayList;

public class Location implements Runnable {

    private String name;
    private ArrayList<Sensor> sensors;
    private CommonResource semaphore;
    private float AQI;

    public float getAQI() {
        return AQI;
    }

    public void setAQI(float AQI) {
        this.AQI = AQI;
    }

    public CommonResource getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(CommonResource semaphore) {
        this.semaphore = semaphore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<Sensor> sensors) {
        this.sensors = sensors;
    }

    public Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                '}';
    }
    
    @Override
    public void run() {
        if(semaphore.getSemaphore() > 0) {
            semaphore.setSemaphore(semaphore.getSemaphore()-1);
            calculateAQI();
            semaphore.setSemaphore(semaphore.getSemaphore()+1);
        }
    }

    private void calculateAQI() {
        /* This only for demo, not a correct formula */
        for (Sensor sensor:
              sensors) {
            if(sensor instanceof COSensor) {
                this.AQI += sensor.getValue();
            } else {
                if (sensor instanceof CO2Sensor) {
                    this.AQI += sensor.getValue();
                } else {
                    if (sensor instanceof PM10) {
                        this.AQI += sensor.getValue();
                    } else {
                        if (sensor instanceof PM25) {
                            this.AQI += sensor.getValue();
                        }
                    }
                }
            }

        }
        this.AQI /= 4;
    }
}
