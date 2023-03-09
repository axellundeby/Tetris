package no.uib.inf101.tetris.controller;

import java.awt.event.KeyEvent;

import javax.swing.Timer;

import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.view.TetrisView;
import java.awt.event.ActionEvent;


public class TetrisController implements java.awt.event.KeyListener{
    private final ControllableTetrisModel controllmodel;
    private final TetrisView view;
    private final Timer timer;

    public TetrisController(ControllableTetrisModel controllmodel, TetrisView view){
        this.view=view;
        this.controllmodel=controllmodel;
      

        view.addKeyListener(this);
        view.setFocusable(true);

        this.timer = new Timer(controllmodel.droptimer(), this::clockTick);
        timer.start();

    }

    @Override
    public void keyTyped(KeyEvent e) {
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

    }

    public void clockTick(ActionEvent e){
        controllmodel.clockTick();
        view.repaint();

    }
}
