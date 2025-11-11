/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author liaa
 */
public class Mahasiswa {
    int id;
    String nim;
    String nama;
    
    int tahunMasuk;
    Connection con;
    
    
    Mahasiswa(int id, String nim, String nama, int tahunMasuk){
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        
        con = DbConnection.connect();
    }
    
    Mahasiswa(String nim, String nama, int tahunMasuk){
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
    }
    
    public void insert(){
        try {
            Connection con = DbConnection.connect();
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO mahasiswa (nim, nama) VALUES (?, ?)"
            );
            
            pst.setString(1, this.nim);
            pst.setString(2, this.nama);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
