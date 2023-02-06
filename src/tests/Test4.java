package tests;

import airQuality.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Test4 {
    @Test
    public void test() throws InterruptedException {
        Location location = new Location("Iasi");
        Location location1 = new Location("Bucuresti");

        CO2Sensor co2Sensor = new CO2Sensor(10, "12:40", new ArrayList<Double>(Arrays.asList(10.0, 20.0 ,30.0 ,40.0 ,50.0)));
        COSensor coSensor = new COSensor(22, "14:40", new ArrayList<Double>(Arrays.asList(11.0, 21.0 ,31.0 ,41.0 ,51.0)));

        PM25 pm25 = new PM25(25, "16:40", new ArrayList<Double>(Arrays.asList(5.0, 20.5 ,35.0 ,422.0 ,51.0)));
        PM10 pm10 = new PM10(23, "22:40", new ArrayList<Double>(Arrays.asList(13.0, 21.0 ,111.0 ,22.0 ,56.0)));

        ArrayList<Location> arrayLocation = new ArrayList<Location>(Arrays.asList(location1, location));

        ArrayList<Sensor> sensors = new ArrayList<Sensor>(Arrays.asList(co2Sensor, co2Sensor));
        ArrayList<Sensor> sensors1 = new ArrayList<Sensor>(Arrays.asList(pm25, pm10));
        location.setSensors(sensors);
        location1.setSensors(sensors1);

        Dashboard dashboard = new Dashboard(arrayLocation);
        System.out.println(dashboard.toString());

        dashboard.getSensorsValueFromLocation("Bucuresti");
    }

}
