package net.liuwenbo.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Tetris extends JPanel {
//    public static final int[] POINTS = {
//            1, // soft drop
//            2, // hard drop
//            100, // single line clear
//            300, // double line clear
//            500, // triple line clear
//            800, // Tetris or 4 line clear
//            400, // T-spin
//            800, // T-spin Single
//            1200, // T-spin Double
//            1600, // T-spin Triple
//            // currently missing "back-to-back (0.5 * Tetris or T-spin)"
//    };
    private Tetrmino fallingTetrimino = Tetrmino.generateNewTetrmino();
    private Tetrmino waitingTetrimino_1 = Tetrmino.generateNewTetrmino();
    private Tetrmino waitingTetrimino_2 = Tetrmino.generateNewTetrmino();
    private Tetrmino waitingTetrimino_3 = Tetrmino.generateNewTetrmino();
    private Tetrmino holdingTetrimino = null;
    private boolean haveHeldThisTurn = false;
    private Matrix matrix = new Matrix();
    private BufferedImage background = ImageUtils.BACKGROUND;
    private int dropIndex = 0;
    private int frameRate = 25;
    private int score = 0;
    private int linesCleared = 0;
    private int scoreIndex = 1;
    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            dropIndex++;
            if (dropIndex % frameRate == 0) {
                score += scoreIndex;
                softDrop();
                repaint();
            }
        }
    };

    public Tetris() {
        timer.scheduleAtFixedRate(timerTask, 0, 40);
    }

    public void nextTetrimino() {
        fallingTetrimino = waitingTetrimino_1;
        waitingTetrimino_1 = waitingTetrimino_2;
        waitingTetrimino_2 = waitingTetrimino_3;
        waitingTetrimino_3 = Tetrmino.generateNewTetrmino();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, this);
        matrix.paint(g);
        fallingTetrimino.paint(g, 40, 270);
        waitingTetrimino_1.paint(g, 100, 525);
        waitingTetrimino_2.paint(g, 178, 525);
        waitingTetrimino_3.paint(g, 244, 525);
    }

    public void dropDown() {
//        while (matrix.isRowFull() != -1) {
//            int fullRowIndex = matrix.isRowFull();
//            matrix.clearARow(fullRowIndex);
//            matrix.moveAllBlocksDown(fullRowIndex);
//        }
        boolean foundFullRow;
        do {
            foundFullRow = false;
            // 从底部向上检查每一行
            for (int i = Matrix.MATRIX_ROW_SIZE - 1; i >= 0; i--) {
                if (matrix.isRowFull(i)) {
                    linesCleared++;
                    matrix.clearARow(i);
                    matrix.moveAllBlocksDown(i);
                    foundFullRow = true;
                    // 清除一行后，由于上面的行下移，需要重新从底部开始检查
                    break;
                }
            }
        } while (foundFullRow);
    }

//    public void calculateScore() {
//        switch (linesCleared) {
//            case 1:
//                score += POINTS[];
//        }
//        score += 100;
//    }

    private void softDrop() {
        if (fallingTetrimino.isLanded(matrix)) {
            fallingTetrimino.enterMatrix(matrix);
            dropDown();
            nextTetrimino();
//            calculateScore();
            linesCleared = 0;
            haveHeldThisTurn = false;
        } else {
            fallingTetrimino.moveDown();
//            score += POINTS[1];
        }
        repaint();
    }

    private void moveLeft() {
        fallingTetrimino.moveLeft();
        repaint();
    }

    private void moveRight() {
        fallingTetrimino.moveRight();
        repaint();
    }

    private void rotateRight() {
        if (fallingTetrimino.canRotateRight(matrix)) {
            fallingTetrimino.rotate(Tetrmino.ROTATE_RIGHT);
            repaint();
        }
    }

    private void rotateLeft() {
        if (fallingTetrimino.canRotateLeft(matrix)) {
            fallingTetrimino.rotate(Tetrmino.ROTATE_LEFT);
            repaint();
        }
    }

    private void holdTetrmino() {
        if (holdingTetrimino == null) {
            holdingTetrimino = fallingTetrimino;
            nextTetrimino();
            System.out.println(1);
        } else if (! haveHeldThisTurn) {
            Tetrmino temperateTetrimino = fallingTetrimino;
            fallingTetrimino = holdingTetrimino;
            holdingTetrimino = temperateTetrimino;
            repaint();

            haveHeldThisTurn = true;
        }
    }


    public void keyPressed(int key) {
        if (key == KeyEvent.VK_DOWN) {
            softDrop();
        }
        if (key == KeyEvent.VK_LEFT &&
                fallingTetrimino.canMoveLeft(matrix)) {
            moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT &&
                fallingTetrimino.canMoveRight(matrix)) {
            moveRight();
        }
        if (key == KeyEvent.VK_E) {
            rotateRight();
        }
        if (key == KeyEvent.VK_Q) {
            rotateLeft();
        }
        if (key == KeyEvent.VK_C) {
            holdTetrmino();
        }
    }
}
