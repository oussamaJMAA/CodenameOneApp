/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entity;

/**
 *
 * @author oussa
 */
public class Equipe {
    private int id,membre ;
        private String nom;
public Equipe(){
    
}
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", membre=" + membre + ", nom=" + nom + '}';
    }

    public Equipe(int membre, String nom) {
        this.membre = membre;
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembre() {
        return membre;
    }

    public void setMembre(int membre) {
        this.membre = membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Equipe(int id, int membre, String nom) {
        this.id = id;
        this.membre = membre;
        this.nom = nom;
    }

    
}
