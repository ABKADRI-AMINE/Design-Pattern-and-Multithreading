package composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Folder extends Composant {
    ArrayList <Composant> composants = new ArrayList();

    public Folder(String nom) {
        super(nom);
    }

    @Override
    protected void afficher() {
        String tab = this.indentation();
        System.out.println(tab+""+nom);
        for (Composant c:composants){
            c.afficher();
        }
    }

    public void addComposant (Composant cp){
        cp.niveau=this.niveau+1;
        this.composants.add(cp);
    }
}

