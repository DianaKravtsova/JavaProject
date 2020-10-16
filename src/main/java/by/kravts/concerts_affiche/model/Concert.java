package by.kravts.concerts_affiche.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Concert {
    public Concert(){}

    public int getConcertID() {
        return concertID;
    }

    public void setConcertID(int concertID) {
        this.concertID = concertID;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public Place getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Place placeID) {
        this.placeID = placeID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int concertID;

    private String speaker;
    @OneToOne
    private Place placeID;
    private Date date;
    private String time;

    @OneToOne
    private Genres genre;
    private  String price;
    private String description;
}
