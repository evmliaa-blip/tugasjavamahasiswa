/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javadatabase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liaa
 */
public class JavaDatabase {
    
    /**
     * @param args the command line arguments
     */
    public void main() {
        
        try {
            //1.  Buat koneksi ke DB
            Connection con = DbConnection.connect();
            //System.out.println("Berhasil");
            
            
            Mahasiswa m = new Mahasiswa("12345","liaa",2024);
            Mahasiswa m2 = new Mahasiswa("12346","liaa 2",2024);
            
            String sqls = "INSERT INTO mahasiswa (nim,nama,tahunmasuk) VALUES('"+m.nim+"','"+m.nama+"',"+m.tahunMasuk+")";
            System.out.println(sqls);
            Statement s = con.createStatement();
            s.executeUpdate(sqls);
            
            
            String sql = "INSERT INTO mahasiswa (nim,nama,tahunmasuk) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m2.nim);
            ps.setString(2, m2.nama);
            ps.setInt(3, m2.tahunMasuk);
            ps.executeUpdate();
            
            
            /*String sql = "INSERT INTO mahasiswa (nim, nama, tahunmasuk) VALUES (?, ?, ?)";
            try{
                
                PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setString(1, m.nim);
                stmt.setInt(2, m.nama);
                stmt.executeUpdate();
                System.out.println("Data berhasil ditambahkan.");
            } catch (SQLException e) {
                System.out.println("Error insert: " + e.getMessage());
            }*/
            
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(JavaDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
