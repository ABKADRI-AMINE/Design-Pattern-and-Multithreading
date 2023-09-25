public class MoveCommand implements ICommand {
    private Paddle paddle;
    private int yDirection;

    public MoveCommand(Paddle paddle, int yDirection) {
        this.paddle = paddle;
        this.yDirection = yDirection;
    }

    public void execute() {
        paddle.setYDirection(yDirection);
    }
}
