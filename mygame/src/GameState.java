import java.util.ArrayList;
import java.util.List;

public class GameState {
    private int playerScore;
    private int computerScore;
    private List<GameObserver> observers;

    public GameState() {
        playerScore = 0;
        computerScore = 0;
        observers = new ArrayList<>();
    }

    public void incrementPlayerScore() {
        playerScore++;
        notifyObservers();
    }

    public void incrementComputerScore() {
        computerScore++;
        notifyObservers();
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(this);
        }
    }
}
