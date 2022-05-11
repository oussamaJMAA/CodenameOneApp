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
public class Commande {

    private int id;
    private int nbProduct;
    private String date;
    private String method;
    private String etat;
    private String total;
    private int productId;

    public Commande(int nbProduct, String date, String method, String etat, String total) {
        this.nbProduct = nbProduct;
        this.date = date;
        this.method = method;
        this.etat = etat;
        this.total = total;
    }

    public Commande() {
    }

    public Commande(int nbProduct, String date, String method) {
        this.nbProduct = nbProduct;
        this.date = date;
        this.method = method;
    }

    public Commande(String date, String method) {
        this.date = date;
        this.method = method;
    }

    public Commande(int id, int nbProduct, String date, String method, String etat, String total, int productId) {
        this.id = id;
        this.nbProduct = nbProduct;
        this.date = date;
        this.method = method;
        this.etat = etat;
        this.total = total;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbProduct() {
        return nbProduct;
    }

    public void setNbProduct(int nbProduct) {
        this.nbProduct = nbProduct;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", nbProduct=" + nbProduct + ", date=" + date + ", method=" + method + ", etat=" + etat + ", total=" + total + ", productId=" + productId + '}';
    }

}
