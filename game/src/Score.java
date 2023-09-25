import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Score implements  Observable {

    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    int player1 = 0;
    int player2 = 0;
    private List<Observer> observers = new ArrayList<>();
    private Observable observable;

    public Score(int gameWidth, int gameHeight) {
        GAME_WIDTH = gameWidth;
        GAME_HEIGHT = gameHeight;
    }

    @Override
    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(observable);
        }
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof Paddle) {
            Paddle p = (Paddle) observable;
            if (p.getPlayer() == 1) {
                incrementPlayer1Score();
            } else {
                incrementPlayer2Score();
            }
            notifyObservers();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));

        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);

        g.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GAME_WIDTH / 2) - 85, 50);
        g.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);
    }

    public void incrementPlayer1Score() {
        player1++;
    }

    public void incrementPlayer2Score() {
        player2++;
    }

    public int getPlayer1Score() {
        return player1;
    }

    public int getPlayer2Score() {
        return player2;
    }
}