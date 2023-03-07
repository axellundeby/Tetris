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
        //bruk shifteby for å lage en kopi av tetrominoen som skal være en kanditat for å bli flyttet
        //Tetromino copy = fallingTetromino.shiftedBy(deltaRow, deltaCol);
        if(legalTetreminoMove(fallingTetromino.shiftedBy(deltaRow, deltaCol))){
            fallingTetromino= fallingTetromino.shiftedBy(deltaRow, deltaCol);
            return true;
        }
        return false;

        //sjekke om den er lovlig med metoden under
        //hvis den er lovlig, sett current tetromino til den nye tetrominoen og return true
        //om ikke, return false 
    }

    //skriv i javadoc
    public boolean legalTetreminoMove(Tetromino shape){ //endre   
        for (GridCell<Character> ShapeCell : shape) {
            CellPosition pos = ShapeCell.pos();
            if(board.positionIsOnGrid(pos) || board.get(pos) != '-'){
                return true;
            }
        }
        return false;
    }
      
}
