import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable, GameObserver {
    private Display display;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private InputHandler inputHandler;
    private GameState gameState;
    private Ball ball;
    private Paddle playerPaddle;
    private Paddle computerPaddle;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        inputHandler = new InputHandler();
        gameState = new GameState();
        ball = new Ball(width / 2, height / 2, 10, 10, 5);
        playerPaddle = Paddle.createPlayerPaddle(50, height / 2 - 50, 10, 100, 5, new MoveUpCommand(playerPaddle), new MoveDownCommand(playerPaddle));
        computerPaddle = Paddle.createComputerPaddle(width - 50, height / 2 - 50, 10, 100, 5, ball);

        gameState.addObserver(this);
    }

    private void tick() {
        playerPaddle.move();
        computerPaddle.move();
        ball.move();
        checkCollisions();
    }

    private void checkCollisions() {
        if (ball.collidesWith(playerPaddle)) {
            ball.reverseX();
            gameState.incrementPlayerScore();
        } else if (ball.collidesWith(computerPaddle)) {
            ball.reverseX();
            gameState.incrementComputerScore();
        } else if (ball.getX() <= 0) {
            ball.reset();
            gameState.incrementComputerScore();
        } else if (ball.getX() >= width - ball.getWidth()) {
            ball.reset();
            gameState.incrementPlayerScore();
        } else if (ball.getY() <= 0 || ball.getY() >= height - ball.getHeight()) {
            ball.reverseY();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        ball.draw(g);
        playerPaddle.draw(g);
        computerPaddle.draw(g);
        g.drawString("Player: " + gameState.getPlayerScore(), 10, 20);
        g.drawString("Computer: " + gameState.getComputerScore(), width - 100, 20);
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        while (running) {
            tick();
            render();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GameState gameState) {
        if (gameState.getPlayerScore() == 10 || gameState.getComputerScore() == 10) {
            System.out.println("Game Over!");
            stop();
        }
    }

    public static void main(String[] args)
    {
        Game game = new Game("Ping Pong", 800, 600);
        game.display = new Display(game.title, game.width, game.height);
        game.display.getFrame().addKeyListener(game.inputHandler);
        game.start();
    }
}