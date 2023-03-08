package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.model.GameState;

public interface ControllableTetrisModel {
    boolean moveTetromino(int deltaRow, int deltaCol);
    void rotateTetromino();
    boolean tetrominoDrop();    
    GameState getGamestate();

}
