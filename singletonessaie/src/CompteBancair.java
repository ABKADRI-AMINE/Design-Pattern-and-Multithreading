public class CompteBancair {
    private int numero;
    private double solde;
    Journalisation jour = Journalisation.getjournalisation();
    public CompteBancair(){}

    public CompteBancair(int numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }
    public void deposerArgent(double montant){
        this.solde=+montant;
        jour.ajouterLog("Votre argent a etait bien deposee");
    }
    public void retirerArgent(double montant){
if(this.solde>montant){
    this.solde=this.solde-montant;
    jour.ajouterLog("Votre argent a etait bien retirer");
}
    }
}
