import java.util.ArrayList;
import java.util.Iterator;

public class file extends Composant {
    private ArrayList<Composant> composant= new ArrayList();

    public file(String nom) {
        super(nom);
    }

    public void addComposant(Composant menu) {
        menu.niveau = this.niveau + 1;
        this.composant.add(menu);
    }

    public void afficher() {
        String tab = this.indentation();
        System.out.println(tab + nom);
        Iterator var3 = this.composant.iterator();

        while(var3.hasNext()) {
            Composant f = (Composant)var3.next();
            f.afficher();
        }

    }
}
