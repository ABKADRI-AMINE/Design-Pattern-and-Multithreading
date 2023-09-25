import java.util.ArrayList;
import java.util.Observer;

public class GPS implements Observable{
    private int position;
    private String precision;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

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
public void setMesure(int position,String precision){
        this.position=position;
        this.precision=precision;
}

    public int getPosition() {
        return position;
    }

    public String getPrecision() {
        return precision;
    }
}
