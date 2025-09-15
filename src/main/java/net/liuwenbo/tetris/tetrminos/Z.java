package net.liuwenbo.tetris.tetrminos;

import net.liuwenbo.tetris.Block;
import net.liuwenbo.tetris.ImageUtils;
import net.liuwenbo.tetris.Tetrmino;

public class Z extends Tetrmino {
    public Z() {
        reset();
        rotationPosition = new int[][][]{
                {{ 0, -1}, {+1,  0}, {+1, +1}}, // case 0
                {{-1,  0}, { 0, -1}, {+1, -1}}, // case 1
//                {{ 0, -1}, {+1,  0}, {+1, +1}}, // case 0
//                {{-1,  0}, { 0, -1}, {+1, -1}}, // case 1

                {{-1, -1}, {-1,  0}, { 0, +1}}, // case 2
                {{-1, +1}, { 0, +1}, {+1,  0}}, // case 3
        };
    }

    @Override
    public void reset() {
        this.blocks[0] = new Block(0,3, ImageUtils.BLOCK_Z);
        this.blocks[1] = new Block(0,4, ImageUtils.BLOCK_Z);
        this.blocks[2] = new Block(1,4, ImageUtils.BLOCK_Z);
        this.blocks[3] = new Block(1,5, ImageUtils.BLOCK_Z);
        rotationState = 20000;
    }
}
