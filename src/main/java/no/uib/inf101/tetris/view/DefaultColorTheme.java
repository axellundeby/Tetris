package no.uib.inf101.tetris.view;

import java.awt.Color;

public class DefaultColorTheme implements ColorTheme{

    @Override
    public Color getCellColor(char c) {
      Color color = switch(c) {
        case 'L' -> Color.ORANGE;
        case 'J' -> Color.CYAN;
        case 'T' -> Color.PINK;
        case 'Z' -> Color.YELLOW;
        case 'S' -> Color.blue;
        case 'I' -> Color.blue;
        case 'O' -> Color.RED;
        // .... fyll ut dine favorittfarger
        case '-' -> Color.lightGray;
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
    
   

}
