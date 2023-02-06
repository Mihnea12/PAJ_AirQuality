package tests;

import airQuality.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Test1 {
    @Test
    public void test() {
        Location location = new Location("Bucuresti");
        CO2Sensor co2Sensor = new CO2Sensor(10, "12:40", new ArrayList<Double>(Arrays.asList(10.0, 20.0 ,30.0 ,40.0 ,50.0)));
        COSensor coSensor = new COSensor(22, "14:40", new ArrayList<Double>(Arrays.asList(11.0, 21.0 ,31.0 ,41.0 ,51.0)));

        ArrayList<Location> arrayLocation = new ArrayList<Location>();
        arrayLocation.add(location);

        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
        sensors.add(co2Sensor);
        sensors.add(coSensor);
        location.setSensors(sensors);

        Dashboard dashboard = new Dashboard(arrayLocation);
        System.out.println(dashboard.toString());
        assertEquals(2,dashboard.getSensorsLocation().get(location).size());
        assertEquals("Bucuresti", location.getName());
    }

}
