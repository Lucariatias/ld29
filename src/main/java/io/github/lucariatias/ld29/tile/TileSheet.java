package io.github.lucariatias.ld29.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TileSheet {

    private BufferedImage image;
    private int tileHeight;
    private int tileWidth;

    private BufferedImage[][] tileCache;

    public TileSheet(BufferedImage image, int tileHeight, int tileWidth) {
        this.image = image;
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        tileCache = new BufferedImage[image.getWidth() / tileWidth][image.getHeight() / tileHeight];
    }

    public TileSheet(String path, int tileHeight, int tileWidth) {
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
    }

    public BufferedImage getImage(int col, int row) {
        BufferedImage image;
        if (tileCache[col][row] == null) {
            image = this.image.getSubimage(tileWidth * col, tileHeight * row, tileWidth, tileHeight);
            tileCache[col][row] = image;
        } else {
            image = tileCache[col][row];
        }
        return image;
    }

}
