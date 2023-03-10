package no.uib.inf101.tetris.cont;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.view.TetrisView;
import no.uib.inf101.tetris.midi.TetrisSong;




public class TetrisController implements java.awt.event.KeyListener{
    private final ControllableTetrisModel controllmodel;
    private final TetrisView view;
    private final Timer timer;
    private final TetrisSong song = new TetrisSong();
    

    public TetrisController(ControllableTetrisModel controllmodel, TetrisView view){
        this.view=view;
        this.controllmodel=controllmodel;
        view.addKeyListener(this);
        view.setFocusable(true);
        this.timer = new Timer(controllmodel.droptimer(), this::clockTick);
        timer.start();
        song.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(controllmodel.getGamestate() == GameState.ACTIVE_GAME){
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            controllmodel.moveTetromino(0, -1);
        
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            controllmodel.moveTetromino(0, 1);
  
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            controllmodel.moveTetromino(1, 0);

        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            controllmodel.rotateTetromino();

        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            controllmodel.tetrominoDrop();
        }
    }
    view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    //spør vilde om override
    public void clockTick(ActionEvent e){
        controllmodel.clockTick();
        view.repaint();

    }
}
