public class Main {
    public static void main(String[] args) {
        CompteBancair c1 =new CompteBancair(123,0);
        CompteBancair c2 =new CompteBancair(1234,0);
        c1.deposerArgent(100);
        c1.retirerArgent(80);
        c2.deposerArgent(200);
        c2.retirerArgent(110);
        System.out.println(Journalisation.getjournalisation().getLog());
    }
}