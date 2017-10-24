package bases.game.physics;

import bases.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public float width;
    public float height;

    public BoxCollider(float width, float height) {
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
    }

    private float left() {
        return (float) (this.position.x - this.width / 2.0);
    }

    private float right() {
        return (float) (this.position.x + this.width / 2.0);
    }

    private float top() {
        return (float) (this.position.y - this.height / 2.0);
    }

    private float bottom() {
        return (float) (this.position.y + this.height / 2.0);
    }


    public boolean collideWith(BoxCollider boxCollider) {
        boolean xOverlap = (boxCollider.right() >= this.left()) && (boxCollider.left() <= this.right());
        boolean yOverlap = (boxCollider.bottom() >= this.top()) && (boxCollider.top() <= this.bottom());
        return xOverlap && yOverlap;
    }
}
