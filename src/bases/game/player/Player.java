package bases.game.player;

import bases.GameObject;
import bases.renderes.ImageRenderer;

public class Player extends GameObject {

    PlayerMove playerMove;

    public Player() {
        this.renderer = new ImageRenderer("assets/images/players/straight/0.png");
        this.playerMove = new PlayerMove();
    }

    @Override
    public void run() {
        this.playerMove.run(this);
    }
}
