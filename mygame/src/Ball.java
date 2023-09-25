import java.awt.*;

public class Ball {
    private int x, y;
    private int diameter;
    private int speedX, speedY;

    public Ball(int x, int y, int diameter, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void move() {
        x += speedX;
        y += speedY;
    }

    public void checkBounds(int screenWidth, int screenHeight) {
        // Check left and right bounds
        if (x <= 0 || x + diameter >= screenWidth) {
            speedX = -speedX;
        }

        // Check top and bottom bounds
        if (y <= 0 || y + diameter >= screenHeight) {
            speedY = -speedY;
        }
    }

    public void draw(Graphics g) {
        g.fillOval(x, y, diameter, diameter);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
