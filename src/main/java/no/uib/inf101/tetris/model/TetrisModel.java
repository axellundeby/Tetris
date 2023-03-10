package no.uib.inf101.tetris.model;


import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.cont.ControllableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;

public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel {
    TetrisBoard board;
    TetrominoFactory factory;
    Tetromino fallingTetromino;

    GameState gameState = GameState.ACTIVE_GAME;

    
    public TetrisModel(TetrisBoard board, TetrominoFactory factory, Tetromino fallingTetromino){
        this.board = board;
        this.factory = factory;
        this.fallingTetromino = factory.getNext();
        this.fallingTetromino = fallingTetromino.shiftedToTopCenterOf(board);
      
    }
    @Override
    public GridDimension getDimension(){
        return this.board;
    }

    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard(){
        return this.board;
    }

    @Override
    public Iterable<GridCell<Character>> getPiece() {
       return fallingTetromino;
    }

    @Override
    public boolean moveTetromino(int deltaRow, int deltaCol) {
        Tetromino ShapeCopy = fallingTetromino.shiftedBy(deltaRow, deltaCol);
        if(legalTetreminoMove(ShapeCopy)){
            this.fallingTetromino = ShapeCopy;
            return true;
        }
        return false;
    }

    /**
     * Checks if a shapes position is legal
     * @param shape 
     * @return if the position is legal return true, otherwise retrun false.
     */
    public boolean legalTetreminoMove(Tetromino shape){    
        for (GridCell<Character> ShapeCell : shape) {
            CellPosition pos = ShapeCell.pos();
            if(!(board.positionIsOnGrid(pos) && board.get(pos) == '-')){
                return false;
        }
        }
        return true;
    }

    @Override
    public void rotateTetromino() {
        Tetromino newTetromino = this.fallingTetromino.rotateTetromino();
        if(legalTetreminoMove(newTetromino)){
            this.fallingTetromino = newTetromino;
        }
    }

    @Override
    public void tetrominoDrop() {
       while(legalTetreminoMove(fallingTetromino.shiftedBy(1, 0))){
        moveTetromino(1, 0);
       }
       glueTetromino();
    } 
    
    /**
     * generates a new tetromiono and places it at the top center of the board, if the new tetromino can
     * legaly be placed it becomes the fallingetromino, otherwise the gamestate is set to game over
     */
    public void newShape(){
        Tetromino fallingTetrominoTemp = factory.getNext().shiftedToTopCenterOf(board);
        if((legalTetreminoMove(fallingTetrominoTemp))){
            fallingTetromino = fallingTetrominoTemp;
        }
        else{
            gameState = GameState.GAME_OVER;
        }
    }

    /**
     * glues the tetromino to the bord, call on the method newShape() and rowsRemoved()
     */
    public void glueTetromino(){
        for (GridCell<Character> fallingTetrominoCell : fallingTetromino) {
            board.set(fallingTetrominoCell.pos(), fallingTetrominoCell.value());
        }
        newShape();
        board.rowsRemoved();
        
    }

    @Override
    public GameState getGamestate() {
      return gameState;
    }

    @Override
    public int droptimer() {
        return 1000;
    }

    @Override
    public void clockTick() {
        if(legalTetreminoMove(fallingTetromino.shiftedBy(1, 0))){
            moveTetromino(1, 0);
        }
        else{
            glueTetromino();
        }
    }


}
