package by.kravts.concerts_affiche.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genres {
    public Genres(){}

    public Genres(String genre){
        this.genre = genre;
    }

    @Id
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
