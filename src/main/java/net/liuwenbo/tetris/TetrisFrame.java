package net.liuwenbo.tetris;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisFrame extends JFrame {
    Tetris tetris = new Tetris();

    public TetrisFrame() {
        this.setTitle("Tetris");
        this.add(tetris);
        this.setSize(800, 630);
        this.requestFocus();

        KeyListener keyListener = new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                tetris.keyPressed(key);
                System.out.println("Key: " + key);
            }
        };
        this.addKeyListener(keyListener);
    }

    public static void main(String[] args) {
        TetrisFrame tetrisFrame = new TetrisFrame();
        tetrisFrame.setVisible(true);
    }
}
