import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {

    int id;
    int yVelocity;
    int speed = 10;
    private ICommand command;
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    command = new MoveCommand(this, -speed);
                    command.execute();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    command = new MoveCommand(this, speed);
                    command.execute();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    command = new MoveCommand(this, -speed);
                    command.execute();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    command = new MoveCommand(this, speed);
                    command.execute();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                    command = new MoveCommand(this, 0);
                    command.execute();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    command = new MoveCommand(this, 0);
                    command.execute();
                }
                break;
        }
    }
    public int getPlayer() {
        return id;
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
    }

    public void draw(Graphics g) {
        if (id == 1)
            g.setColor(Color.green);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}
