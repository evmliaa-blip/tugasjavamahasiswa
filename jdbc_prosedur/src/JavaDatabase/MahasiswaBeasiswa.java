/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaDatabase;

/**
 *
 * @author liaa
 */
public class MahasiswaBeasiswa extends Mahasiswa {

    public MahasiswaBeasiswa(String nama, String nim, int jumlahSks) {
        super(nama, nim, "Beasiswa", jumlahSks);
    }

    @Override
    public long hitungBiaya() {
        return (long)(jumlahSks * 150000 * 0.5);
    }
}