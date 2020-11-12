package by.kravts.concerts_affiche.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "town")
public class Town {
    @Id
    private String name_town;


    public String getName_town() {
        return name_town;
    }

    public void setName_town(String name_town) {
        this.name_town = name_town;
    }

    @Override
    public String toString() {
        return "Town{" +
                "name_town='" + name_town + '\'' +
                '}';
    }
}
