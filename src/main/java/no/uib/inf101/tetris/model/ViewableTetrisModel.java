package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

public interface ViewableTetrisModel{
    
    /**
    @return a GridDimension object
    */
    GridDimension getDimension();
    

    /**
     * som itererer over alle flisene på brettet. Mer presist, en metode som 
     * @return
     * returnerer et objekt som, 
     * når det itereres over, gir alle posisjonene på brettet med tilhørende symbol.
     */
    Iterable<GridCell<Character>> getTilesOnBoard();    


    Iterable<GridCell<Character>> getPiece();
}
