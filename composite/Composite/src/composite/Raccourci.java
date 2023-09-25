package composite;

public class Raccourci extends Composant{

    public Raccourci(String nom) {
        super(nom);
    }

    @Override
    protected void afficher() {
        String tab= indentation();
        System.out.println(tab+"R :" +nom);
    }
}
