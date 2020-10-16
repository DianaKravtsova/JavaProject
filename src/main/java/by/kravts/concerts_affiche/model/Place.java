package by.kravts.concerts_affiche.model;

import javax.persistence.*;

@Entity
public class Place {
    public Place(){}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int placeID;

    private String name;
    @OneToOne
    private Cities city;
    private String address;

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
