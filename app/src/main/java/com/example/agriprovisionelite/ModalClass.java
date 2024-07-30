package com.example.agriprovisionelite;

import android.graphics.Bitmap;

public class ModalClass {


    private  String title,Description,Eligibility,Documents;
    Bitmap profileImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEligibility() {
        return Eligibility;
    }

    public void setEligibility(String eligibility) {
        Eligibility = eligibility;
    }

    public String getDocuments() {
        return Documents;
    }

    public void setDocuments(String documents) {
        Documents = documents;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    public ModalClass(String title, String description, String eligibility, String documents, Bitmap profileImage) {
        this.title = title;
        Description = description;
        Eligibility = eligibility;
        Documents = documents;
        this.profileImage = profileImage;
    }


}
