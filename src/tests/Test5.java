package tests;

import airQuality.*;
import org.junit.Test;
import service.DashboardReport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class Test5 {
    @Test
    public void test() throws InterruptedException {
        Location location = new Location("Iasi");
        Location location1 = new Location("Bucuresti");
        Location location2 = new Location("Brasov");
        location.setAQI(10.5f);
        location1.setAQI(20.4f);
        location2.setAQI(5f);

        CO2Sensor co2Sensor = new CO2Sensor(10, "12:40", new ArrayList<Double>(Arrays.asList(10.0, 20.0 ,30.0 ,40.0 ,50.0)));
        COSensor coSensor = new COSensor(22, "14:40", new ArrayList<Double>(Arrays.asList(11.0, 21.0 ,31.0 ,41.0 ,51.0)));

        PM25 pm25 = new PM25(25, "16:40", new ArrayList<Double>(Arrays.asList(5.0, 20.5 ,35.0 ,422.0 ,51.0)));
        PM10 pm10 = new PM10(23, "22:40", new ArrayList<Double>(Arrays.asList(13.0, 21.0 ,111.0 ,22.0 ,56.0)));

        ArrayList<Location> arrayLocation = new ArrayList<Location>(Arrays.asList(location1, location, location2));

        ArrayList<Sensor> sensors = new ArrayList<Sensor>(Arrays.asList(co2Sensor, co2Sensor));
        ArrayList<Sensor> sensors1 = new ArrayList<Sensor>(Arrays.asList(pm25, pm10));
        location.setSensors(sensors);
        location1.setSensors(sensors1);

        Dashboard dashboard = new Dashboard(arrayLocation);
        System.out.println(dashboard.toString());
        dashboard.addArraySensor(sensors);
        dashboard.addArraySensor(sensors1);

        DashboardReport report = new DashboardReport(dashboard);
        assertEquals(3, report.getNumberOfLocations(dashboard));
        System.out.println(dashboard.getSensors().toString());
        assertEquals(4, report.getNumberOfSensors(dashboard));

        assertEquals(new ArrayList<Float>(Arrays.asList(5f, 10.5f, 20.4f)),report.getLocationSortedByAQI(dashboard));
    }

}
