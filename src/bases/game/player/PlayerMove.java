package bases.game.player;

import bases.Vector2D;
import bases.game.input.InputManager;

public class PlayerMove {

    Vector2D velocity;
    final int SPEED = 5;

    public PlayerMove() {
        this.velocity = new Vector2D();
    }

    public void run(Player player){
        InputManager instance = InputManager.instance;
        this.velocity.reset();
        if (instance.rightPressed) {
            this.velocity.addUp(this.SPEED, 0);
        }

        if (instance.leftPressed) {
            this.velocity.addUp(-this.SPEED, 0);
        }

        if (instance.upPressed) {
            this.velocity.addUp(0, -this.SPEED);
        }

        if (instance.downPressed) {
            this.velocity.addUp(0, this.SPEED);
        }

        player.position.addUp(this.velocity);
    }
}
