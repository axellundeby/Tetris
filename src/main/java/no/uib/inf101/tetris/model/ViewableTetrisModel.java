package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

public interface ViewableTetrisModel{
    
    /**
    @return a grid Dimension object
    */
    GridDimension getDimension();
    

    /**

    Returns an iterable collection of all the grid cells on the board,
    where each cell contains a character value.
    @return an iterable collection of grid cells containing character values
    */
    Iterable<GridCell<Character>> getTilesOnBoard();    


    /**
    Returns an iterable collection of all the grid cells occupied by a game piece,
    where each cell contains a character value.
    @return an iterable collection of grid cells containing character values occupied by a game piece
    */
    Iterable<GridCell<Character>> getPiece();

    /**
     * 
     * @return the current game state
     */
    GameState getGamestate();
}
