public class Troll extends Personnage{
    @Override
    public void combattre(){
        super.setArme(new ComportementArcetFleche());
        System.out.println("Le Troll: "+this.arme.UtiliserArme());
    }
}
