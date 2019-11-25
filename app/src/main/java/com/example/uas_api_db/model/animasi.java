package com.example.uas_api_db.model;

public class animasi {
    private String nama;
    private String deskripsi;
    private String rating;
    private Integer episode;
    private String gambar_url;
    private String kategori;
    private String studio;

    public animasi() {
    }

    public animasi(String nama, String deskripsi, String rating, Integer episode, String gambar_url, String kategori, String studio) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.rating = rating;
        this.episode = episode;
        this.gambar_url = gambar_url;
        this.kategori = kategori;
        this.studio = studio;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getRating() {
        return rating;
    }

    public Integer getEpisode() {
        return episode;
    }

    public String getGambar_url() {
        return gambar_url;
    }

    public String getKategori() {
        return kategori;
    }

    public String getStudio() {
        return studio;
    }

    //Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
