package net.liuwenbo.tetris;

import net.liuwenbo.tetris.tetrminos.*;

import java.awt.*;
import java.util.Random;

public abstract class Tetrmino {
    public static final int ROTATE_RIGHT = 1;
    public static final int ROTATE_LEFT = -1;

    protected Block[] blocks = new Block[4];
    protected int[][][] rotationPosition;

    protected int rotationState = 20000;

    public abstract void reset();

    public void rotate(int rotateFactor) {
        rotationState += rotateFactor;
        int i = rotationState % 4;
        int[][] position = rotationPosition[i];
        blocks[0].setRow   (blocks[1].getRow()    + position[0][0]);
        blocks[0].setColumn(blocks[1].getColumn() + position[0][1]);
        blocks[2].setRow   (blocks[1].getRow()    + position[1][0]);
        blocks[2].setColumn(blocks[1].getColumn() + position[1][1]);
        blocks[3].setRow   (blocks[1].getRow()    + position[2][0]);
        blocks[3].setColumn(blocks[1].getColumn() + position[2][1]);
    }

    public static Tetrmino generateNewTetrmino() {
        Random random = new Random();
        int randomNum = random.nextInt(7);
//        int randomNum = ;
        switch (randomNum) {
            case 0:
                return new I();
            case 1:
                return new T();
            case 2:
                return new L();
            case 3:
                return new O();
            case 4:
                return new S();
            case 5:
                return new J();
            case 6:
                return new Z();
        }
        return null;
    }

    public boolean canRotateRight(Matrix matrix) {
        rotate(Tetrmino.ROTATE_RIGHT);
        for (int i = 0; i < blocks.length; i++) {
            if (matrix.get(blocks[i].getRow(), blocks[i].getColumn()) != null ||
                    !(blocks[i].getColumn() < 10 && blocks[i].getColumn() >= 0)) {
                rotate(Tetrmino.ROTATE_LEFT);
                return false;
            }
        }
        rotate(Tetrmino.ROTATE_LEFT);
        return true;
    }

    public boolean canRotateLeft(Matrix matrix) {
        rotate(Tetrmino.ROTATE_LEFT);
        for (int i = 0; i < blocks.length; i++) {
            if (matrix.get(blocks[i].getRow(), blocks[i].getColumn()) != null ||
                    !(blocks[i].getColumn() < 10 && blocks[i].getColumn() >= 0)) {
                rotate(Tetrmino.ROTATE_RIGHT);
                return false;
            }
        }
        rotate(Tetrmino.ROTATE_RIGHT);
        return true;
    }

    public void moveDown() {
        for (int i = 0; i < 4; i++) {
            blocks[i].setRow(blocks[i].getRow() + 1);
        }
    }

    public void moveLeft() {
        for (int i = 0; i < 4; i++) {
            blocks[i].setColumn(blocks[i].getColumn() - 1);
        }
    }

    public void moveRight() {
        for (int i = 0; i < 4; i++) {
            blocks[i].setColumn(blocks[i].getColumn() + 1);
        }
    }

    // out dated method, probably* will not be used in the future
//    public boolean canMoveDown(Matrix matrix) {
//        for (int i = 0; i < 4; i++) {
//            if (blocks[i].getRow() + 1 > 19) {
//                System.out.println("The action of moving Tetrmino to downward will be out of boundary");
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean canMoveLeft(Matrix matrix) {
        for (int i = 0; i < 4; i++) {
            if (blocks[i].getColumn() - 1 < 0) {
                System.out.println("The action of moving Tetrmino to left will be out of boundary");
                return false;
            }

            if (! (matrix.get(blocks[i].getRow(), blocks[i].getColumn() - 1) == null)) {
                System.out.println("The action of moving Tetrmino to left will overlap with other existing block in Matrix");
                return false;
            }
        }
        return true;
    }

    public boolean canMoveRight(Matrix matrix) {
        for (int i = 0; i < 4; i++) {
            if (blocks[i].getColumn() + 1 > 9) {
                System.out.println("The action of moving Tetrmino to right will be out of boundary");
                return false;
            }

            if (! (matrix.get(blocks[i].getRow(), blocks[i].getColumn() + 1) == null)) {
                System.out.println("The action of moving Tetrmino to right will overlap with other existing block in Matrix");
                return false;
            }
        }
        return true;
    }

    public boolean isLanded(Matrix matrix) {
        for (int i = 0; i < 4; i++) {
            if (matrix.get(blocks[i].getRow() + 1, blocks[i].getColumn()) != null ||
                    blocks[i].getRow() + 1 > 19) {
                rotationState = 20000;
                return true;
            }
        }
        return false;
    }

    public void enterMatrix(Matrix matrix) {
        for (int i = 0; i < 4; i++) {
            matrix.set(blocks[i]);
        }
    }

    public void paint(Graphics g, int initialRow_Y, int initialColumn_X) {
        for (int i = 0; i < 4; i++) {
            blocks[i].paint(g, initialRow_Y, initialColumn_X);
        }
    }
}
