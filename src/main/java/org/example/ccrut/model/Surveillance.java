package org.example.ccrut.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Surveillance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSurveillance;
    private String nom;

    @OneToMany(mappedBy = "surveillance")
    private List<Associer> associations;

    public Integer getIdSurveillance() {
        return idSurveillance;
    }

    public void setIdSurveillance(Integer idSurveillance) {
        this.idSurveillance = idSurveillance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
