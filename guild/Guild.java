package guild;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guild {
    private Map<String, Player> players;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        players = new LinkedHashMap<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRoster(Map<String, Player> roster) {
        this.players = roster;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, Player> getRoster() {
        return players;
    }

    public int count() {
        return players.size();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.players.size()) {
            this.players.putIfAbsent(player.getName(), player);
            this.capacity--;
        }
    }

    public boolean removePlayer(String name) {
        return players.remove(name) != null;
    }

    public void promotePlayer(String name) {
        Player player = this.players.get(name);
        if (player != null) {
            player.setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        Player player = this.players.get(name);
        if (player != null) {
            player.setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<String> names = new ArrayList<>();
        for (var entry : players.entrySet()) {
            Player player = entry.getValue();
            if (player.getClazz().equals(clazz)) {
                names.add(entry.getKey());
            }
        }
        Player[] removedPlayers = new Player[names.size()];
        for (int i = 0; i < names.size(); i++) {
            Player player = this.players.remove(names.get(i));
            removedPlayers[i] = player;
        }
        return removedPlayers;
    }


    public String report() {
        System.out.println();
        StringBuilder output;
        output = new StringBuilder(
                String.format("Players in the guild: " + name + ":" +
                        System.lineSeparator()));

        for (Player p : players.values()) {
            output.append(p)
                    .append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}

