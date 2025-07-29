package org.example.ccrut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Controle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idControle;

    @Column(name = "description_controle")

    private String descriptionControle;

    public Integer getIdControle() {
        return idControle;
    }

    public void setIdControle(Integer idControle) {
        this.idControle = idControle;
    }

    public String getDescriptionControle() {
        return descriptionControle;
    }

    public void setDescriptionControle(String descriptionControle) {
        this.descriptionControle = descriptionControle;
    }
    @Column(name = "checked")
    private Integer checked = 0; // 0 pour non-coché, 1 pour coché

    @Column(name = "checklist_id") // Ajouter la colonne checklistId
    private Integer checklistId;

    public Integer getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Integer checklistId) {
        this.checklistId = checklistId;
    }

    // getters et setters
    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

}
