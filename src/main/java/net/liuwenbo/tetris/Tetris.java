package net.liuwenbo.tetris;

import net.liuwenbo.tetris.tetrminos.I;
import net.liuwenbo.tetris.tetrminos.O;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Tetris extends JPanel {

    private Tetrmino fallingTetrimino = Tetrmino.generateNewTetrmino();
    private Tetrmino waitingTetrimino_1 = Tetrmino.generateNewTetrmino();
    private Tetrmino waitingTetrimino_2 = Tetrmino.generateNewTetrmino();
    private Tetrmino waitingTetrimino_3 = Tetrmino.generateNewTetrmino();
    private Tetrmino holdingTetrimino = null;
    private Matrix matrix = new Matrix();
    private Scores currentScores = new Scores();
    private BufferedImage background = ImageUtils.BACKGROUND;
    private Font scoreFont = new Font("score font", Font.BOLD, 17);
    private boolean haveHeldThisTurn = false;
    private int linesCleared = 0;
    private int dropIndex = 0;
    private int frameRate = 25;
    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            dropIndex++;
            if (dropIndex % frameRate == 0) {
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
        g.setFont(scoreFont);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(currentScores.getCurrentScore()), 110, 398);
        g.drawString(Integer.toString(currentScores.getTotalClearedLines()), 110, 519);
        matrix.paint(g);
        fallingTetrimino.paint(g, 40, 270);
        waitingTetrimino_1.paint(g, 100, 525);
        waitingTetrimino_2.paint(g, 178, 525);
        waitingTetrimino_3.paint(g, 244, 525);
        if (holdingTetrimino != null) {
            if (holdingTetrimino instanceof I) {
                holdingTetrimino.paint(g, 97, 12);
            } else if (holdingTetrimino instanceof O) {
                holdingTetrimino.paint(g, 110, 12);
            } else {
                holdingTetrimino.paint(g, 110, 25);
            }
        }
    }

    boolean test = fallingTetrimino.blocks[1].getRow() == waitingTetrimino_1.blocks[1].getRow();

    public void isGameOver() {
        for (int i = 0; i < 4; i++) {
//            if (fallingTetrimino.blocks[i].getRow() == 0 &&
//                    ((fallingTetrimino.blocks[i].getRow() == waitingTetrimino_1.blocks[i].getRow()) &&
//                            (fallingTetrimino.blocks[i].getColumn() == waitingTetrimino_1.blocks[i].getColumn()))) {
//                System.out.println("game over");
//            }
            if (matrix.get(fallingTetrimino.blocks[i].getRow(), fallingTetrimino.blocks[i].getColumn()) != null) {
                System.out.println("game over");
            }
        }
    }

    public void dropDown() {
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

        currentScores.addScoreForLineClear(linesCleared);
        linesCleared = 0;
    }

    private void softDrop() {
        isGameOver();
        if (fallingTetrimino.isLanded(matrix)) {
            fallingTetrimino.enterMatrix(matrix);
            dropDown();
            nextTetrimino();

            haveHeldThisTurn = false;
        } else {
            fallingTetrimino.moveDown();
            currentScores.addScoreForSoftDrop(1);
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
            holdingTetrimino.reset();
            nextTetrimino();
            System.out.println(1);
        } else if (! haveHeldThisTurn) {
            Tetrmino temperateTetrimino = fallingTetrimino;
            fallingTetrimino = holdingTetrimino;
            holdingTetrimino = temperateTetrimino;
            holdingTetrimino.reset();
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
