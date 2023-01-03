package com.example.myshopdemand.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {

    private int clientId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private HashMap<String,Demande> Demandes;

    public Client() {
    }

    public Client(int clientId, String firstName, String lastName, String phone, String email, HashMap<String, Demande> demandes) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        Demandes = demandes;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public HashMap<String, Demande> getDemandes() {
        return Demandes;
    }

    public void setDemandes(HashMap<String,Demande> demandes) {
        Demandes = demandes;
    }
}
