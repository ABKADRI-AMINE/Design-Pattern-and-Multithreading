
public class GrandeDistrubition  implements Utilisateur {
    String name ;
    String poste ;

    public  GrandeDistrubition(String name) {
        this.name = name;

    }

    @Override
    public void afficherUser(String name,String poste) {
        System.out.println("Vous passez par la grande distribution!") ;

        this.name = name;
        System.out.println("le Nom est :"+ name);







    }

}