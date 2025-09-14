package net.liuwenbo.tetris;

import java.awt.*;

public class Matrix {
    public static final int MATRIX_ROW_SIZE = 20;
    public static final int MATRIX_COLUMN_SIZE = 10;

    Block[][] matrix = new Block[MATRIX_ROW_SIZE][MATRIX_COLUMN_SIZE];

    public Matrix() {
//        matrix[10][9] = new Block(10,9, ImageUtils.BLOCK_I);
//        matrix[10][8] = new Block(10,8, ImageUtils.BLOCK_I);
//        matrix[10][7] = new Block(10,7, ImageUtils.BLOCK_I);
//
//        matrix[15][0] = new Block(15,0, ImageUtils.BLOCK_I);
//        matrix[15][1] = new Block(15,1, ImageUtils.BLOCK_I);
//        matrix[15][2] = new Block(15,2, ImageUtils.BLOCK_I);
    }

    public Block get(int row, int column) {
        if (row > 19 || row < 0 || column > 9 || column < 0) {
            return null;
        }
        return matrix[row][column];
    }

//    public int isRowFull() {
//        for (int i = MATRIX_ROW_SIZE - 1; i >= 0  ; i--) {
//            int count = 0;
//            for (int j = 0; j < MATRIX_COLUMN_SIZE; j++) {
//                if (matrix[i][j] != null) {
//                    count++;
//                }
//            }
//            if (count == 10) {
//                return i;
//            }
//        }
//        return -1;
//    }
    public boolean isRowFull(int row) {
        int count = 0;
        for (int j = 0; j < MATRIX_COLUMN_SIZE; j++) {
            if (matrix[row][j] != null) {
                count++;
            }
        }
        return count == MATRIX_COLUMN_SIZE;
    }

    public void clearARow(int row) {
        for (int i = 0; i < MATRIX_COLUMN_SIZE; i++) {
            matrix[row][i] = null;
        }
    }

    public void moveAllBlocksDown(int row) {
        for (int i = row - 1; i > 0; i--) {
            for (int j = 0; j < MATRIX_COLUMN_SIZE; j++) {
                matrix[i + 1][j] = matrix[i][j];
            }
        }

        for (int j = 0; j < MATRIX_COLUMN_SIZE; j++) {
            matrix[0][j] = null;
        }
    }

    // thought that the get method are being used too often
    // so i have overload the method.

//    public void set(int row, int column, Block block) {
//        matrix[row][column] = block;
//    }

    public void set(Block block) {
        matrix[block.getRow()][block.getColumn()] = block;
    }

    public void paint(Graphics g) {
        int x = 270;
        int y = 40;
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 10; col++) {
                if (matrix[row][col] != null) {
                    g.drawImage(matrix[row][col].getImage(), x, y, null);
                }

                x += 26;
            }
            x = 270;
            y += 26;
        }
    }
}
