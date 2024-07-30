package com.example.agriprovisionelite;

public class farmerRegisterModel {
     String f_name , f_email,  f_password, f_mobile, f_adhar, f_state,  f_dist , f_tal ,f_id;

    public farmerRegisterModel(String f_name, String f_email, String f_password, String f_mobile, String f_adhar, String f_state, String f_dist, String f_tal) {
        this.f_name = f_name;
        this.f_email = f_email;
        this.f_password = f_password;
        this.f_mobile = f_mobile;
        this.f_adhar = f_adhar;
        this.f_state = f_state;
        this.f_dist = f_dist;
        this.f_tal = f_tal;
//        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_email() {
        return f_email;
    }

    public void setF_email(String f_email) {
        this.f_email = f_email;
    }

    public String getF_password() {
        return f_password;
    }

    public void setF_password(String f_password) {
        this.f_password = f_password;
    }

    public String getF_mobile() {
        return f_mobile;
    }

    public void setF_mobile(String f_mobile) {
        this.f_mobile = f_mobile;
    }

    public String getF_adhar() {
        return f_adhar;
    }

    public void setF_adhar(String f_adhar) {
        this.f_adhar = f_adhar;
    }

    public String getF_state() {
        return f_state;
    }

    public void setF_state(String f_state) {
        this.f_state = f_state;
    }

    public String getF_dist() {
        return f_dist;
    }

    public void setF_dist(String f_dist) {
        this.f_dist = f_dist;
    }

    public String getF_tal() {
        return f_tal;
    }

    public void setF_tal(String f_tal) {
        this.f_tal = f_tal;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }
}
