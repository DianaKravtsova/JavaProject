package by.kravts.concerts_affiche.model;

import lombok.*;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "concert")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_concert;

    @Column(name="musician")
    private String musician;

    @ManyToOne
    @JoinColumn(name = "place")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "town")
    private Town town;

    @Column(name="date_concert")
    private LocalDate date_concert;
    @Column(name="time_concert")
    private String time_concert;


    public int getId_concert() {
        return id_concert;
    }

    public void setId_concert(int id_concert) {
        this.id_concert = id_concert;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public LocalDate getDate_concert() {
        return date_concert;
    }

    public void setDate_concert(LocalDate date_concert) {
        this.date_concert = date_concert;
    }

    public String getTime_concert() {
        return time_concert;
    }

    public void setTime_concert(String time_concert) {
        this.time_concert = time_concert;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "id_concert=" + id_concert +
                ", musician='" + musician + '\'' +
                ", place='" + place + '\'' +
                ", town='" + town + '\'' +
                ", date_concert=" + date_concert +
                ", time_concert='" + time_concert + '\'' +
                '}';
    }
}
