package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<Car>();
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return data;
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
            this.capacity--;
        }
    }

    public boolean buy(String manufacturer, String model) {
        Predicate<Car> foundCar = car -> car.getManufacturer().equals(manufacturer)
                && car.getModel().equals(model);
        boolean isRemove = this.data.removeIf(foundCar);
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
        StringBuilder out = new StringBuilder(String.format("The cars are in a car dealership " + name + ":%n"));
        this.data.forEach(c -> out.append(c)
                .append(System.lineSeparator()));
        return out.toString().trim();
    }
}
