public abstract class Personnage {
    protected ComportementArme arme;
    public abstract void combattre();

    public void setArme(ComportementArme arme) {
        this.arme = arme;
    }
}
