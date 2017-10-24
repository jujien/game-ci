package bases;

import bases.game.background.Background;
import bases.game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    BufferedImage backBufferImage;
    Graphics2D backBufferGraphic2D;

    public GameCanvas() {
        this.setupBackBuffer();
        this.setBackground(Color.BLACK);
        this.setupBackgroundImage();
        this.setupPlayer();
    }

    private void setupBackBuffer() {
        this.backBufferImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        this.backBufferGraphic2D = (Graphics2D) this.backBufferImage.getGraphics();
    }

    public void render() {
        this.backBufferGraphic2D.setColor(Color.BLACK);
        this.backBufferGraphic2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        GameObject.renderAll(this.backBufferGraphic2D);
        this.repaint();
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(192.0f, 500.0f);
        GameObject.add(this.player);
    }

    private void setupBackgroundImage() {
        this.background = new Background();
        this.background.position.x = 384.0f / 2.0f;
        GameObject.add(this.background);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBufferImage, 0, 0, null);
    }

    public void run() {
        GameObject.runAll();
    }
}
