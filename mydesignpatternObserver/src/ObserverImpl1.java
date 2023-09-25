public class ObserverImpl1 implements Observer{
    @Override
    public void update(Observable o) {
        System.out.println("Observateur 1");
        //je fais le casting ((ObservableConcret)o).getEtat() car getEtat() se trouve pas dans l'interface observer
        int etat=((ObservableConcret)o).getEtat();
        System.out.println("Resultat :"+etat*3);
    }
}
