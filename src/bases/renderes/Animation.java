package bases.renderes;

import bases.FrameCounter;
import bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation implements Renderer {

    BufferedImage[] images;
    int currentImageIndex;
    FrameCounter frameCounter;
    boolean repeat;
    public boolean disable;

    public Animation(boolean repeat, int frameInterval, BufferedImage... images) {
        this.images = images;
        this.currentImageIndex = 0;
        this.frameCounter = new FrameCounter(frameInterval);
        this.repeat = repeat;
        this.disable = false;
    }

    public Animation(int frameInterval, BufferedImage... images) {
        this(true, frameInterval, images);
    }

    public void reset() {
        this.disable = false;
        this.currentImageIndex = 0;
    }

    @Override
    public void render(Graphics2D graphics, Vector2D position) {
        if (this.disable) return;
        BufferedImage image = this.images[this.currentImageIndex];
        graphics.drawImage(image,
                (int)(position.x - image.getWidth() / 2.0),
                (int) (position.y - image.getHeight() / 2.0),
                null);
        if (this.currentImageIndex == this.images.length - 1 && !this.repeat) {
            this.disable = true;
        } else {
            if (this.frameCounter.run()) {
                this.changeFrame();
                this.frameCounter.reset();
            }
        }
    }

    private void changeFrame() {
        if (currentImageIndex >= this.images.length - 1) {
            this.currentImageIndex = 0;
        } else {
            this.currentImageIndex++;
        }
    }
}
