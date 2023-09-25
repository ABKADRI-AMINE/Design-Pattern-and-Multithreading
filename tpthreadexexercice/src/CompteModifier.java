public class CompteModifier implements Runnable {
    private Compte compte;
    private double montant;

    public CompteModifier(Compte compte, double montant) {
        this.compte = compte;
        this.montant = montant;
    }

    @Override
    public void run() {
        compte.crediter(montant);
        compte.debiter(montant);
    }
}
