package no.uib.inf101.tetris.model.tetromino;

import java.util.Random;

public class RandomTetrominoFactory implements TetrominoFactory {

    private final Random random;

    public RandomTetrominoFactory() {
        this.random = new Random();
    }

    @Override
    public Tetromino getNext() {
        final char[] tetrominoSymbols = {'L','J','S','Z','T','I','O'};
        char randomSymbol = tetrominoSymbols[random.nextInt(tetrominoSymbols.length)];
        return Tetromino.newTetromino(randomSymbol);
    }
    
}
