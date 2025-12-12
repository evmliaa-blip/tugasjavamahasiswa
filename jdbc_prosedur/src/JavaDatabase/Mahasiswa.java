/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaDatabase;

import java.sql.Connection;

/**
 *
 * @author liaa
 */
public class Mahasiswa {

    protected int id;
    protected String nama;
    protected String nim;
    protected String jenisMahasiswa;
    protected int jumlahSks;
    protected long biayaKuliah;

    public Mahasiswa(int id, String nama, String nim, String jenisMahasiswa, int jumlahSks) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.jenisMahasiswa = jenisMahasiswa;
        this.jumlahSks = jumlahSks;
    }

    public Mahasiswa(String nama, String nim, String jenisMahasiswa, int jumlahSks) {
        this.nama = nama;
        this.nim = nim;
        this.jenisMahasiswa = jenisMahasiswa;
        this.jumlahSks = jumlahSks;
    }

    /**
     * method polymorphism yang akan dioverride
     */
    public long hitungBiaya() {
        return biayaKuliah;
    }

    // ====== GETTER & SETTER LENGKAP ======
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJenisMahasiswa() {
        return jenisMahasiswa;
    }

    public void setJenisMahasiswa(String jenisMahasiswa) {
        this.jenisMahasiswa = jenisMahasiswa;
    }

    public int getJumlahSks() {
        return jumlahSks;
    }

    public void setJumlahSks(int jumlahSks) {
        this.jumlahSks = jumlahSks;
    }

    public long getBiayaKuliah() {
        return biayaKuliah;
    }

    public void setBiayaKuliah(long biayaKuliah) {
        this.biayaKuliah = biayaKuliah;
    }
}
