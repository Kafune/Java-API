package sensor;

public class Sensor {

    private final long id;
    private final String name;

    public Sensor(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}