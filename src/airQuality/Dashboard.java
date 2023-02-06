package airQuality;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard implements Runnable {
    private ArrayList<Location> locations = new ArrayList<Location>();
    private ArrayList<ArrayList<Sensor>> sensors = new ArrayList<ArrayList<Sensor>>();
    private HashMap<Location, ArrayList<Sensor>> sensorsLocation = new HashMap<Location, ArrayList<Sensor>>();
    private CommonResource semaphore;

    public CommonResource getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(CommonResource semaphore) {
        this.semaphore = semaphore;
    }

    public Dashboard(ArrayList<Location> locations) {
        this.locations = locations;
        for(int i = 0; i < locations.size(); i++) {
            sensorsLocation.put(this.locations.get(i), locations.get(i).getSensors());
        }

    }
    public void addArraySensor(ArrayList<Sensor> sensors) {
        this.sensors.add(sensors);
    }

    public ArrayList<ArrayList<Sensor>> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<ArrayList<Sensor>> sensors) {
        this.sensors = sensors;
    }

    public HashMap<Location, ArrayList<Sensor>> getSensorsLocation() {
        return sensorsLocation;
    }

    public void setSensorsLocation(HashMap<Location, ArrayList<Sensor>> sensorsLocation) {
        this.sensorsLocation = sensorsLocation;
    }

    @Override
    public String toString() {
        return "airQuality.Dashboard{" +
                "sensorsLocation=" + sensorsLocation +
                '}';
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
    public void getSensorsValueFromLocation(String name) {
        for (Location location:
                locations) {
            if (location.getName().equals(name)) {
                for (Sensor sensor:
                        location.getSensors()) {
                    System.out.println(sensor.toString());
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (semaphore.getSemaphore() != 2) {}
        for (Location location:
             this.locations) {
            System.out.println("AQI " + location.getName() + " = " + location.getAQI());
        }
    }


}
