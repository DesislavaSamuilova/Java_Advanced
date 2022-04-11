package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    public List<Pet> data;
    public int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<Pet>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Pet> getData() {
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
        for (vetClinic.Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet(){
        return this.data.stream().max(Comparator.comparing(Pet::getAge))
                .orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder out = new StringBuilder();
        out.append("The clinic has the following patients:").append(System.lineSeparator());
        for (vetClinic.Pet pet : this.data) {
            out.append(pet.getName()).append(" ")
                    .append(pet.getOwner())
                    .append(System.lineSeparator());

        }
        return out.toString().trim();
    }
}
