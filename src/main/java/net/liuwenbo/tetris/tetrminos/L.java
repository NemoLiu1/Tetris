package net.liuwenbo.tetris.tetrminos;

import net.liuwenbo.tetris.Block;
import net.liuwenbo.tetris.ImageUtils;
import net.liuwenbo.tetris.Tetrmino;

public class L extends Tetrmino {
    public L() {
        this.blocks[0] = new Block(0,5, ImageUtils.BLOCK_L);
        this.blocks[2] = new Block(1,3, ImageUtils.BLOCK_L);
        this.blocks[1] = new Block(1,4, ImageUtils.BLOCK_L);
        this.blocks[3] = new Block(1,5, ImageUtils.BLOCK_L);
        rotationPosition = new int[][][]{
                {{-1, +1}, { 0, -1}, { 0, +1}}, // case 0
                {{-1,  0}, {+1,  0}, {+1, +1}}, // case 1
                {{ 0, -1}, { 0, +1}, {+1, -1}}, // case 2
                {{-1, -1}, {-1,  0}, {+1,  0}}, // case 3
        };
    }

    @Override
    public void reset() {
        this.blocks[0] = new Block(0,5, ImageUtils.BLOCK_L);
        this.blocks[2] = new Block(1,3, ImageUtils.BLOCK_L);
        this.blocks[1] = new Block(1,4, ImageUtils.BLOCK_L);
        this.blocks[3] = new Block(1,5, ImageUtils.BLOCK_L);
        rotationState = 20000;
    }
}
