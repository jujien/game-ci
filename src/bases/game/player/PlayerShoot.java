package bases.game.player;

import bases.GameObject;
import bases.game.input.InputManager;
import bases.game.player.spells.PlayerSpell;

public class PlayerShoot {

    public boolean disabled;
    public int count;
    public final int COUNT_MAX = 17;

    public void run(Player player) {
        InputManager instance = InputManager.instance;
        if (this.disabled) {
            this.count += 1;
            if (this.count >= this.COUNT_MAX) {
                this.disabled = false;
                this.count = 0;
            }
            return;
        }
        if (instance.xPressed) {
            PlayerSpell playerSpell = new PlayerSpell();
            playerSpell.position.set(player.position);
            GameObject.add(playerSpell);
            this.disabled = true;
        }
    }
}
