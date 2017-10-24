package bases.game.player.spells;

import bases.GameObject;
import bases.renderes.ImageRenderer;

public class PlayerSpell extends GameObject {
    public PlayerSpell() {
        this.renderer = new ImageRenderer("assets/images/player-spells/a/0.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(0, 10);
    }
}
