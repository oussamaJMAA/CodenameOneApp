/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entity;

/**
 *
 * @author louay
 */
public class Product {

    private int id;
    private String nom;
    private float prix;
    private String image;
    private int quantite;
    private int commande;

    public Product(int id, String nom, float prix, String image, int quantite, int commande) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.commande = commande;
    }

    public Product(int id, String nom, float prix, String image, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
    }

    public Product() {
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", image=" + image + ", quantite=" + quantite + ", commande=" + commande + '}';
    }

}
