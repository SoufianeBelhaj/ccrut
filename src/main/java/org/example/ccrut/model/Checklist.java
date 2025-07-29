package org.example.ccrut.model;

import jakarta.persistence.*;
import org.example.ccrut.enums.TypeChecklist;

import java.util.List;

@Entity
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChecklists;

    private String description;

    private String nom;

    @Enumerated(EnumType.STRING) // Use string values like "A_VENIR", "REALISE" in DB
    @Column(nullable = false)
    private TypeChecklist type;

    @Column(nullable = true)
    private String assignedTo;



    @Column(nullable = false)
    private boolean sentToManager = false;

    @Column(nullable = false)
    private boolean archived = false;

    @Column(nullable = false)
    private Integer frequence = 1;
    @OneToMany(mappedBy = "checklist")
    private List<Associer> associations;
    // Getters and Setters

    public Integer getIdChecklists() {
        return idChecklists;
    }

    public void setIdChecklists(Integer idChecklists) {
        this.idChecklists = idChecklists;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeChecklist getType() {
        return type;
    }

    public void setType(TypeChecklist type) {
        this.type = type;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isSentToManager() {
        return sentToManager;
    }

    public void setSentToManager(boolean sentToManager) {
        this.sentToManager = sentToManager;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Integer getFrequence() {
        return frequence;
    }

    public void setFrequence(Integer frequence) {
        this.frequence = frequence;
    }
}
