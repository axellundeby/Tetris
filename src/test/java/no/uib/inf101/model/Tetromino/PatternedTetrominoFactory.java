package no.uib.inf101.model.Tetromino;

import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;

public class PatternedTetrominoFactory implements TetrominoFactory {
    String str;

    public PatternedTetrominoFactory(String str){
        this.str=str;
    }

    @Override
    public Tetromino getNext() {
        
    }
    
}
