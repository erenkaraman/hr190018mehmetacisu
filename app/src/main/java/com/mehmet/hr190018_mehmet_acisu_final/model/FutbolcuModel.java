package com.mehmet.hr190018_mehmet_acisu_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FutbolcuModel {

    @SerializedName("FutbolcuAdSoyad")
    @Expose
    private String futbolcuAdSoyad;
    @SerializedName("DogumTarihi")
    @Expose
    private String dogumTarihi;
    @SerializedName("OynadigiTakim")
    @Expose
    private String oynadigiTakim;
    @SerializedName("Bilgi")
    @Expose
    private String bilgi;
    @SerializedName("KucukLogoUrl")
    @Expose
    private String kucukLogoUrl;
    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;

    public String getFutbolcuAdSoyad() {
        return futbolcuAdSoyad;
    }

    public void setFutbolcuAdSoyad(String futbolcuAdSoyad) {
        this.futbolcuAdSoyad = futbolcuAdSoyad;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getOynadigiTakim() {
        return oynadigiTakim;
    }

    public void setOynadigiTakim(String oynadigiTakim) {
        this.oynadigiTakim = oynadigiTakim;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public String getKucukLogoUrl() {
        return kucukLogoUrl;
    }

    public void setKucukLogoUrl(String kucukLogoUrl) {
        this.kucukLogoUrl = kucukLogoUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }
}