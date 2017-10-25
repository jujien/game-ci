package bases.game.player;

import bases.GameObject;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerConstraints playerConstraints;
    PlayerShoot playerShoot;
    PlayerAnimator playerAnimator;

    public Player() {
        this.playerAnimator = new PlayerAnimator();
        this.renderer = this.playerAnimator;
        this.playerMove = new PlayerMove();
        this.playerConstraints = new PlayerConstraints();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.playerConstraints.run(this);
        this.playerAnimator.run(this);
    }
}
