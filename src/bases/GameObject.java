package bases;

import bases.game.physics.BoxCollider;
import bases.game.physics.PhysicsBody;
import bases.game.player.spells.PlayerSpell;
import bases.renderes.Renderer;

import java.awt.*;
import java.util.Vector;

public class GameObject {

    public static <T extends PhysicsBody> T checkCollide(BoxCollider boxCollider, Class<T> cls) {
        for (GameObject gameObject: gameObjects) {
            if (!gameObject.isActive) continue;
            if (!(gameObject instanceof PhysicsBody)) continue;
            if (!(gameObject.getClass().equals(cls))) continue;
            BoxCollider otherBoxCollide = ((PhysicsBody) gameObject).getBoxCollider();
            if (boxCollider.collideWith(otherBoxCollide)) {
                return (T) gameObject;
            }
        }
        return null;
    }

    public static <T extends GameObject> T recycle(Class<T> cls) {
        for (GameObject gameObject: gameObjects) {
            if (gameObject.isActive) continue;
            if (!(gameObject.getClass().equals(cls))) continue;
            gameObject.isActive = true;
            return (T) gameObject;
        }
        T gameObject = null;
        try {
            gameObject = cls.newInstance();
            gameObject.isActive = true;
            add(gameObject);
            return gameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
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

    public static void clear() {
        gameObjects.clear();
    }
}
