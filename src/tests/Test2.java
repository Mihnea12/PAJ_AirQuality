package tests;

import airQuality.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Test2 {
    @Test
    public void test() {
        Location location = new Location("Iasi");
        Location location1 = new Location("Bucuresti");

        ArrayList<Location> arrayLocation = new ArrayList<Location>(Arrays.asList(location1, location));

        Dashboard dashboard = new Dashboard(arrayLocation);
        System.out.println(dashboard.toString());
        assertEquals(2, dashboard.getLocations().size());
    }

}
