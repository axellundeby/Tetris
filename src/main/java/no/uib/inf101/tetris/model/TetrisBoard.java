package no.uib.inf101.tetris.model;



import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character>{

    public TetrisBoard(int rows, int columns) {
        super(rows, columns, '-');
    }

    /**
     * returns a string representation of the grid with tetrominos
     * @return a string representation of the current state of the grid.
     */
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

    /**
     * Checks if a given row contains a given character, if the cell on the 
     * given row contais the given character the method returns true
     * @param rows a given row
     * @param c a given character
     * @return a true if the given character is found on the given row
     */

    private boolean elementOnRow(int rows, char c){
        for (int i = 0; i < cols(); i++) {
            CellPosition pos = new CellPosition(rows, i);
            if(this.get(pos) == c){
                return true;
            }
        }
        return false;
    } 

    /**
     * Sets a given character in all cells on a given row
     * @param rows a given row
     * @param c a given character
     */

    private void setValueToCell(int rows, char c){
        for (int i = 0; i < cols(); i++) {
            CellPosition pos = new CellPosition(rows, i);
            set(pos, c);
    }
    }

    /**
     * copys all values in a row and pastes the copy in another given row
     * @param Copyrows a given copied row
     * @param insertRow a given row we want to insert the copied row into
     */
    private void copyRow(int Copyrows, int insertRow){
        for (int i = 0; i < cols(); i++) {
            CellPosition Copypos = new CellPosition(Copyrows, i);
            CellPosition insertPos = new CellPosition(insertRow, i);    
            set(insertPos,get(Copypos));
            }
        }
    
    /**
     * remove all rows that are full
     * @return a number of removed rowes
     */

    public int rowsRemoved(){
        int count = 0;
        int a = rows() - 1;
        int b = rows() - 1;

        while (a >= 0){
            while(b >= 0 && !(elementOnRow(b,'-'))){
                count += 1;
                b -= 1;
            }
                if(b >= 0){
                    copyRow(b, a);
                }
                else{
                    setValueToCell(a, '-');
                }
            
                a -= 1;
                b -= 1;
        }
        return count;
    }

}