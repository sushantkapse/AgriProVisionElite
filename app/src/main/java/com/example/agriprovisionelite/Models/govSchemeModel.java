package com.example.agriprovisionelite.Models;

import android.graphics.Bitmap;

public class govSchemeModel {

String title,description,documents;
Bitmap gImage;

    public govSchemeModel(String title, String description, String documents, Bitmap gImage) {
        this.title = title;
        this.description = description;
        this.documents = documents;
        this.gImage = gImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }



    public Bitmap getgImage() {
        return gImage;
    }

    public void setgImage(Bitmap gImage) {
        this.gImage = gImage;
    }
}
