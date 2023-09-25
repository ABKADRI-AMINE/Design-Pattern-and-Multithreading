import java.util.ArrayList;
import java.util.List;

public class ObservableConcret implements  Observable{
    private List<Observer> observers = new ArrayList<>();
    private int etat;
    @Override
    public void addObserver(Observer o) {
    observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
    observers.remove(o);
    }
//je vais parcourir toute la liste des obserateur pour chaque observer o de la liste observers a chaque fois j'appelle o.update

    @Override
    public void notifyObservers() {
    for(Observer o:observers)
        o.update(this);
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
        notifyObservers();
    }
}
