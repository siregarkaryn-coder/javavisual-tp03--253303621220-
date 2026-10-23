package com.unpri.charactermanager.model;

public class Character {

    private String name;
    private int level;
    private CharacterType type;
    private int hitPoints;
    private int mana;

    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.hitPoints = 100;
        this.mana = 50;
    }

    public Character(String name, CharacterType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = 100;
        this.mana = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif");
        
        }
        this.mana = mana;
    }

    public void levelUp() {
        level++;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass () != obj.getClass()) return false;
        Character character = (Character) obj;
        return name.equalsIgnoreCase(character.name);
    }


    @Override
    public String toString() {
        return "Character{name='" + name +
                "', type=" + type +
                ", level=" + level + 
                "} mana=" + mana + "}";
    }
}