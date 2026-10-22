package com.unpri.charactermanager.model;

public class Main {

    public static void main(String[] args) {

        Character c1 = new Character("Vecna", CharacterType.KNIGHT);
        Character c2 = new Character("Eleven", CharacterType.ASSASSIN, 4);
        Character c3 = new Character("Mike", CharacterType.NECROMANCER, 7);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        c2.levelUp();
        System.out.println("After level up: " + c2);
        
        Character c4 = new Character("Lucas", CharacterType.SUMMONER, 2);

        c4.setMana(80);
        System.out.println(c4);
        System.out.println("Is Lucas alive? " + c4.isAlive());

    }
}