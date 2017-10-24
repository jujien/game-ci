package bases.game.enemy.bullet;

import bases.GameObject;
import bases.renderes.ImageRenderer;

public class Bullet extends GameObject {

    public Bullet() {
        this.renderer = new ImageRenderer("assets/images/enemies/bullets/white.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0, 3);
    }
}
