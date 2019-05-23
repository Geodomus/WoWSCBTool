package net.clanaod.domain;

import javax.persistence.*;

@Entity
@Table(name="Ships")
public class Ship implements Comparable<Ship>{

    @Id
    @Column(name="ship_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="ship_Name")
    private String shipName;
    @Column(name="ship_Type")
    private String shipType;

    public Ship(String shipName, String shipType) {
        setShipName(shipName);
        setShipType(shipType);
    }
    public Ship(){}
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    @Override
    public String toString() {
        return this.getShipName();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ship){
            return ((Ship) obj).id ==this.id;
        } else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        String str = shipName + "("+shipType+")";
        return str.hashCode();
    }

    public int compareTo(Ship o) {
        if (this.shipType.equals("DD")) {
            if (o.shipType.equals("DD")) {
                return this.shipName.compareTo((o.shipName));
            } else {
                return 1;
            }
        } else if (this.shipType.equals("CA") || this.shipType.equals("CL")) {
            if (o.shipType.equals("DD")) {
                return -1;
            } else if (o.shipType.equals("CA") || o.shipType.equals("CL")) {
                return this.shipName.compareTo((o.shipName));
            } else {
                return 1;
            }
        } else if (this.shipType.equals("BB")) {
            if (o.shipType.equals("CV")) {
                return 1;
            } else if (o.shipType.equals("BB")) {
                return this.shipName.compareTo((o.shipName));
            } else {
                return -1;
            }
        } else {
            if (o.shipType.equals("CV")) {
                return this.shipName.compareTo((o.shipName));
            } else {
                return -1;
            }
        }
    }
}
