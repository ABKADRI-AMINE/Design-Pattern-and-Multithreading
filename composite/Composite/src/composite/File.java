package composite;

public class File extends Composant{

    public File(String nom) {
        super(nom);
    }

    @Override
    protected void afficher() {
        String tab =indentation();
        System.out.println(tab+"F: "+nom );
    }
}
