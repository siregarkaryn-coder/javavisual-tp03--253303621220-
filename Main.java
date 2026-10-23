package com.unpri.charactermanager.model;

import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Buat CharacterManager dan tambahkan 5 karakter (3 parameter)
        CharacterManager manager = new CharacterManager();
        manager.addCharacter(new Character("Jake", CharacterType.KNIGHT, 5));
        manager.addCharacter(new Character("Jon Bon Jovi", CharacterType.SUMMONER, 4));
        manager.addCharacter(new Character("Bob Marley", CharacterType.NECROMANCER, 3));
        manager.addCharacter(new Character("Paul Mccartney", CharacterType.ASSASSIN, 6));
        manager.addCharacter(new Character("John", CharacterType.KNIGHT, 5));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Kirim data manager ke jendela utama
                new MainWindow(manager).setVisible(true);
            }
        });
    }
}