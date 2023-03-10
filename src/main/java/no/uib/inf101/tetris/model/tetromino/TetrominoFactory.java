package no.uib.inf101.tetris.model.tetromino;

public interface TetrominoFactory {
    /**
     * generates the next shape randomly from a char[] containing the tetromino family names
     * @return the next Tetromino piece
     */

    Tetromino getNext();
}
