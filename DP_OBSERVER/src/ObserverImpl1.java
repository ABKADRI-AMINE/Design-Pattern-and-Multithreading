public class ObserverImpl1 implements Observer {

    private int etat;
    @Override
    public void update(Observable observable) {
        etat = ((Observablelmpl)observable).getState();
        System.out.println("****ObserverImpl****");
        System.out.println((etat%2==0)? "pair":"impair");
        System.out.println("****************");
    }
}
