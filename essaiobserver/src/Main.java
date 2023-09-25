public class Main {
    public static void main(String[] args) {
        GPS observable = new GPS();
        Observer o1 = new displayResume();
        Observer o2 = new displayResume();
        Observer o3 = new displayAll();

    }
}