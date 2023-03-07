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

  public Rectangle2D getBoundsForCell(CellPosition pos){//regner ut hvor boksene skal være ut i fra rows og cols
    double rows = gd.rows();//rows til griden
    double cols = gd.cols();//cols til griden

    double cellWidth = (box.getWidth() - (this.margin * (cols +1))) / cols;//cellens bredde
    double cellHeight = (box.getHeight() - (this.margin * (rows +1))) / rows;//cellenes høyde

    double cellX = box.getX() + (this.margin * (pos.col() + 1)) + (cellWidth * pos.col());//cellenes x startpunkt
    double cellY = box.getY() + (this.margin * (pos.row() + 1)) + (cellHeight * pos.row());//cellenes y start punkt

    Rectangle2D tetrisbox = new Rectangle2D.Double(cellX,cellY,cellWidth,cellHeight);//lager rektanglet
    return tetrisbox; 
  }


}
