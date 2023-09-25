public class Main {
    public static void main(String[] args) {

        Observablelmpl observable = new Observablelmpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl1();
        Observer o3 = new ObserverImpl2();

        observable.addObserver(o1);
        observable.addObserver(o3);

        observable.setState(10);


        observable.removeObserver(o1);
        observable.addObserver(o2);

        observable.setState(5);

    }
}