package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    public List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.roster = new ArrayList<Person>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void add(Person person) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(e -> e.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        for (hotel.Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out = new StringBuilder(
                String.format("The people in the hotel " + getName() + " are:" +
                        System.lineSeparator()));

        for (Person p : this.roster) {
            out.append(p)
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}

