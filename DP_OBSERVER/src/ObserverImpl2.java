public class ObserverImpl2 implements Observer {
    private int etat;
    @Override
    public void update(Observable observable) {
        etat = ((Observablelmpl)observable).getState();

        int carr = etat*etat;
        System.out.println("****ObserverImpl****");
        System.out.println("caree " + carr);
        System.out.println("****************");
    }
}
