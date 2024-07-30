package com.example.agriprovisionelite;

public class KrishiOfficerRegisterModel {

   String  kname , kemail,  kpassword, kmobile, kSpeicalCode, kstate,  kdist , ktal,k_id;

    public KrishiOfficerRegisterModel(String kname, String kemail, String kpassword, String kmobile, String kSpeicalCode, String kstate, String kdist, String ktal) {
        this.kname = kname;
        this.kemail = kemail;
        this.kpassword = kpassword;
        this.kmobile = kmobile;
        this.kSpeicalCode = kSpeicalCode;
        this.kstate = kstate;
        this.kdist = kdist;
        this.ktal = ktal;
    }

    public String getKname() {
        return kname;
    }

    public String getK_id() {
        return k_id;
    }

    public void setK_id(String k_id) {
        this.k_id = k_id;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public String getKemail() {
        return kemail;
    }

    public void setKemail(String kemail) {
        this.kemail = kemail;
    }

    public String getKpassword() {
        return kpassword;
    }

    public void setKpassword(String kpassword) {
        this.kpassword = kpassword;
    }

    public String getKmobile() {
        return kmobile;
    }

    public void setKmobile(String kmobile) {
        this.kmobile = kmobile;
    }

    public String getkSpeicalCode() {
        return kSpeicalCode;
    }

    public void setkSpeicalCode(String kSpeicalCode) {
        this.kSpeicalCode = kSpeicalCode;
    }

    public String getKstate() {
        return kstate;
    }

    public void setKstate(String kstate) {
        this.kstate = kstate;
    }

    public String getKdist() {
        return kdist;
    }

    public void setKdist(String kdist) {
        this.kdist = kdist;
    }

    public String getKtal() {
        return ktal;
    }

    public void setKtal(String ktal) {
        this.ktal = ktal;
    }
}
