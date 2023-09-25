
public class ClasseB implements Runnable {
    public void afficher() throws Exception {
        for(int i = 0 ;i<10;i++) {
            System.out.println("Thread "+i+" de la classe B");
            Thread.sleep(100);
        }
    }

    @Override
    public void run() {
        try {
            this.afficher();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
