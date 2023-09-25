
public class Compte {
    private double solde;

    public Compte(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public synchronized void deposer(double montant) {
        this.solde += montant;
    }

    public synchronized void retirer(double montant) {
        this.solde -= montant;
    }

    public synchronized double consulter() {
        return this.solde;
    }
}
