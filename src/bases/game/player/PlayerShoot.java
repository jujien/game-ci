package bases.game.player;

import bases.FrameCounter;
import bases.GameObject;
import bases.game.input.InputManager;
import bases.game.player.spells.PlayerSpell;

public class PlayerShoot {

    public boolean disabled;
    public final int COUNT_MAX = 17;

    FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(this.COUNT_MAX);
    }

    public void run(Player player) {
        InputManager instance = InputManager.instance;
        if (this.disabled) {
            if (this.frameCounter.run()) {
                this.disabled = false;
                this.frameCounter.reset();
            }
            return;
        }
        if (instance.xPressed) {
            PlayerSpell playerSpell = new PlayerSpell();
            playerSpell.position.set(player.position.subtract(0, 5));
            GameObject.add(playerSpell);
            this.disabled = true;
        }
    }
}
