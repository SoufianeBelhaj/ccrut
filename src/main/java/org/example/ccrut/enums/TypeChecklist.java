package org.example.ccrut.enums;

public enum TypeChecklist {
    A_VENIR("À venir"),
    REALISE("Réalisé");

    private final String label;

    TypeChecklist(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
