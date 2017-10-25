package bases.game.enemy.explosions;

import bases.GameObject;
import bases.Utils;
import bases.renderes.Animation;

public class EnemyExplosion extends GameObject {
    Animation animation;
    public EnemyExplosion() {
        this.animation = new Animation(false, 2,
                Utils.loadImage("assets/images/enemies/explosion/0.png"),
                Utils.loadImage("assets/images/enemies/explosion/1.png"),
                Utils.loadImage("assets/images/enemies/explosion/2.png"),
                Utils.loadImage("assets/images/enemies/explosion/3.png"),
                Utils.loadImage("assets/images/enemies/explosion/4.png"),
                Utils.loadImage("assets/images/enemies/explosion/5.png"),
                Utils.loadImage("assets/images/enemies/explosion/6.png"),
                Utils.loadImage("assets/images/enemies/explosion/7.png"));
        this.renderer = this.animation;
    }

    @Override
    public void run() {
        super.run();
        if (this.animation.disable) {
            this.isActive = false;
            this.animation.reset();
        }
    }
}
