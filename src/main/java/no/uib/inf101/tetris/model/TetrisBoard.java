package no.uib.inf101.tetris.model;


import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character>{

    public TetrisBoard(int rows, int columns) {
        super(rows, columns, '-');
    }

    public String prettyString(){
        String str = "";
        for (int i = 0; i < rows(); i++) {
            String cord = "";
            for (int j = 0; j < cols(); j++) {
                CellPosition pos = new CellPosition(i, j);
                cord += (this.get(pos));
            }
            str += cord + "\n";
            String.join("\n",new String[]{});
        }
        return str.strip();
    }
}
