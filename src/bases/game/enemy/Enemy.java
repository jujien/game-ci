package bases.game.enemy;

import bases.GameObject;
import bases.game.physics.BoxCollider;
import bases.game.physics.PhysicsBody;
import bases.renderes.ImageRenderer;

public class Enemy extends GameObject implements PhysicsBody {
    EnemyShoot enemyShoot;
    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new ImageRenderer("assets/images/enemies/level0/blue/0.png");
        this.enemyShoot = new EnemyShoot();
        this.boxCollider = new BoxCollider(30, 30);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0, 0.5f);
        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
