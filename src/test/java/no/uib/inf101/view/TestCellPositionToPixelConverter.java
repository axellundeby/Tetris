
package no.uib.inf101.view;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.TetrisBoard;
import no.uib.inf101.tetris.view.CellPositionToPixelConverter;

import java.awt.geom.Rectangle2D;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
public class TestCellPositionToPixelConverter {
    @Test
public void sanityTest() {
  GridDimension gd = new TetrisBoard(3, 4);
  CellPositionToPixelConverter converter = new CellPositionToPixelConverter(
      new Rectangle2D.Double(29, 29, 340, 240), gd, 30
  );
  Rectangle2D expected = new Rectangle2D.Double(214, 129, 47.5, 40);
  assertEquals(expected, converter.getBoundsForCell(new CellPosition(1, 2)));
}

}
