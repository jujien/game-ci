package bases.game.scenes;

import bases.GameObject;
import bases.renderes.ImageRenderer;
import bases.scenes.Scene;

public class GameOverScene implements Scene {

    @Override
    public void init() {
        GameObject background = new GameObject();
        background.renderer = new ImageRenderer("assets/images/scenes/game-over-background.jpg");
        background.position.set(320, 260);
        GameObject.add(background);
    }

    @Override
    public void deinit() {

    }
}
