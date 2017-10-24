package bases.game.player;

public class PlayerConstraints {
    public float top;
    public float bottom;
    public float left;
    public float right;

    public PlayerConstraints() {
        this.top = 0.0f;
        this.bottom = 600.0f;
        this.left = 0.0f;
        this.right = 384.0f;
    }
    public void run(Player player) {
        player.position.x = clamp(player.position.x, this.left, this.right);
        player.position.y = clamp(player.position.y, this.top, this.bottom);
    }

    public float clamp(float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}
