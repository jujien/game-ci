package bases.game.player.spells;

import bases.GameObject;
import bases.game.enemy.Enemy;
import bases.game.physics.BoxCollider;

public class HitEnemy {

    public void run(PlayerSpell playerSpell) {
        BoxCollider boxCollider = playerSpell.boxCollider;
        Enemy enemy = GameObject.checkCollide(boxCollider);
        if (enemy != null) {
            enemy.isActive = false;
            playerSpell.isActive = false;
        }
    }
}
