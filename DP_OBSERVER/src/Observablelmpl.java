import java.util.*;

public class Observablelmpl implements Observable {

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private int state;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers){
            o.update(this);
        }
    }

    public void setState(int state) {
        this.state = state;
        this.notifyObserver();
    }

    public int getState() {
        return state;
    }
}
