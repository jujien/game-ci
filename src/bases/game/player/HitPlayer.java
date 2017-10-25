package bases.game.player;

import bases.GameObject;
import bases.game.enemy.Enemy;
import bases.game.physics.BoxCollider;
import bases.game.scenes.GameOverScene;
import bases.game.scenes.SceneManager;

public class HitPlayer {
    public void run(Player player) {
        BoxCollider boxCollider = player.boxCollider;
        Enemy enemy = GameObject.checkCollide(boxCollider, Enemy.class);
        if (enemy != null) {
            enemy.getHit();
            player.isActive = false;
            SceneManager.changeScene(new GameOverScene());
        }
    }
}
