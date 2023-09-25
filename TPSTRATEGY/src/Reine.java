public class Reine extends Personnage{
    @Override
    public void combattre(){
        super.setArme(new ComportementPoignard());
        System.out.println("La Reine: "+this.arme.UtiliserArme());
    }
}
