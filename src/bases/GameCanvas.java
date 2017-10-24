package bases;

import bases.game.player.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background;
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
        this.backBufferGraphic2D.drawImage(this.background, 0, 0, null);
        this.player.render(this.backBufferGraphic2D);
        this.repaint();
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(192.0f, 500.0f);
    }

    private void setupBackgroundImage() {
        try {
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBufferImage, 0, 0, null);
    }

    public void run() {
        this.player.run();
    }
}
