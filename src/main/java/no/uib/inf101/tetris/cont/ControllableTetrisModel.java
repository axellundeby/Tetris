package no.uib.inf101.tetris.cont;


import no.uib.inf101.tetris.model.GameState;

public interface ControllableTetrisModel {

    /**
    Moves the falling tetromino by the given number of rows and columns if the resulting
    position is legal, and updates the current falling tetromino if successful.
    @param deltaRow the number of rows to move the tetromino 
    @param deltaCol the number of columns to move the tetromino
    @return true if the tetromino was successfully moved, false otherwise
    */
    boolean moveTetromino(int deltaRow, int deltaCol);

    /**
    Rotates the falling tetromino 90 degrees clockwise and updates the current falling
    tetromino if the resulting position is legal.
    */
    void rotateTetromino();

    /**
    Drops the falling tetromino until it cannot be dropped any further, and then glues
    the tetromino to the board.
    */

    void tetrominoDrop();

    /**
    @return the current game state
    */
    GameState getGamestate();
    
    /**
    @return the drop timer value in milliseconds
    */
    int droptimer();
    

    /**
    Drops the tetromino 1 row if a move is legal, otherwise glue the tetromino
    */
    void clockTick();
}
