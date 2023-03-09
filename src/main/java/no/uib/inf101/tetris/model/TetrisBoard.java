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

    private boolean elementOnRow(int rows, char c){
        for (int i = 0; i < cols(); i++) {
            CellPosition pos = new CellPosition(rows, i);
            if(this.get(pos) == c){
                return true;
            }
        }
        return false;
    } 

    private void setValueToCell(int rows, char c){
        for (int i = 0; i < cols(); i++) {
            CellPosition pos = new CellPosition(rows, i);
            set(pos, c);
    }
    }

    private void copyRow(int Copyrows, int insertRow){
        for (int i = 0; i < cols(); i++) {
            CellPosition Copypos = new CellPosition(Copyrows, i);
            CellPosition insertPos = new CellPosition(insertRow, i);    
            set(insertPos,get(Copypos));
            }
        }
        

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