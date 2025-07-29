package org.example.ccrut.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Associer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    private Checklist checklist;

    @ManyToOne
    @JoinColumn(name = "surveillance_id")
    private Surveillance surveillance;

    private LocalDate date;

    // Getters, setters, constructeurs
}
