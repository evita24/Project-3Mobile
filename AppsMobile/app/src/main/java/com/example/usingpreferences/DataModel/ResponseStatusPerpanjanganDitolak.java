package com.example.usingpreferences.DataModel;

import java.util.List;

public class ResponseStatusPerpanjanganDitolak {


    private int kode;
    private String pesan;
    private List<ModelStatusPerpanjanganDitolak> data;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<ModelStatusPerpanjanganDitolak> getData() {
        return data;
    }

    public void setData(List<ModelStatusPerpanjanganDitolak> data) {
        this.data = data;
    }
}
