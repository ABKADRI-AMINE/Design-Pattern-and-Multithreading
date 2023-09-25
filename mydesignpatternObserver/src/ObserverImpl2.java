public class ObserverImpl2 implements Observer{

    @Override
    public void update(Observable o) {
        System.out.println("Observateur 2");
        int etat=((ObservableConcret)o).getEtat();
        System.out.println("Resultat :"+etat*6);
    }
}
