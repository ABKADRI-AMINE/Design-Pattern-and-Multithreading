
public class ImpIAdaptee  {
    String name ;
    String poste ;


    public void afficherName(String name ) {
        this.name = name;
        System.out.println("le Nom est :"+ name);
    }

    public void afficherPoste(String poste) {
        this.poste = poste ;
        System.out.println("Son poste est :"+ poste);
    }



}