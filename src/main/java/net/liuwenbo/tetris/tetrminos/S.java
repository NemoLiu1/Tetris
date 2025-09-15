package net.liuwenbo.tetris.tetrminos;

import net.liuwenbo.tetris.Block;
import net.liuwenbo.tetris.ImageUtils;
import net.liuwenbo.tetris.Tetrmino;

public class S extends Tetrmino {
    public S() {
        this.blocks[0] = new Block(0,4, ImageUtils.BLOCK_S);
        this.blocks[1] = new Block(0,5, ImageUtils.BLOCK_S);
        this.blocks[2] = new Block(1,3, ImageUtils.BLOCK_S);
        this.blocks[3] = new Block(1,4, ImageUtils.BLOCK_S);
        rotationPosition = new int[][][]{
                {{ 0, +1}, {+1, -1}, {+1,  0}}, // case 0
                {{-1, -1}, { 0, -1}, {+1,  0}}, // case 1
                {{-1,  0}, {-1, +1}, { 0, -1}}, // case 2
                {{-1,  0}, { 0, +1}, {+1, +1}}, // case 3
        };
    }

    @Override
    public void reset() {
        this.blocks[0] = new Block(0,4, ImageUtils.BLOCK_S);
        this.blocks[1] = new Block(0,5, ImageUtils.BLOCK_S);
        this.blocks[2] = new Block(1,3, ImageUtils.BLOCK_S);
        this.blocks[3] = new Block(1,4, ImageUtils.BLOCK_S);
        rotationState = 20000;
    }
}
