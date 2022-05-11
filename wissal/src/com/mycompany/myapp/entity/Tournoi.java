/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entity;

import java.util.Date;

/**
 *
 * @author oussa
 */
public class Tournoi {
    private int id;
    private String nom_tournois, recompense ;
String date_tournois;

    public String getDate_tournois() {
        return date_tournois;
    }

    public void setDate_tournois(String date_tournois) {
        this.date_tournois = date_tournois;
    }

 
    public Tournoi(int id, String nom, String recompense, String date_tournois) {
        this.id = id;
        this.nom_tournois = nom;
        this.recompense = recompense;
        this.date_tournois = date_tournois;
    }

    public Tournoi(int id, String nom, String recompense) {
        this.id = id;
        this.nom_tournois = nom;
        this.recompense = recompense;
    }

    public Tournoi(String nom, String recompense) {
        this.nom_tournois = nom;
        this.recompense = recompense;
    }
    public Tournoi(){
            
            }

    @Override
    public String toString() {
        return "Tournoi{" + "id=" + id + ", nom=" + nom_tournois + ", recompense=" + recompense + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom_tournois;
    }

    public void setNom_tournois(String nom) {
        this.nom_tournois = nom;
    }

    public String getRecompense() {
        return recompense;
    }

    public void setRecompense(String recompense) {
        this.recompense = recompense;
    }
    
}
