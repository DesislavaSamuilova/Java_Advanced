package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.data = new ArrayList<Present>();
        this.color = color;
        this.capacity = capacity;
    }


    public List<Present> getData() {
        return data;
    }

    public String getColor() {
        return this.color;
    }

    public double getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : this.data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }
            return false;
        }

        public Present heaviestPresent () {
            Present newPresent = null;
            for (Present present : this.data) {
                if (newPresent == null ||
                        present.getWeight() > newPresent.getWeight()) {
                    newPresent = present;
                }
            }
            return newPresent;
        }

        public Present getPresent (String name){
            Present newPresent = null;
            for (Present present : this.data) {
                if (present.getName().equals(name)) {
                    return present;
                }
            }
            return newPresent;
        }


        public String report () {
            StringBuilder out = new StringBuilder(String.format(this.getColor() + " bag contains" + "%n"));
            for (Present present : this.data) {
                out.append(present.toString())
                        .append(System.lineSeparator());
            }
            return out.toString().trim();
        }

    }
