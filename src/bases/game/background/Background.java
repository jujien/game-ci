package bases.game.background;

import bases.GameObject;
import bases.renderes.ImageRenderer;

public class Background extends GameObject {
    public Background() {
        this.renderer = new ImageRenderer("assets/images/background/0.png");
    }
}
