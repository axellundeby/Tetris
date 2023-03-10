package no.uib.inf101.tetris.view;

import java.awt.geom.Rectangle2D;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;


public class CellPositionToPixelConverter {
  Rectangle2D box;
  GridDimension gd;
  double margin;

  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin){
    this.box=box;
    this.gd=gd;
    this.margin=margin;
  }

  /**
   * calculates the position of the cells on a given position
   * @param pos a given position on a grid
   * @return cell
   */

  public Rectangle2D getBoundsForCell(CellPosition pos){
    double rows = gd.rows();
    double cols = gd.cols();

    double cellWidth = (box.getWidth() - (this.margin * (cols +1))) / cols;
    double cellHeight = (box.getHeight() - (this.margin * (rows +1))) / rows;

    double cellX = box.getX() + (this.margin * (pos.col() + 1)) + (cellWidth * pos.col());
    double cellY = box.getY() + (this.margin * (pos.row() + 1)) + (cellHeight * pos.row());

    Rectangle2D tetrisbox = new Rectangle2D.Double(cellX,cellY,cellWidth,cellHeight);
    return tetrisbox; 
  }
}
