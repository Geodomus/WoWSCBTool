package net.clanaod.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name="Player_plays_Day")
public class PlayerPlaysDay implements Serializable {
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
}
