package bases;

import bases.game.input.InputManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTimeUpdate;

    public GameWindow() {
        this.setupCanvas();
        this.setupWindows();
        this.setupKeyListener();
        this.lastTimeUpdate = System.nanoTime();
    }

    private void setupKeyListener() {
        this.addKeyListener(InputManager.instance);
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTimeUpdate >= 17_000_000) {
                this.gameCanvas.run();
                this.gameCanvas.render();
                this.lastTimeUpdate = currentTime;
            }
        }
    }

    private void setupCanvas() {
        this.gameCanvas = new GameCanvas();
        this.setContentPane(this.gameCanvas);
        this.gameCanvas.setVisible(true);
    }

    private void setupWindows() {
        this.setSize(800, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
