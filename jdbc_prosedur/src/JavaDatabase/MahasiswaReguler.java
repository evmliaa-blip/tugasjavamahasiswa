/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaDatabase;

/**
 *
 * @author liaa
 */
public class MahasiswaReguler  extends Mahasiswa {

    public MahasiswaReguler (String nama, String nim, int jumlahSks) {
        super(nama, nim, "Reguler", jumlahSks);
    }

    @Override
    public long hitungBiaya() {
        return jumlahSks * 150000;
    }
}