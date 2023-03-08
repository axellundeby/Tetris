package no.uib.inf101.model.Tetromino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.tetromino.Tetromino;

public class tetrominoIterationOfS {
    @Test
public void tetrominoIterationOfS() {
  // Create a standard 'T' tetromino placed at (10, 100) to test
  Tetromino tetro = Tetromino.newTetromino('S');
  tetro = tetro.shiftedBy(10, 100);

  // Collect which objects are iterated through
  List<GridCell<Character>> objs = new ArrayList<>();
  for (GridCell<Character> gc : tetro) {
    objs.add(gc);
  }

  // Check that we got the expected GridCell objects
  assertEquals(4, objs.size());
  assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 100), 'S')));
  assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 101), 'S')));
  assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 102), 'S')));
  assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 101), 'S')));
}

}
