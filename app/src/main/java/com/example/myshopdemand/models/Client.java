package com.example.myshopdemand.models;

import java.util.ArrayList;

public class Client {

    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private ArrayList<Demande> demandes;




    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(ArrayList<Demande> demandes) {
        this.demandes = demandes;
    }

    public Client(String firstname, String lastname, String phone, String email, ArrayList<Demande> demandes) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.demandes = demandes;
    }
}
