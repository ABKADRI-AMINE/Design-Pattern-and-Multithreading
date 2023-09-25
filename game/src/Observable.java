import java.awt.*;

public interface Observable {
    void setObservable(Observable observable);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();


    void update(Observable observable);

    void draw(Graphics g);
}