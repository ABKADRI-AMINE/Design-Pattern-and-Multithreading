public class Chevalier extends Personnage{
    @Override
    public void combattre(){
        super.setArme(new ComportementArcetFleche());
        System.out.println("Le chevalier: "+this.arme.UtiliserArme());
    }
}
