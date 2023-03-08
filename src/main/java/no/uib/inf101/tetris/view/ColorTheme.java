package no.uib.inf101.tetris.view;
import java.awt.Color;
import java.awt.Font;

public interface ColorTheme {
     /**@return the color of a cell */
     Color getCellColor(char c);
     
     /**@return the color of the frame */
     Color getFrameColor();
    
     /**@return the color of the background */
     Color getBackgroundColor();

     //font, farge til fonten, gameover bakfarg

     Font getFont();

     Color getFontColor();

     Color getGameOverBackgroundColor();


}   
