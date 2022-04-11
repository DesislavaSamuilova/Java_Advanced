package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<groomingSalon.Pet>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Pet> getPet() {
        return data;
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (groomingSalon.Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        String toAppend = "The grooming salon has the following clients:";
        out.append(toAppend)
                .append(System.lineSeparator());
        for (Pet pet : this.data) {
            out.append(pet.getName()).append(" ")
                    .append(pet.getOwner())
                    .append(System.lineSeparator());

        }
        return out.toString().trim();


    }
}
