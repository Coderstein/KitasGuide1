package de.freshmaninandroid.app_programmierung.kitaguide;

import java.io.Serializable;

/**
 * Created by osi on 20.10.16.
 * KITAEinrichtung_EinrNr
 * KITAEinrichtung_Name
 * #KITAEinrichtung_Strasse
 * KITAEinrichtung_HausNr
 * KITAEinrichtung_HausNr_Alpha
 * KITAEinrichtung_PLZ
 * KITAEinrichtung_Ort
 * Stadtteil_Name^KITABezirk_Name
 * KITAEinrichtung_AnsprechPartner
 * KITAEinrichtung_Telefon
 * KITATraeger_Name
 * KITAEr_refs_URL
 * KITAEr_refs_Email
 *
 */

public class Kita implements Serializable {

    private int id;
    private String kitaname, street, houseNo, postal, place, contactName,
            telNo, provider, url, email;

    public Kita(int id){
        this.id = id;
    }
    public Kita(int id, String kitaname, String street, String houseNo, String postal, String place, String contactName, String telNo, String provider, String url, String email) {
        this(id);
        this.kitaname = kitaname;
        this.street = street;
        this.houseNo = houseNo;
        this.postal = postal;
        this.place = place;
        this.contactName = contactName;
        this.telNo = telNo;
        this.provider = provider;
        this.url = url;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getKitaname() {
        return kitaname;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getPostal() {
        return postal;
    }

    public String getPlace() {
        return place;
    }

    public String getContactName() {
        return contactName;
    }

    public String getTelNo() {
        return telNo;
    }

    public String getProvider() {
        return provider;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public void setKitaname(String kitaname) {
        this.kitaname = kitaname;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Kita{" +
                "id=" + id +
                ", kitaname='" + kitaname + '\'' +
                ", street='" + street + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", postal='" + postal + '\'' +
                ", place='" + place + '\'' +
                ", contactName='" + contactName + '\'' +
                ", telNo='" + telNo + '\'' +
                ", provider='" + provider + '\'' +
                ", url='" + url + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
