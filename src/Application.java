import java.util.ArrayList;

public class Application {
    private ArrayList<Location> locations;

    Application(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public static void main(String[] args) {

    }
}
