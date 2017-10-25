package bases.game.scenes;

import bases.GameObject;
import bases.game.background.Background;
import bases.game.enemy.EnemySpawner;
import bases.game.player.Player;
import bases.scenes.Scene;

public class GamePlayScene implements Scene {
    Background background;
    Player player;

    public void init() {
        this.setupBackgroundImage();
        this.setupPlayer();
        this.setupEnemy();
    }

    public void deinit() {
        GameObject.clear();
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(192.0f, 500.0f);
        GameObject.add(this.player);
    }

    private void setupEnemy() {
        GameObject.add(new EnemySpawner());
    }

    private void setupBackgroundImage() {
        this.background = new Background();
        this.background.position.x = 384.0f / 2.0f;
        GameObject.add(this.background);
    }
}
