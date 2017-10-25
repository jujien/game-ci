package bases;

import bases.game.background.Background;
import bases.game.enemy.EnemySpawner;
import bases.game.player.Player;
import bases.game.scenes.GamePlayScene;
import bases.game.scenes.SceneManager;

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
        this.setupFistScene();

    }

    private void setupFistScene() {
        SceneManager.changeScene(new GamePlayScene());
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



    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBufferImage, 0, 0, null);
    }

    public void run() {
        GameObject.runAll();
        SceneManager.performChangeSceneIfNeeded();
    }
}
