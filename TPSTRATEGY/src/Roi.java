public class Roi extends Personnage{
@Override
    public void combattre(){
    super.setArme(new ComportementHache());
    System.out.println("le Roi : " + this.arme.UtiliserArme());
}
}
