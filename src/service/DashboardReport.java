package service;

import airQuality.Dashboard;
import airQuality.Location;
import airQuality.Sensor;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DashboardReport {
    Dashboard dashboard;

    public DashboardReport(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public int getNumberOfLocations(Dashboard dashboard) {
        Stream<Location> locations = dashboard.getLocations().stream();
        return (int) locations.count();
    }

    public int getNumberOfSensors(Dashboard dashboard) {
        Stream<ArrayList<Sensor>> sensors = dashboard.getSensors().stream();
        return sensors.mapToInt(ArrayList::size).sum();
    }

    public ArrayList<Float> getLocationSortedByAQI(Dashboard dashboard) {
        Stream<Location> locations = dashboard.getLocations().stream();
        return locations.map(Location::getAQI).sorted().collect(Collectors.toCollection(ArrayList::new));
    }
}
