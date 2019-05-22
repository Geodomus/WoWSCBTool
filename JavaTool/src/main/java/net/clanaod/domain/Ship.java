package net.clanaod.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ships")
public class Ship {

    @Id
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
}
