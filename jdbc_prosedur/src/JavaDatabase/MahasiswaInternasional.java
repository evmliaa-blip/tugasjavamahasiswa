/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaDatabase;

/**
 *
 * @author liaa
 */
public class MahasiswaInternasional extends Mahasiswa {

    public MahasiswaInternasional(String nama, String nim, int jumlahSks) {
        super(nama, nim, "Internasional", jumlahSks);
    }

    @Override
    public long hitungBiaya() {
        return jumlahSks * 300000 + 5000000;
    }
}
