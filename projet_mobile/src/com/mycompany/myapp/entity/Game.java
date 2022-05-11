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
public class Game {

    private int gameId;
    private String gameName;
    private String gameDescription;
    private String gameLink;
    private String gameImg;
    private String idCategory;
    private int rating;

    public Game() {
    }

    public Game(int gameId, int rating) {
        this.gameId = gameId;
        this.rating = rating;
    }

    public Game(int gameId, String gameName, String gameDescription, String gameLink, String gameImg, String idCategory) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.gameLink = gameLink;
        this.gameImg = gameImg;
        this.idCategory = idCategory;
    }

    public Game(String gameName, String gameDescription, String gameLink, String gameImg, String idCategory) {
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.gameLink = gameLink;
        this.gameImg = gameImg;
        this.idCategory = idCategory;
    }

    public Game(String gameName, String gameDescription, String gameLink, String gameImg) {
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.gameLink = gameLink;
        this.gameImg = gameImg;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameLink() {
        return gameLink;
    }

    public void setGameLink(String gameLink) {
        this.gameLink = gameLink;
    }

    public String getGameImg() {
        return gameImg;
    }

    public void setGameImg(String gameImg) {
        this.gameImg = gameImg;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", gameName=" + gameName + ", gameDescription=" + gameDescription + ", gameLink=" + gameLink + ", gameImg=" + gameImg + ", idCategory=" + idCategory + ", rating=" + rating + '}';
    }

}
