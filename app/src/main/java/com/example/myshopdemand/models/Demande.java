package com.example.myshopdemand.models;

import java.util.List;

public class Demande {
    private Long demandeId;
    private String title;
//    private String description;
//    private Status status;
    private boolean checked;

    public Demande() {
    }

    public Demande(Long demandeId, String title, boolean checked) {
        this.demandeId = demandeId;
        this.title = title;
        this.checked = checked;
    }

    public Long getDemandeId() {
        return demandeId;
    }

    public void setDemandeId(Long demandeId) {
        this.demandeId = demandeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
