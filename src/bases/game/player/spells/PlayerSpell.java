package bases.game.player.spells;

import bases.GameObject;
import bases.game.physics.BoxCollider;
import bases.renderes.ImageRenderer;

public class PlayerSpell extends GameObject {
    public BoxCollider boxCollider;
    HitEnemy hitEnemy;

    public PlayerSpell() {
        this.renderer = new ImageRenderer("assets/images/player-spells/a/0.png");
        this.boxCollider = new BoxCollider(20, 20);
        this.hitEnemy = new HitEnemy();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(0, 10);
        this.boxCollider.position.set(this.position);
        this.hitEnemy.run(this);
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (this.position.y < 0) {
            this.isActive = false;
        }
    }
}
