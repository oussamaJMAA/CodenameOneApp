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
public class Category {

    private int categoryId;
    private String categoryName;
    private String discription;
    private Game games;

    public Category(int categoryId, String categoryName, String discription, Game games) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.discription = discription;
        this.games = games;
    }

    public Category(String categoryName, String discription) {
        this.categoryName = categoryName;
        this.discription = discription;
    }

    public Category(int categoryId, String categoryName, String discription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.discription = discription;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Game getGames() {
        return games;
    }

    public void setGames(Game games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", discription=" + discription + ", games=" + games + '}';
    }

}
