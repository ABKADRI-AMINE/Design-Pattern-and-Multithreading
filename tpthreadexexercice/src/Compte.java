public class Compte {
    private double solde;

    public Compte(double soldeInitial) {
        solde = soldeInitial;
    }

    public synchronized void crediter(double montant) {
        solde += montant;
    }

    public synchronized void debiter(double montant) {
        if (solde >= montant) {
            solde -= montant;
        } else {
            throw new IllegalArgumentException("solde insuffisant.");
        }
    }

    public synchronized double consulterSolde() {
        return solde;
    }
}

