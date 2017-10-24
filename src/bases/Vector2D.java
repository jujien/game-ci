package bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0.0f, 0.0f);
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D vector2D) {
        this.set(vector2D.x, vector2D.y);
        return this;
    }

    public Vector2D addUp(float dx, float dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D) {
        this.addUp(vector2D.x, vector2D.y);
        return this;
    }

    public Vector2D subtractBy(float dx, float dy) {
        this.x -= dx;
        this.y -= dy;
        return this;
    }

    public Vector2D subtractBy(Vector2D vector2D) {
        this.subtractBy(vector2D.x, vector2D.y);
        return this;
    }

    public Vector2D reset() {
        this.set(0.0f, 0.0f);
        return this;
    }

    public Vector2D add(float dx, float dy) {
        return new Vector2D(this.x + dx, this.y + dy);
    }

    public Vector2D add(Vector2D vector2D) {
        return this.add(vector2D.x, vector2D.y);
    }

    public Vector2D subtract(float dx, float dy) {
        return new Vector2D(this.x - dx, this.y - dy);
    }

    public Vector2D subtract(Vector2D vector2D) {
        return this.subtract(vector2D.x, vector2D.y);
    }

    public Vector2D multiply(float number) {
        return new Vector2D(this.x * number, this.y * number);
    }

    public Vector2D normalize() {
        return new Vector2D(1.0f, 1.0f);
    }

    public float lenght() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D copy() {
        return new Vector2D(this.x, this.y);
    }
}
