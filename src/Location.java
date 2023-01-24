import java.util.ArrayList;

public class Location {

    private String name;
    private ArrayList<Sensor> sensorList = new ArrayList<Sensor>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(ArrayList<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
}
