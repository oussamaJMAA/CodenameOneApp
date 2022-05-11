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
public class Blog {
    private String titre , contenu;
    private int  id ;
public Blog(){
    
}
    public Blog(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }

    public Blog(String titre, String contenu, int id) {
        this.titre = titre;
        this.contenu = contenu;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Blog{" + "titre=" + titre + ", contenu=" + contenu + ", id=" + id + '}';
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
