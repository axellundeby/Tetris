package no.uib.inf101.tetris.controller;

import java.awt.event.KeyEvent;

import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.view.TetrisView;


public class TetrisController implements java.awt.event.KeyListener{
    private final ControllableTetrisModel controllmodel;
    private final TetrisView view;

    public TetrisController(ControllableTetrisModel controllmodel, TetrisView view){
        this.view=view;
        this.controllmodel=controllmodel;

        view.addKeyListener(this);
        view.setFocusable(true);


    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(controllmodel.getGamestate() == GameState.ACTIVE_GAME){
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            controllmodel.moveTetromino(0, -1);
            view.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            controllmodel.moveTetromino(0, 1);
            view.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            controllmodel.moveTetromino(1, 0);
            view.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            controllmodel.rotateTetromino();
            view.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            controllmodel.tetrominoDrop();
            view.repaint();
        }
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
