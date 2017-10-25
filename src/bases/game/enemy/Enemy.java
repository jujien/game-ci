package bases.game.enemy;

import bases.GameObject;
import bases.Utils;
import bases.game.enemy.explosions.EnemyExplosion;
import bases.game.physics.BoxCollider;
import bases.game.physics.PhysicsBody;
import bases.renderes.Animation;

public class Enemy extends GameObject implements PhysicsBody {
    EnemyShoot enemyShoot;
    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new Animation(3,
                        Utils.loadImage("assets/images/enemies/level0/blue/0.png"),
                        Utils.loadImage("assets/images/enemies/level0/blue/1.png"),
                        Utils.loadImage("assets/images/enemies/level0/blue/2.png"),
                        Utils.loadImage("assets/images/enemies/level0/blue/3.png")
        );
        this.enemyShoot = new EnemyShoot();
        this.boxCollider = new BoxCollider(30, 30);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0, 0.5f);
        //this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    public void getHit() {
        this.isActive = false;
        EnemyExplosion enemyExplosion = GameObject.recycle(EnemyExplosion.class);
        enemyExplosion.position = this.position;
    }
}
