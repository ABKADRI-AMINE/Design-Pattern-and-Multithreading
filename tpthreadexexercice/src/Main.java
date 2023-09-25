import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Compte c1 = new Compte(999);

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(new CompteModifier(c1, 10)));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("le solde finale est : " + c1.consulterSolde());
    }

}