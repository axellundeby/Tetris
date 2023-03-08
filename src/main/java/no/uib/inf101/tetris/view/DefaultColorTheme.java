package no.uib.inf101.tetris.view;

import java.awt.Color;
import java.awt.Font;


public class DefaultColorTheme implements ColorTheme{

    @Override
    public Color getCellColor(char c) {
      Color color = switch(c) {
        case 'L' -> new Color(240, 146, 221);
        case 'J' -> new Color(57, 47, 90);
        case 'T' -> Color.PINK;
        case 'Z' -> new Color (175, 172, 224);
        case 'S' -> new Color(238, 200, 224);
        case 'I' -> new Color(213, 110, 223);
        case 'O' -> new Color(240, 146, 145);

        case 'r' -> Color.pink;
        case 'g' -> Color.pink;
        case 'y' -> Color.pink;
        case 'b' -> Color.pink;
        //.... fyll ut dine favorittfarger
        case '-' -> new Color(168, 199, 187);
        default -> throw new IllegalArgumentException(
            "No available color for '" + c + "'");
      };
      return color;
    }


    @Override
    public Color getFrameColor() {
        return new Color(0, 0, 0, 0);
    }

    @Override
    public Color getBackgroundColor() {
      return null;
    }


    @Override
    public Font getFont() {
        return new Font("Serif", Font.BOLD, 50);
    }


    @Override
    public Color getFontColor() {
        return Color.white;
    }


    @Override
    public Color getGameOverBackgroundColor() {
        return new Color(0, 0, 0, 128);
    }
    
}

