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
    
    public Tetromino shiftedBy(int deltaRow , int deltaCol){
        CellPosition pos =  new CellPosition(this.pos.row() + deltaRow, this.pos.col() +  deltaCol);
        Tetromino ShapeCopy = new Tetromino(c, shape, pos);
        return ShapeCopy;
    }


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

}