

public class ClasseA extends Thread{

    public void afficher() throws Exception {
        for(int i = 0 ;i<10;i++) {
            System.out.println("Thread "+i+" de la classe A");
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
