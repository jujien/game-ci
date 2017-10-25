package bases.game.enemy;

import bases.FrameCounter;
import bases.GameObject;
import bases.game.enemy.bullet.Bullet;

public class EnemyShoot {
    private boolean disabled;
    private FrameCounter frameCounter;
    private final int MAX_COUNT = 7;

    public EnemyShoot() {
        this.frameCounter = new FrameCounter(this.MAX_COUNT);
    }

    public void run(Enemy enemy){
        if (this.disabled) {
            if (this.frameCounter.run()) {
                this.disabled = false;
                this.frameCounter.reset();
            }
            return;
        }
        Bullet bullet = new Bullet();
        bullet.position.set(enemy.position.add(0, 20.0f));
        GameObject.add(bullet);
        this.disabled = true;
    }
}
