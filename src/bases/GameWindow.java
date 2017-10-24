package bases;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;

    public GameWindow() {
        this.setupCanvas();
        this.setupWindows();
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
