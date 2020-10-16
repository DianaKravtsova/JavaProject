package by.kravts.concerts_affiche.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cities {
    public Cities(){}

    @Id
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Cities(String city){
        this.city = city;
    }
}
