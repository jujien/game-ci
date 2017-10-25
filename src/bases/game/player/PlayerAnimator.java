package bases.game.player;

import bases.Utils;
import bases.Vector2D;
import bases.renderes.Animation;
import bases.renderes.Renderer;

import java.awt.*;

public class PlayerAnimator implements Renderer {

    Animation straightAnimation;
    Animation leftAnimation;
    Animation rightAnimation;

    Animation currentAnimation;

    public PlayerAnimator() {
        this.straightAnimation = new Animation(true, 5,
                Utils.loadImage("assets/images/players/straight/0.png"),
                Utils.loadImage("assets/images/players/straight/1.png"),
                Utils.loadImage("assets/images/players/straight/2.png"),
                Utils.loadImage("assets/images/players/straight/3.png"),
                Utils.loadImage("assets/images/players/straight/4.png"),
                Utils.loadImage("assets/images/players/straight/5.png"),
                Utils.loadImage("assets/images/players/straight/6.png")
                );
        this.leftAnimation = new Animation(true, 5,
                Utils.loadImage("assets/images/players/left/0.png"),
                Utils.loadImage("assets/images/players/left/1.png"),
                Utils.loadImage("assets/images/players/left/2.png"),
                Utils.loadImage("assets/images/players/left/3.png"),
                Utils.loadImage("assets/images/players/left/4.png"),
                Utils.loadImage("assets/images/players/left/5.png")
        );
        this.rightAnimation = new Animation(true, 5,
                Utils.loadImage("assets/images/players/right/0.png"),
                Utils.loadImage("assets/images/players/right/1.png"),
                Utils.loadImage("assets/images/players/right/2.png"),
                Utils.loadImage("assets/images/players/right/3.png"),
                Utils.loadImage("assets/images/players/right/4.png"),
                Utils.loadImage("assets/images/players/right/5.png")
        );
        this.currentAnimation = this.straightAnimation;
    }

    public void run(Player player) {
        Vector2D velocity = player.playerMove.velocity;
        if (velocity.x < 0) {
            this.currentAnimation = this.leftAnimation;
        } else if (velocity.x > 0) {
            this.currentAnimation = this.rightAnimation;
        } else {
            this.currentAnimation = this.straightAnimation;
        }
    }

    @Override
    public void render(Graphics2D graphics, Vector2D position) {
        this.currentAnimation.render(graphics, position);
    }
}
