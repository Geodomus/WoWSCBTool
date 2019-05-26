package net.clanaod.domain;

import javax.persistence.*;


@Entity
@Table(name="Days")
public class Day implements Comparable<Day>{
    public int getId() {
        return id;
    }

    @Id
    @Column(name="day_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    public void setDayNumber(byte dayNumber) {
        this.dayNumber = dayNumber;
    }

    public byte getDayNumber() {
        return dayNumber;
    }

    @Column
    private byte dayNumber;
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

    public int compareTo(Day o) {
        return getDayNumber() - o.getDayNumber();
    }

    @Override
    public String toString() {
        return getWeekday();
    }
}
