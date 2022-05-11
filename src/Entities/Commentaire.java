/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Date;

/**
 *
 * @author RYANG
 */
public class Commentaire {

    int id ;

    String auteur ;

    String contenu ;

    Date createdAt ;

    public Commentaire(int id, String auteur, String contenu, Date createdAt) {
        this.id = id;
        this.auteur = auteur;
        this.contenu = contenu;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", auteur=" + auteur + ", contenu=" + contenu + ", createdAt=" + createdAt + '}';
    }

}
