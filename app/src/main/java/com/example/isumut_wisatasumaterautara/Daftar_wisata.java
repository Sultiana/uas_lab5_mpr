package com.example.isumut_wisatasumaterautara;

public class Daftar_wisata {

        private String nama , gambar , jenis, deskripsi;

        public Daftar_wisata(String nama , String jenis, String gambar , String deskripsi){
            this.nama = nama;
            this.jenis = jenis;
            this.gambar = gambar;
            this.deskripsi = deskripsi;
        }

        public String getNama() {
            return nama;
        }

        public String getJenis() {
        return jenis;
    }

        public String getGambar() {
            return gambar;
        }

        public String getDeskripsi() {
            return deskripsi;
        }
}
