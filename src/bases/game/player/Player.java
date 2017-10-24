package bases.game.player;

import bases.GameObject;
import bases.renderes.ImageRenderer;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerConstraints playerConstraints;
    PlayerShoot playerShoot;

    public Player() {
        this.renderer = new ImageRenderer("assets/images/players/straight/0.png");
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
    }
}
