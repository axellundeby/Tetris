package no.uib.inf101.tetris.view;

import javax.swing.JPanel;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.model.ViewableTetrisModel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Dimension;

public class TetrisView extends JPanel {
    
    private final  int OutMargin = 15;
    private final  int InnMargin = 2;
    private final ViewableTetrisModel view;
    private final ColorTheme colorTheme;

    public TetrisView(ViewableTetrisModel view) {
        this.view=view;
        this.colorTheme=new DefaultColorTheme();
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(450, 800));
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      drawGame(g2);
    }

    private void drawGame(Graphics2D g) {
        Rectangle2D tetrisBox = new Rectangle2D.Double(OutMargin, OutMargin, this.getWidth() - OutMargin * 2, this.getHeight() - OutMargin * 2);
        GridDimension dimension = view.getDimension();
        CellPositionToPixelConverter converter = new CellPositionToPixelConverter(tetrisBox, dimension, InnMargin);

        drawCells(g, view.getTilesOnBoard(), converter, colorTheme);
        drawCells(g, view.getPiece(), converter, colorTheme);

        if(view.getGamestate() == GameState.GAME_OVER){
            drawGameover(g);
        }
      } 
      
    private void drawCells(Graphics2D g, Iterable<GridCell<Character>> tetrisgrid, CellPositionToPixelConverter converter, ColorTheme colorTheme) {
        for (GridCell<Character> cell : tetrisgrid) {
        CellPosition cordinate = cell.pos();
        Rectangle2D rectangle = converter.getBoundsForCell(cordinate);
        
        Color color = colorTheme.getCellColor(cell.value());
        g.setColor(color);
        g.fill(rectangle);
        }
    }

    public void drawGameover(Graphics2D g){
        ColorTheme gmColor = new DefaultColorTheme();
        g.setColor(gmColor.getGameOverBackgroundColor());
        g.fillRect(OutMargin, OutMargin, this.getWidth() - OutMargin * 2, this.getHeight() - OutMargin * 2);
        
        g.setFont(gmColor.getFont());
        g.setColor(gmColor.getFontColor());

        Inf101Graphics.drawCenteredString(g, "Game Over",OutMargin, OutMargin, this.getWidth() - OutMargin * 2, this.getHeight() - OutMargin * 2);
    }
}
