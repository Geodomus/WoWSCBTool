package net.clanaod.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name="Player_plays_Day")
public class PlayerPlaysDay implements Serializable, Comparable<PlayerPlaysDay>{
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Time getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(Time timefrom) {
        this.timefrom = timefrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }

    @Id
    @ManyToOne
    @JoinColumn
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn
    private Day day;

    @Basic
    private Time timefrom;

    @Basic
    private Time timeTo;

    @Override
    public int hashCode() {
        return player.hashCode() + day.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PlayerPlaysDay){
            PlayerPlaysDay o1= (PlayerPlaysDay)obj;
            return o1.day.equals(day) && o1.player.equals((player));
        }else {
            return false;
        }
    }

    public int compareTo(PlayerPlaysDay o) {
        return player.compareTo(o.getPlayer());
    }
}
