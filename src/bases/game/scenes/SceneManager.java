package bases.game.scenes;

import bases.scenes.Scene;

public class SceneManager {
    static Scene currentScene;
    static Scene nextScene;
    public static void changeScene(Scene scene) {
        nextScene = scene;

    }

    public static void performChangeSceneIfNeeded() {
        if (nextScene != null) {
            if (currentScene != null) {
                currentScene.deinit();
            }
            nextScene.init();
            currentScene = nextScene;
            nextScene = null;
        }
    }
}
