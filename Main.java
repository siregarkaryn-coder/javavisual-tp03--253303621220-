package com.unpri.charactermanager.model;

public class Main {

    public static void main(String[] args) {
        // Membuat objek CharacterManager
        CharacterManager manager = new CharacterManager();

        // Membuat data karakter
        Character c1 = new Character("Vecna", CharacterType.KNIGHT);
        Character c2 = new Character("Eleven", CharacterType.ASSASSIN, 4);
        Character c3 = new Character("Mike", CharacterType.NECROMANCER, 7);
        Character c4 = new Character("Lucas", CharacterType.SUMMONER, 2);
        c4.setMana(80);

        // Memasukkan karakter ke dalam manager (Object Reference)
        manager.addCharacter(c1);
        manager.addCharacter(c2);
        manager.addCharacter(c3);
        manager.addCharacter(c4);

        // Menampilkan daftar seluruh karakter
        System.out.println("=== DAFTAR SEMUA KARAKTER ===");
        manager.displayAllCharacters();

        // Menjalankan fitur Analytics
        System.out.println("\n=== ANALISIS KARAKTER ===");
        System.out.println("Total Karakter: " + manager.getTotalCharacters());
        System.out.println("Karakter Level Tertinggi: " + manager.getHighestLevelCharacter());
        System.out.println("Is Lucas alive? " + c4.isAlive());

        System.out.println("\n===UJI BAGIAN B ===");
        System.out.println("Rata-rata level Level: " + manager.getAverageLevel());
        System.out.println("Karakter Tipe KNIGHT: " + manager.findByType(CharacterType.KNIGHT));
    }
}