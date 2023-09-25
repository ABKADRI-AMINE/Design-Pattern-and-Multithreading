
public class Adaptateur extends ImpIAdaptee  implements Utilisateur {
    String name ;
    String poste ;



    public Adaptateur (String name , String poste) {
        this.name = name ;
        this.poste = poste;
    }

    @Override
    public void afficherUser(String name , String poste) {
        super.afficherPoste(this.poste);
        super.afficherName(this.name);





    }

}