package net.clanaod.domain;

import javax.persistence.*;


@Entity
@Table(name="Days")
public class Day {
    public int getId() {
        return id;
    }

    @Id
    @Column(name="player_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    private String weekday;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Day){
            int ido = ((Day) obj).getId();
            return ido == id;
        } else {
            return false;
        }
    }
}
