package net.liuwenbo.tetris.tetrminos;

import net.liuwenbo.tetris.Block;
import net.liuwenbo.tetris.ImageUtils;
import net.liuwenbo.tetris.Tetrmino;

public class T extends Tetrmino {
    public T() {
        this.blocks[0] = new Block(0,4, ImageUtils.BLOCK_T);
        this.blocks[2] = new Block(1,3, ImageUtils.BLOCK_T);
        this.blocks[1] = new Block(1,4, ImageUtils.BLOCK_T);
        this.blocks[3] = new Block(1,5, ImageUtils.BLOCK_T);
        rotationPosition = new int[][][]{
                {{-1, 0}, {0, -1}, {0, +1}}, // case 0
                {{-1, 0}, {0, +1}, {+1, 0}}, // case 1
                {{0, -1}, {0, +1}, {+1, 0}}, // case 2
                {{-1, 0}, {0, -1}, {+1, 0}}, // case 3
        };
    }

    @Override
    public void reset() {
        this.blocks[0] = new Block(0,4, ImageUtils.BLOCK_T);
        this.blocks[2] = new Block(1,3, ImageUtils.BLOCK_T);
        this.blocks[1] = new Block(1,4, ImageUtils.BLOCK_T);
        this.blocks[3] = new Block(1,5, ImageUtils.BLOCK_T);
        rotationState = 20000;
    }
}

