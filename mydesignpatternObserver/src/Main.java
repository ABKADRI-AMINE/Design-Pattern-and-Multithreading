public class  Main {
    public static void main(String[] args) {
        ObservableConcret  sujet=new ObservableConcret();
        ObserverImpl1 obs1 = new ObserverImpl1();
        sujet.addObserver(obs1);
        ObserverImpl2 obs2 = new ObserverImpl2();
        sujet.addObserver(obs2);
        sujet.setEtat(8);
        sujet.setEtat(7);
        sujet.deleteObserver(obs1);
        sujet.setEtat(9);
    }
}