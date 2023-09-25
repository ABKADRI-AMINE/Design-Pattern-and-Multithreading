package composite;

public abstract class Composant {

    String nom;
    int niveau;

    public Composant(String nom) {
        this.nom = nom;
    }

    public String indentation() {
        String s = "";

        for(int i = 0; i < this.niveau; ++i) {
            s = s + "\t";
        }

        return s;
    }

    protected abstract void afficher();
}
