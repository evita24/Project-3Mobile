package com.example.usingpreferences.DataModel;

import retrofit2.http.Multipart;

public class SenimanModel {
    private int nik;
    private String nama_seniman;

    public int getNik() {
        return nik;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public String getNama_seniman() {
        return nama_seniman;
    }

    public void setNama_seniman(String nama_seniman) {
        this.nama_seniman = nama_seniman;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAlamat_seniman() {
        return alamat_seniman;
    }

    public void setAlamat_seniman(String alamat_seniman) {
        this.alamat_seniman = alamat_seniman;
    }

    public String getNo_telpon() {
        return no_telpon;
    }

    public void setNo_telpon(String no_telpon) {
        this.no_telpon = no_telpon;
    }

    public String getNama_organisasi() {
        return nama_organisasi;
    }

    public void setNama_organisasi(String nama_organisasi) {
        this.nama_organisasi = nama_organisasi;
    }

    public String getJumlah_anggota() {
        return jumlah_anggota;
    }

    public void setJumlah_anggota(String jumlah_anggota) {
        this.jumlah_anggota = jumlah_anggota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSingkatan_kategori() {
        return singkatan_kategori;
    }

    public void setSingkatan_kategori(String singkatan_kategori) {
        this.singkatan_kategori = singkatan_kategori;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public Multipart getKtp_seniman() {
        return ktp_seniman;
    }

    public void setKtp_seniman(Multipart ktp_seniman) {
        this.ktp_seniman = ktp_seniman;
    }

    public Multipart getSurat_keterangan() {
        return surat_keterangan;
    }

    public void setSurat_keterangan(Multipart surat_keterangan) {
        this.surat_keterangan = surat_keterangan;
    }

    public Multipart getPass_foto() {
        return pass_foto;
    }

    public void setPass_foto(Multipart pass_foto) {
        this.pass_foto = pass_foto;
    }

    private String jenis_kelamin;
    private String tempat_lahir;
    private String tanggal_lahir;
    private String alamat_seniman;
    private String no_telpon;
    private String nama_organisasi;
    private String jumlah_anggota;
    private String status;
    private String singkatan_kategori;
    private String kecamatan;
    private Multipart ktp_seniman,surat_keterangan, pass_foto;
}
