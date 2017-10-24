package bases.game.player;

import bases.GameObject;
import bases.renderes.ImageRenderer;

public class Player extends GameObject {

    PlayerMove playerMove;
    PlayerConstraints playerConstraints;

    public Player() {
        this.renderer = new ImageRenderer("assets/images/players/straight/0.png");
        this.playerMove = new PlayerMove();
        this.playerConstraints = new PlayerConstraints();
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerConstraints.run(this);
    }
}
