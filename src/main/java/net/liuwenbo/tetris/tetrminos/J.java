package net.liuwenbo.tetris.tetrminos;

import net.liuwenbo.tetris.Block;
import net.liuwenbo.tetris.ImageUtils;
import net.liuwenbo.tetris.Tetrmino;

public class J extends Tetrmino {
    public J() {
        this.blocks[0] = new Block(0,3, ImageUtils.BLOCK_J);
        this.blocks[1] = new Block(1,3, ImageUtils.BLOCK_J);
        this.blocks[2] = new Block(1,4, ImageUtils.BLOCK_J);
        this.blocks[3] = new Block(1,5, ImageUtils.BLOCK_J);
        rotationPosition = new int[][][]{
                {{-1, -1}, { 0, -1}, { 0, +1}}, // case 0
                {{-1,  0}, {-1, +1}, {+1,  0}}, // case 1
                {{ 0, -1}, { 0, +1}, {+1, +1}}, // case 2
                {{-1,  0}, {+1, -1}, {+1,  0}}, // case 3
        };
    }
}
