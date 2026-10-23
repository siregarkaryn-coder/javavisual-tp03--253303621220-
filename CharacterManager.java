package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private List<Character> characters = new ArrayList<>();

    public boolean addCharacter(Character character) {
        for (Character c : characters) {
            if (c.equals(character)) {
                System.out.println("Gagal: Nama duplikat (" + character.getName() + ")");
                return false;
            }
        }
        characters.add(character);
        return true;
    }

    // Method untuk menampilkan semua karakter
    public void displayAllCharacters() {
        for (Character c : characters) {
            System.out.println(c);
        }
    }

    public Character findByName(String name) {
        for (Character c : characters) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public boolean removeCharacter(String name) {
        Character c = findByName(name);
        if (c != null) {
            characters.remove(c);
            return true;
        }
        return false;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (Character c : characters) {
            total += c.getLevel();
        }
        return (double) total / characters.size();
    }

    public List<Character> findByType(CharacterType type) {
        List<Character> result = new ArrayList<>();
        for (Character c : characters) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

        // --- BAGIAN ---
        /**
         * Menghitung jumlah karakter berdasarkan tipe tertentu.
         * @param type Tipe karakter yang ingin dihitung
         * @return Jumlah karakter dengan tipe tersebut
         */
      public int countByType(CharacterType type) {
            int count = 0;
            for (Character c : characters) {
                if (c.getType() == type) {
                    count++;
                }
            }
            return count;
    }

    public Character getHighestLevelCharacter() {
        if (characters.isEmpty()) {
            return null;
        }
        Character highest = characters.get(0);
        for (Character c : characters) {
            if (c.getLevel() > highest.getLevel()) {
                highest = c;
            }
        }
        return highest;
    }

}