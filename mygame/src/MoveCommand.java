public class MoveCommand implements Command {
    private int dy;
    private Paddle paddle;

    public MoveCommand(int dy, Paddle paddle) {
        this.dy = dy;
        this.paddle = paddle;
    }

    @Override
    public void execute() {
        paddle.move(0, dy);
    }
}
