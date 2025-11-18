/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author liaa
 */
public class Mahasiswa {

    static void uploudCSV(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNo = 0;
            int inserted = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // skip header
                if (lineNo == 1 && line.toLowerCase().contains("nama")) {
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 2) {
                    System.out.println("Baris " + lineNo + " tidak valid: " + line);
                    continue;
                }
                String nama = data[0].trim();
                String nim = data[1].trim();

                Mahasiswa n = new Mahasiswa(nama, nim);

                n.insert();
                inserted++;
            }

            JOptionPane.showMessageDialog(null,
                    "Upload CSV selesai! Data ditambahkan: " + inserted + " baris.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal membaca file CSV: " + e.getMessage());
        }
    }

    int id;
    String nim;
    String nama;

    int tahunMasuk;
    Connection con;

    Mahasiswa(String nim, String nama) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;

        con = DbConnection.connect();
    }

    Mahasiswa(String nim, String nama, int tahunMasuk) {
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public int getId() {
        return id;
    }

    public void insert() {
        try {
            Connection con = DbConnection.connect();
            PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO mahasiswa (nim, nama) VALUES (?, ?)"
            );

            pst.setString(1, this.nim);
            pst.setString(2, this.nama);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data " + this.nama + " berhasil ditambahkan!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nama=?, nim=? WHERE id=?";
        try (Connection con = DbConnection.connect(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, mhs.getNama());
            pst.setString(2, mhs.getNim());
            pst.setInt(3, mhs.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id=?";
        try (Connection con = DbConnection.connect(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
}

/*public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa ORDER BY id ASC";
        try (Connection con = DbConnection.connect();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Mahasiswa mhs    = new Mahasiswa(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("nim")
                );
                list.add(mhs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }*/
