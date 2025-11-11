/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class StoredProcedureApp extends JFrame {
    private JTextField txtAkunId;
    private JTextField txtJumlah;
    private JTextField txtPengirimId;
    private JTextField txtPenerimaId;
    private JButton btnTambahSaldo;
    private JButton btnKurangiSaldo;
    private JButton btnTransferSaldo;
    private JTextArea txtResult;

    public StoredProcedureApp() {
        setTitle("Aplikasi Manajemen Transaksi");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblAkunId = new JLabel("ID Akun:");
        lblAkunId.setBounds(20, 20, 100, 25);
        panel.add(lblAkunId);

        txtAkunId = new JTextField();
        txtAkunId.setBounds(150, 20, 200, 25);
        panel.add(txtAkunId);

        JLabel lblJumlah = new JLabel("Jumlah:");
        lblJumlah.setBounds(20, 60, 100, 25);
        panel.add(lblJumlah);

        txtJumlah = new JTextField();
        txtJumlah.setBounds(150, 60, 200, 25);
        panel.add(txtJumlah);

        btnTambahSaldo = new JButton("Tambah Saldo");
        btnTambahSaldo.setBounds(50, 100, 150, 30);
        panel.add(btnTambahSaldo);

        btnKurangiSaldo = new JButton("Kurangi Saldo");
        btnKurangiSaldo.setBounds(210, 100, 150, 30);
        panel.add(btnKurangiSaldo);

        JLabel lblPengirimId = new JLabel("ID Pengirim:");
        lblPengirimId.setBounds(20, 150, 100, 25);
        panel.add(lblPengirimId);

        txtPengirimId = new JTextField();
        txtPengirimId.setBounds(150, 150, 200, 25);
        panel.add(txtPengirimId);

        JLabel lblPenerimaId = new JLabel("ID Penerima:");
        lblPenerimaId.setBounds(20, 190, 100, 25);
        panel.add(lblPenerimaId);

        txtPenerimaId = new JTextField();
        txtPenerimaId.setBounds(150, 190, 200, 25);
        panel.add(txtPenerimaId);

        btnTransferSaldo = new JButton("Transfer Saldo");
        btnTransferSaldo.setBounds(130, 230, 150, 30);
        panel.add(btnTransferSaldo);

        txtResult = new JTextArea();
        txtResult.setBounds(20, 270, 350, 70);
        txtResult.setEditable(false);
        panel.add(txtResult);

        // Action Listener untuk Tambah Saldo
        btnTambahSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int akunId = Integer.parseInt(txtAkunId.getText());
                double jumlah = Double.parseDouble(txtJumlah.getText());
                try {
                    tambahSaldo(akunId, jumlah);
                    txtResult.setText("Saldo berhasil ditambahkan.");
                } catch (SQLException ex) {
                    txtResult.setText("Error: " + ex.getMessage());
                }
            }
        });

        // Action Listener untuk Kurangi Saldo
        btnKurangiSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int akunId = Integer.parseInt(txtAkunId.getText());
                double jumlah = Double.parseDouble(txtJumlah.getText());
                try {
                    kurangiSaldo(akunId, jumlah);
                    txtResult.setText("Saldo berhasil dikurangi.");
                } catch (SQLException ex) {
                    txtResult.setText("Error: " + ex.getMessage());
                }
            }
        });

        // Action Listener untuk Transfer Saldo
        btnTransferSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pengirimId = Integer.parseInt(txtPengirimId.getText());
                int penerimaId = Integer.parseInt(txtPenerimaId.getText());
                double jumlah = Double.parseDouble(txtJumlah.getText());
                try {
                    transferSaldo(pengirimId, penerimaId, jumlah);
                    txtResult.setText("Transfer saldo berhasil.");
                } catch (SQLException ex) {
                    txtResult.setText("Error: " + ex.getMessage());
                }
            }
        });

        add(panel);
    }

    // Metode untuk memanggil prosedur tambah saldo
    public void tambahSaldo(int id, double jumlah) throws SQLException {
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall("call tambah_saldo(?, ?)");
        stmt.setInt(1, id);
        stmt.setDouble(2, jumlah);
        stmt.execute();
        conn.close();
    }

    // Metode untuk memanggil prosedur kurangi saldo
    public void kurangiSaldo(int id, double jumlah) throws SQLException {
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall("call kurangi_saldo(?, ?)");
        stmt.setInt(1, id);
        stmt.setDouble(2, jumlah);
        stmt.execute();
        conn.close();
    }

    // Metode untuk memanggil prosedur transfer saldo
    public void transferSaldo(int pengirimId, int penerimaId, double jumlah) throws SQLException {
        Connection conn = DBConnection.getConnection();
        CallableStatement stmt = conn.prepareCall("call transfer_saldo(?, ?, ?)");
        stmt.setInt(1, pengirimId);
        stmt.setInt(2, penerimaId);
        stmt.setDouble(3, jumlah);
        stmt.execute();
        conn.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StoredProcedureApp().setVisible(true);
            }
        });
    }
}