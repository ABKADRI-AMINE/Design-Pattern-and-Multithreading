import java.awt.*;

public abstract class Paddle {
    protected int x, y;
    protected int width, height;
    protected int speed;
    protected Ball ball;
    protected MoveCommand moveUpCommand;
    protected MoveCommand moveDownCommand;

    csharp
    Copy code
    public Paddle(int x, int y, int width, int height, int speed, Ball ball, MoveCommand moveUpCommand, MoveCommand moveDownCommand) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.ball = ball;
        this.moveUpCommand = moveUpCommand;
        this.moveDownCommand = moveDownCommand;
    }

    public void move() {
        if (moveUpCommand.isPressed()) {
            y -= speed;
        }
        if (moveDownCommand.isPressed()) {
            y += speed;
        }
        checkBounds();
    }

    public abstract void checkBounds();

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Ball getBall() {
        return ball;
    }

    public static Paddle createPlayerPaddle(int x, int y, int width, int height, int speed, MoveCommand moveUpCommand, MoveCommand moveDownCommand) {
        return new PlayerPaddle(x, y, width, height, speed, null, moveUpCommand, moveDownCommand);
    }

    public static Paddle createComputerPaddle(int x, int y, int width, int height, int speed, Ball ball) {
        return new ComputerPaddle(x, y, width, height, speed, ball);
    }
}