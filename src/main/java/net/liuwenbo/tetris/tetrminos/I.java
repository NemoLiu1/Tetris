package net.liuwenbo.tetris.tetrminos;

import net.liuwenbo.tetris.Block;
import net.liuwenbo.tetris.ImageUtils;
import net.liuwenbo.tetris.Tetrmino;

import java.awt.image.BufferedImage;

public class I extends Tetrmino {

    public I() {
        this.blocks[0] = new Block(1,3, ImageUtils.BLOCK_I);
        this.blocks[1] = new Block(1,4, ImageUtils.BLOCK_I);
        this.blocks[2] = new Block(1,5, ImageUtils.BLOCK_I);
        this.blocks[3] = new Block(1,6, ImageUtils.BLOCK_I);
        rotationPosition = new int[][][]{
                {{0, -1}, {0, +1}, {0, +2}}, // case 0
                {{-1, 0}, {+1, 0}, {+2, 0}}, // case 1
                {{0, +1}, {0, -1}, {0, -2}}, // case 2
                {{+1, 0}, {-1, 0}, {-2, 0}}, // case 3
        };
    }
}
