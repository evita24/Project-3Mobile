package com.example.usingpreferences.DataModel;

public class KategoriSenimanModel {
    private int id_kategori_seniman;
    private String nama_kategori, singkatan_kategori;

    public int getId_kategori_seniman() {
        return id_kategori_seniman;
    }

    public void setId_kategori_seniman(int id_kategori_seniman) {
        this.id_kategori_seniman = id_kategori_seniman;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getSingkatan_kategori() {
        return singkatan_kategori;
    }

    public void setSingkatan_kategori(String singkatan_kategori) {
        this.singkatan_kategori = singkatan_kategori;
    }
}