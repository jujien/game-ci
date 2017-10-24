package bases;

import bases.game.enemy.Enemy;
import bases.game.physics.BoxCollider;
import bases.renderes.Renderer;

import java.awt.*;
import java.util.Vector;

public class GameObject {

    public static Enemy checkCollide(BoxCollider boxCollider) {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.isActive && gameObject instanceof Enemy) {
                Enemy enemy = (Enemy) gameObject;
                if (enemy.boxCollider.collideWith(boxCollider)) {
                    return enemy;
                }
            }
        }
        return null;
    }

    private static Vector<GameObject> gameObjects = new Vector<>();
    private static Vector<GameObject> newGameObject = new Vector<>();

    public Vector2D position;
    public Renderer renderer;
    public boolean isActive;

    public GameObject() {
        this.position = new Vector2D();
        this.isActive = true;
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
            if (gameObject.isActive) {
                gameObject.run();
            }

        }
        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public static void renderAll(Graphics2D graphics2D) {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(graphics2D);
            }
        }
    }

    public static void add(GameObject gameObject) {
        newGameObject.add(gameObject);
    }
}
