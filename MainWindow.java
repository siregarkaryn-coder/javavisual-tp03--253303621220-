package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private CharacterManager characterManager;
    private JPanel panelKarakter;
    private JLabel lbRataRata;
    private JTextField txtNama, txtLevel;
    private JComboBox<CharacterType> cmbType;

    public MainWindow(CharacterManager manager) {
        this.characterManager = manager;

        setTitle("Character Manager - Sprint 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput.setBackground(AppTheme.BACKGROUND);
        panelInput.setBorder(AppTheme.PANEL_BORDER);

        JLabel lbNama = new JLabel("Nama:");
        lbNama.setForeground(AppTheme.TEXT);
        lbNama.setFont(AppTheme.NORMAL_FONT);
        panelInput.add(lbNama);

        txtNama = new JTextField();
        panelInput.add(txtNama);

        JLabel lbTipe = new JLabel("Tipe:");
        lbTipe.setForeground(AppTheme.TEXT);
        lbTipe.setFont(AppTheme.NORMAL_FONT);
        panelInput.add(lbTipe);

        cmbType = new JComboBox<>(CharacterType.values());
        panelInput.add(cmbType);

        JLabel lbLevel = new JLabel("Level:");
        lbLevel.setForeground(AppTheme.TEXT);
        lbLevel.setFont(AppTheme.NORMAL_FONT);
        panelInput.add(lbLevel);

        txtLevel = new JTextField();
        panelInput.add(txtLevel);

        JButton btnTambah = new JButton("Tambah Karakter");
        btnTambah.setFont(AppTheme.BUTTON_FONT);
        btnTambah.setBackground(AppTheme.PRIMARY);
        btnTambah.setForeground(AppTheme.TEXT);
        panelInput.add(btnTambah);

        add(panelInput, BorderLayout.NORTH);

        panelKarakter = new JPanel();
        panelKarakter.setLayout(new BoxLayout(panelKarakter, BoxLayout.Y_AXIS));
        panelKarakter.setBackground(AppTheme.BACKGROUND);

        JScrollPane scrollPane = new JScrollPane(panelKarakter);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBawah = new JPanel();
        panelBawah.setBackground(AppTheme.BACKGROUND);

        lbRataRata = new JLabel("Rata-rata Level: 0.0");
        lbRataRata.setFont(AppTheme.NORMAL_FONT);
        lbRataRata.setForeground(AppTheme.TEXT);
        panelBawah.add(lbRataRata);

        JButton btnLoad = new JButton("Refresh Daftar Karakter");
        btnLoad.setFont(AppTheme.BUTTON_FONT);
        panelBawah.add(btnLoad);

        add(panelBawah, BorderLayout.SOUTH);

        btnTambah.addActionListener(e -> {
            String nama = txtNama.getText().trim();
            String levelStr = txtLevel.getText().trim();
            CharacterType tipe = (CharacterType) cmbType.getSelectedItem();

            if (nama.isEmpty() || levelStr.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Nama dan Level tidak boleh kosong!");
                return;
            }

            try {
                int level = Integer.parseInt(levelStr);

                Character karakterBaru =
                        new Character(nama, tipe, level);

                boolean sukses =
                        characterManager.addCharacter(karakterBaru);

                if (sukses) {
                    JOptionPane.showMessageDialog(this,
                            "Karakter berhasil ditambahkan!");

                    txtNama.setText("");
                    txtLevel.setText("");
                    muatDataDinamis();

                } else {
                    JOptionPane.showMessageDialog(this,
                            "Nama karakter sudah ada!");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Level harus berupa angka!");
            }
        });

        btnLoad.addActionListener(e -> muatDataDinamis());

        muatDataDinamis();

        pack();
        setMinimumSize(new Dimension(500, 450));
        setLocationRelativeTo(null);
    }

    private void muatDataDinamis() {

        panelKarakter.removeAll();

        for (Character c : characterManager.getAllCharacters()) {

            JPanel kartu = new JPanel(new BorderLayout());
            kartu.setBackground(AppTheme.colorFor(c.getType()));
            kartu.setBorder(AppTheme.borderFor(c.getType()));
            kartu.setToolTipText(
                "Nama: " + c.getName()
                + " | Role: " + c.getType()
                + " | Level: " + c.getLevel()
            );
            kartu.setOpaque(true);

            JLabel informasi = new JLabel(
                    "Nama: " + c.getName()
                    + " | Role: " + c.getType()
                    + " | Level: " + c.getLevel()
            );

            if (c.getLevel() >= AppTheme.GOLD_LEVEL_THRESHOLD) {
                informasi.setFont(AppTheme.HIGHLIGHT_FONT);
                informasi.setForeground(AppTheme.GOLD);
            } else {
                informasi.setFont(AppTheme.NORMAL_FONT);
                informasi.setForeground(AppTheme.TEXT);
            }

            kartu.add(informasi, BorderLayout.CENTER);

            panelKarakter.add(kartu);
        }

        panelKarakter.revalidate();
        panelKarakter.repaint();

        double rataRata = characterManager.getAverageLevel();

        lbRataRata.setText("Rata-rata Level: " + rataRata);
    }
}