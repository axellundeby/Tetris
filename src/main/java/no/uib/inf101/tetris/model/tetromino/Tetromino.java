package no.uib.inf101.tetris.model.tetromino;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public final class Tetromino implements Iterable<GridCell<Character>>{
    private final char c;
    private final boolean[][] shape;
    private final CellPosition pos;

    static final boolean[][] L  = new boolean[][] {
        { false, false, false },
        { true,  true,  true },
        { true,  false, false }
};

    static final boolean[][] J  = new boolean[][] {
        { false, false, false },
        {  true,  true,  true },
        { false,  false, true }
};
    static final boolean[][] S  = new boolean[][] {
        { false, false, false },
        {  false,  true,  true },
        { true,  true, false }
    
};
    static final boolean[][] Z  = new boolean[][] {
        { false, false, false },
        {  true,  true,  false },
        { false,  true, true }

};
    static final boolean[][] T  = new boolean[][] {
        { false, false, false },
        { true,  true,  true },
        { false,  true, false }
};
    static final boolean[][] I  = new boolean[][] {
        { false, false, false, false },
        { true, true,  true, true },
        { false,  false, false, false },
        { false,  false, false, false }
};
    static final boolean[][] O  = new boolean[][] {
        { false, false, false, false},
        { false, true, true, false },
        { false,  true, true, false },
        { false,  false, false, false }
};

    private Tetromino(char c, boolean[][] shape, CellPosition pos ){
        this.c=c;
        this.shape=shape;
        this.pos=pos;
    }
    /**
     * a switch method that
     * @param c a character that determines the tetromino
     * @return a new tetromino
     * @throws IllegalArgumentException if the character is not in the tetromino familiy 
     */

    public static Tetromino newTetromino(char c){
        CellPosition pos =  new CellPosition(0, 0);

        boolean[][] shape = switch(c) {
            case 'L' -> L;
            case 'J' -> J;
            case 'T' -> T;
            case 'Z' -> Z;
            case 'S' -> S;
            case 'I' -> I;
            case 'O' -> O;

        default -> throw new IllegalArgumentException(
            "Denne figuren er ikke gyldig(Ikke en av de 7 gyldige)");
      };
        
        Tetromino symbol = new Tetromino(c, shape, pos);
        return symbol; 
    }

    /**
     * creates a copy of a tetremono that indicate how long the copied shape was moved
     * @param deltaRow the row the copy is moved to
     * @param deltaCol the col the copy is moved to
     * @return the moved copy
     */
    
    public Tetromino shiftedBy(int deltaRow , int deltaCol){
        CellPosition pos =  new CellPosition(this.pos.row() + deltaRow, this.pos.col() +  deltaCol);
        Tetromino ShapeCopy = new Tetromino(c, shape, pos);
        return ShapeCopy;
    }

    /**
     * creates a copy of a tetremiono that is located at the centertop of the grid
     * @param Dimension the dimention of the grid
     * @return a top centerd tetromino 
     */

    public Tetromino shiftedToTopCenterOf(GridDimension Dimension){
        int cols = Dimension.cols();
        int centerCol = (cols - shape.length)/2;

        CellPosition pos = new CellPosition(-1, centerCol);
    
        Tetromino CenterdShapeCopy = new Tetromino(c, shape, pos);
        return CenterdShapeCopy;
    }

    @Override
    public Iterator<GridCell<Character>> iterator() {
        
        ArrayList<GridCell<Character>> ShapePosList = new ArrayList<GridCell<Character>>();
     
        for (int rowShape = 0; rowShape < shape.length; rowShape++) {
            for (int colShape = 0; colShape < shape[rowShape].length; colShape++) {
                CellPosition pos = new CellPosition(rowShape + this.pos.row(), colShape+ this.pos.col());
                
                if(shape[rowShape][colShape]){
                   GridCell<Character> cell = new GridCell<Character>(pos, c);
                   ShapePosList.add(cell);
                }
            }
        }
        return ShapePosList.iterator();
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(this.c, Arrays.deepHashCode(this.shape), this.pos);
    }

      @Override
      public boolean equals(Object obj) {
          if (obj == this) {
              return true;
          }
          if (!(obj instanceof Tetromino)) {
              return false;
          }
          Tetromino other = (Tetromino) obj;
          return this.c == other.c && Arrays.deepEquals(this.shape, other.shape) &&  this.pos.equals(other.pos);
      }
    
     /**
     * @return a new Tetromino object that is rotated 90 degrees clockwise.
     */
    public Tetromino rotateTetromino(){
        boolean[][] copiedShape = rotateClockWise(this.shape);
        return new Tetromino(c, copiedShape, pos);
    }

    /**
     * creates a copy of the shape, then the shape is rotated
     * @param Shape the shape that is beeing copied
     * @return the copiedrotated shape
     */
    private boolean[][] rotateClockWise(boolean[][] Shape) {
        int rows = Shape.length;
        int cols = Shape[0].length;
        boolean[][] copiedShape = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            copiedShape[i][j] = Shape[i][j];
        }
    }
    //fant denne koden på nett https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
    for (int i = 0; i < copiedShape.length / 2; i++){
        for (int j = i; j < copiedShape.length - i - 1; j++){
            boolean temp = copiedShape[i][j];
            copiedShape[i][j] = copiedShape[copiedShape.length - 1 - j][i];
            copiedShape[copiedShape.length - 1 - j][i] = copiedShape[copiedShape.length - 1 - i][copiedShape.length - 1 - j];
            copiedShape[copiedShape.length - 1 - i][copiedShape.length - 1 - j] = copiedShape[j][copiedShape.length - 1 - i];
            copiedShape[j][copiedShape.length - 1 - i] = temp;
        }
    }
    return copiedShape;
    }
}