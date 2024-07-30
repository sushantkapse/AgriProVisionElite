package com.example.agriprovisionelite.Models;

import android.graphics.Bitmap;

public class BlogDBModel {
    String tilte,author,description;
    Bitmap image;

    public BlogDBModel(String tilte, String author, String description, Bitmap image) {
        this.tilte = tilte;
        this.author = author;
        this.description = description;
        this.image = image;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
