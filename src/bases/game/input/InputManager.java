package bases.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    public static final InputManager instance = new InputManager();

    public boolean rightPressed;
    public boolean leftPressed;
    public boolean upPressed;
    public boolean downPressed;
    public boolean xPressed;

    private InputManager() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.downPressed = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_X) {
            this.xPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.downPressed = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_X) {
            this.xPressed = false;
        }
    }
}
