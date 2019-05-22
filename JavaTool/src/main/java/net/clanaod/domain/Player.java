package net.clanaod.domain;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Players")
public class Player {

    @Id
    @Column(name="player_Name")
    private String playerName;
    @Column(name="player_Note")
    private String playerNote;

    @ManyToMany(targetEntity = Ship.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "Player_has_Ships",
            joinColumns = { @JoinColumn(name = "Players_player_Name") },
            inverseJoinColumns = { @JoinColumn(name = "Ships_ship_Name") })
    private List<Ship> ships;

    public Player(String playerName, String playerNote) {
        setPlayerName(playerName);
        setPlayerNote(playerNote);
        this.ships = new ArrayList<Ship>();
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

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void addShip(Ship ship){
        this.ships.add(ship);
    }

    @Override
    public String toString() {
        return getPlayerName();
    }
}
