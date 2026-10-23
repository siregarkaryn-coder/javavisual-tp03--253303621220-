package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CharacterManager characterManager;
    private JTextArea textArea;
    private JLabel lbRataRata;
    private JTextField txtNama, txtLevel;
    private JComboBox<CharacterType> cmbType;

    public MainWindow(CharacterManager manager) {
        this.characterManager = manager;

        setTitle("Character Manager - Sprint 3");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Area Text untuk Menampilkan Daftar Karakter di Tengah
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Panel Form Input di Bagian Atas
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createTitledBorder("Tambah Karakter Baru"));
        
        panelInput.add(new JLabel(" Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);

        panelInput.add(new JLabel(" Tipe:"));
        cmbType = new JComboBox<>(CharacterType.values());
        panelInput.add(cmbType);

        panelInput.add(new JLabel(" Level:"));
        txtLevel = new JTextField();
        panelInput.add(txtLevel);

        JButton btnTambah = new JButton("Tambah Karakter");
        panelInput.add(btnTambah);
        
        add(panelInput, BorderLayout.NORTH);

        // Panel Bawah untuk Statistik & Refresh
        JPanel panelBawah = new JPanel(new GridLayout(2, 1, 5, 5));
        lbRataRata = new JLabel(" Rata-rata Level: 0.0", JLabel.CENTER);
        panelBawah.add(lbRataRata);

        JButton btnLoad = new JButton("Refresh Daftar Karakter");
        panelBawah.add(btnLoad);

        add(panelBawah, BorderLayout.SOUTH);

        // Event Tombol Tambah Karakter
        btnTambah.addActionListener(e -> {
            String nama = txtNama.getText().trim();
            String levelStr = txtLevel.getText().trim();
            CharacterType tipe = (CharacterType) cmbType.getSelectedItem();

            if (nama.isEmpty() || levelStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan Level tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                int level = Integer.parseInt(levelStr);
                Character karakterBaru = new Character(nama, tipe, level);
                boolean sukses = characterManager.addCharacter(karakterBaru);

                if (sukses) {
                    JOptionPane.showMessageDialog(this, "Karakter berhasil ditambahkan!");
                    txtNama.setText("");
                    txtLevel.setText("");
                    muatDataDinamis(); // Langsung perbarui tampilan
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal: Nama karakter sudah ada (duplikat)!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Level harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Event Tombol Refresh
        btnLoad.addActionListener(e -> muatDataDinamis());

        // Muat data otomatis saat pertama kali dibuka
        muatDataDinamis();
    }

    private void muatDataDinamis() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== DATA KARAKTER TERKINI ===\n\n");
        
        for (Character c : characterManager.getAllCharacters()) {
            sb.append("Nama : ").append(c.getName())
              .append(" | Tipe : ").append(c.getType())
              .append(" | Level : ").append(c.getLevel())
              .append("\n");
        }
        textArea.setText(sb.toString());

        double rataRata = characterManager.getAverageLevel();
        lbRataRata.setText(" Rata-rata Level: " + rataRata);
    }
}