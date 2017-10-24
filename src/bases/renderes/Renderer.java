package bases.renderes;

import bases.Vector2D;

import java.awt.*;

public interface Renderer {
    void render(Graphics2D graphics, Vector2D position);
}
