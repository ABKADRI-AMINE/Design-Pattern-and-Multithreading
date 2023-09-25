public class Main {
    public static void main(String[] args) throws InterruptedException {
        Manger2 mg = new Manger2();
        Marcher2 mr = new Marcher2();
       // mg.setPriority(Thread.MIN_PRIORITY);
        //mr.setPriority(Thread.MAX_PRIORITY);
        //System.out.println(mg.getId());
        //System.out.println(mg.getName());
        //System.out.println(mg.getPriority());
    Thread tnr = new Thread(mr);
    Thread tng = new Thread(mg);

        //mg.start();
        //mr.start();
        //mg.join();
        //mr.join();
        tnr.start();
        tng.start();
        tng.join();
        tnr.join();
        System.out.println("l'etudiant est arrive a mla salle 105");
        System.out.println("l'etudiant entrain  de suivre le cours java avance");
    }
}
