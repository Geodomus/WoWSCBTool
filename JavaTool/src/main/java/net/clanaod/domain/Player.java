package net.clanaod.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Players")
public class Player implements Comparable<Player> {

    public int getId() {
        return id;
    }

    @Id
    @Column(name="player_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SuppressWarnings("unused")
    private int id;
    @Column(name="player_Name")
    private String playerName;
    @Column(name="player_Note")
    @Type(type="text")
    private String playerNote;

    @ManyToMany(targetEntity = Ship.class, cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
    @JoinTable(name = "Player_has_Ships",
            joinColumns = { @JoinColumn(name = "player_id") },
            inverseJoinColumns = { @JoinColumn(name = "ship_id") })
    private Set<Ship> ships;

    public Player(String playerName, String playerNote) {
        setPlayerName(playerName);
        setPlayerNote(playerNote);
        this.ships = new HashSet<Ship>();
    }
    public Player(){}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerNote() {
        return playerNote;
    }

    public void setPlayerNote(String playerNote) {
        this.playerNote = playerNote;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    public void addShip(Ship ship){
        this.ships.add(ship);
    }

    public void removeShip(Ship ship) {this.ships.remove(ship);}

    @Override
    public String toString() {
        return getPlayerName();
    }

    public int compareTo(Player p) {
        return playerName.compareTo(p.getPlayerName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return id == player.id;
    }
}
