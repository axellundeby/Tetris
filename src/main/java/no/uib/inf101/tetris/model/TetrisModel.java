package no.uib.inf101.tetris.model;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.controller.ControllableTetrisModel;
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

    public GridDimension getDimension(){
        return this.board;
    }

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

    //skriv i javadoc
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
    public boolean tetrominoDrop() {
       while(legalTetreminoMove(fallingTetromino.shiftedBy(1, 0))){
        moveTetromino(1, 0);
       }
       glueTetromino();
       return true;
    } 
    
    public void newShape(){
        fallingTetromino = factory.getNext().shiftedToTopCenterOf(board);
        if(!(legalTetreminoMove(fallingTetromino))){
            gameState = GameState.GAME_OVER;
        }
    }

    public void glueTetromino(){
        for (GridCell<Character> fallingTetrominoCell : fallingTetromino) {
            board.set(fallingTetrominoCell.pos(), fallingTetrominoCell.value());
        }
        newShape();
    }

    @Override
    public GameState getGamestate() {
      return gameState;
    }


}
