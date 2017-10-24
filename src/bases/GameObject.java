package bases;

import bases.renderes.Renderer;

import java.awt.*;
import java.util.Vector;

public class GameObject {

    private static Vector<GameObject> gameObjects = new Vector<>();
    private static Vector<GameObject> newGameObject = new Vector<>();

    public Vector2D position;
    public Renderer renderer;

    public GameObject() {
        this.position = new Vector2D();
    }

    public void run() {
    }

    public void render(Graphics2D graphics2D) {
        if (this.renderer != null) {
            this.renderer.render(graphics2D, this.position);
        }
    }

    public static void runAll() {
        for (GameObject gameObject: gameObjects) {
            gameObject.run();
        }
        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public static void renderAll(Graphics2D graphics2D) {
        for (GameObject gameObject: gameObjects) {
            gameObject.render(graphics2D);
        }
    }

    public static void add(GameObject gameObject) {
        newGameObject.add(gameObject);
    }
}
