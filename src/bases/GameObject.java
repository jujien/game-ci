package bases;

import bases.renderes.Renderer;

import java.awt.*;

public class GameObject {
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
}
