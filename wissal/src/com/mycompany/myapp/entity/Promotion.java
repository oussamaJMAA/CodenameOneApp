/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entity;

/**
 *
 * @author MSI GAMMING
 */
public class Promotion {
    private int id ; 
    private String nom ; 
    private String date ; 
    private int prixPro;
    private String datef; 

    public Promotion() {
    }

    public Promotion(int id, String nom, String date, int prixPro, String datef) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.prixPro = prixPro;
        this.datef = datef;
    }

    public Promotion(String nom, String date, int prixPro, String datef) {
        this.nom = nom;
        this.date = date;
        this.prixPro = prixPro;
        this.datef = datef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrixPro() {
        return prixPro;
    }

    public void setPrixPro(int prixPro) {
        this.prixPro = prixPro;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", nom=" + nom + ", date=" + date + ", prixPro=" + prixPro + ", datef=" + datef + '}';
    }
    
    
    
    
}
