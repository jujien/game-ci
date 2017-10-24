package bases.renderes;

import bases.Utils;
import bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer implements Renderer {

    public BufferedImage image;

    public ImageRenderer(BufferedImage image) {
        this.image = image;
    }

    public ImageRenderer(String url) {
        this.image = Utils.loadImage(url);
    }

    @Override
    public void render(Graphics2D graphics, Vector2D position) {
        graphics.drawImage(this.image, (int)position.x, (int)position.y, null);
    }
}
