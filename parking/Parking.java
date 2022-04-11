package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<Car>();
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
            this.capacity--;
        }
    }
    public boolean remove(String manufacturer, String model) {
        Predicate<Car> doYouFound = car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model);
        boolean isRemove = this.data.removeIf(doYouFound);
        if (isRemove) {
            this.capacity++;
        }
        return isRemove;
    }
    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear))
                .orElse(null);
    }
    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(c -> c.getManufacturer().equals(manufacturer)
                && c.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
        StringBuilder out = new StringBuilder(String.format("The cars are parked in " + type + ":%n"));
        this.data.forEach(c -> out.append(c)
                .append(System.lineSeparator()));
        return out.toString().trim();
    }
}
