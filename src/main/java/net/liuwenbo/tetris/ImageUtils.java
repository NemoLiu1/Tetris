package net.liuwenbo.tetris;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageUtils {
    public static final BufferedImage BACKGROUND;
    public static final BufferedImage BLOCK_I;
    public static final BufferedImage BLOCK_J;
    public static final BufferedImage BLOCK_L;
    public static final BufferedImage BLOCK_O;
    public static final BufferedImage BLOCK_S;
    public static final BufferedImage BLOCK_T;
    public static final BufferedImage BLOCK_Z;

    static {
        System.out.println("Initialing");
        BACKGROUND = initializeImage("/meterial/tetris_background.png");
        BLOCK_I = initializeImage("/meterial/tetris_I.png");
        BLOCK_J = initializeImage("/meterial/tetris_J.png");
        BLOCK_L = initializeImage("/meterial/tetris_L.png");
        BLOCK_O = initializeImage("/meterial/tetris_O.png");
        BLOCK_S = initializeImage("/meterial/tetris_S.png");
        BLOCK_T = initializeImage("/meterial/tetris_T.png");
        BLOCK_Z = initializeImage("/meterial/tetris_Z.png");

//        System.out.println(BACKGROUND);
//        System.out.println(BLOCK_I);
//        System.out.println(BLOCK_J);
//        System.out.println(BLOCK_L);
//        System.out.println(BLOCK_O);
//        System.out.println(BLOCK_S);
//        System.out.println(BLOCK_T);
//        System.out.println(BLOCK_Z);
    }
    
    private static BufferedImage initializeImage(String path) {
        BufferedImage image;
        //InputStream in = ImageUtils.class.getResourceAsStream(path);
        URL url = ImageUtils.class.getResource(path);
        try {
            System.out.println(url);
            image = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return image;
    }

}
