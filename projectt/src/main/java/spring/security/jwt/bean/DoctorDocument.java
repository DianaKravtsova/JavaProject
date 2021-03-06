package spring.security.jwt.bean;

import lombok.Data;
import spring.security.jwt.bean.dto.DoctorSpec;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "doctor_document")
@Data
public class DoctorDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 2, max = 16, message = "name from 2 to 16")
    @NotNull(message = "Can not be null")
    private String name;

    @Size(min = 4, max = 16, message = "surname from 4 to 16")
    @NotNull(message = "Can not be null")
    private String surname;

    @Size(min = 4, max = 16, message = "fathername from 4 to 16")
    @NotNull(message = "Can not be null")
    private String fathername;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private User doctor;


    @ElementCollection(targetClass = DoctorSpec.class , fetch = FetchType.EAGER)
    @CollectionTable(name = "doctor_spec" , joinColumns = @JoinColumn(name = "doctor_id"))
    @Enumerated(EnumType.STRING)
    private Set<DoctorSpec> specs;

    public DoctorDocument(String name, String surname, String fathername, User doctor, Set<DoctorSpec> specs) {
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.doctor = doctor;
        this.specs = specs;
    }


    public DoctorDocument() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public Set<DoctorSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(Set<DoctorSpec> specs) {
        this.specs = specs;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }


}
