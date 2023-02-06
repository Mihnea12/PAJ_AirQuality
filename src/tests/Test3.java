package tests;

import airQuality.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Test3 {
    @Test
    public void test() throws InterruptedException {
        Location location = new Location("Iasi");
        Location location1 = new Location("Bucuresti");
        CommonResource semaphore = new CommonResource(2);

        CO2Sensor co2Sensor = new CO2Sensor(10, "12:40", new ArrayList<Double>(Arrays.asList(10.0, 20.0 ,30.0 ,40.0 ,50.0)));
        COSensor coSensor = new COSensor(22, "14:40", new ArrayList<Double>(Arrays.asList(11.0, 21.0 ,31.0 ,41.0 ,51.0)));

        ArrayList<Location> arrayLocation = new ArrayList<Location>(Arrays.asList(location1, location));

        ArrayList<Sensor> sensors = new ArrayList<Sensor>(Arrays.asList(co2Sensor, co2Sensor));
        location.setSensors(sensors);
        location1.setSensors(sensors);

        Dashboard dashboard = new Dashboard(arrayLocation);
        System.out.println(dashboard.toString());
        location.setSemaphore(semaphore);
        location1.setSemaphore(semaphore);
        dashboard.setSemaphore(semaphore);

        new Thread(location, "location").start();
        new Thread(location1, "location1").start();
        Thread dash = new Thread(dashboard, "dashboard");
        dash.start();
        dash.join();

        HashMap<Location, Float> result = new HashMap<Location, Float>();
        result.put(location, location.getAQI());
        result.put(location1, location1.getAQI());
        System.out.println(result.toString());
        assertEquals(2, result.size());

    }

}
