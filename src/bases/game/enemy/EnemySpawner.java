package bases.game.enemy;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject {

    FrameCounter frameCounter;

    public EnemySpawner() {
        this.frameCounter = new FrameCounter(170);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            this.frameCounter.reset();
            Enemy enemy = new Enemy();
            enemy.position.y = 0;
            enemy.position.x = (new Random()).nextInt(384);
            GameObject.add(enemy);
        }

    }
}
