package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {

    // Warna
    public static final Color BACKGROUND = new Color(30, 30, 45);
    public static final Color PRIMARY = new Color(120, 100, 255);
    public static final Color TEXT = new Color(240, 240, 255);

    // Font
    public static final Font TITLE_FONT =
            new Font("Arial", Font.BOLD, 20);

    public static final Font NORMAL_FONT =
            new Font("Arial", Font.PLAIN, 14);

    public static final Font BUTTON_FONT =
            new Font("Arial", Font.BOLD, 13);

    // Border
    public static final Border PANEL_BORDER =
            BorderFactory.createLineBorder(PRIMARY, 2);

    // Mini Challenge
    public static final int GOLD_LEVEL_THRESHOLD = 5;
    public static final Color GOLD = new Color(255, 215, 0);
    public static final Font HIGHLIGHT_FONT =
            new Font("Arial", Font.BOLD, 14);
         
    // Warna berdasarkan role karakter
    public static Color colorFor(CharacterType type) {
        switch (type) {
            case KNIGHT:
                return new Color(70, 130, 220);

            case ASSASSIN:
                return new Color(180, 70, 70);

            case NECROMANCER:
                return new Color(130, 80, 180);

            case SUMMONER:
                return new Color(50, 160, 120);

            default:
                return BACKGROUND;
        }
    }
    // Border berdasarkan role
    public static Border borderFor(CharacterType type) {
        return BorderFactory.createLineBorder(colorFor(type), 3);
    }
}
