package bases.game.player;

import bases.GameObject;
import bases.game.physics.BoxCollider;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerConstraints playerConstraints;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;
    BoxCollider boxCollider;
    HitPlayer hitPlayer;

    public Player() {
        this.playerAnimator = new PlayerAnimator();
        this.renderer = this.playerAnimator;
        this.playerMove = new PlayerMove();
        this.playerConstraints = new PlayerConstraints();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(8, 8);
        this.hitPlayer = new HitPlayer();
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.playerConstraints.run(this);
        this.playerAnimator.run(this);
        this.boxCollider.position = this.position;
        this.hitPlayer.run(this);
    }
}
