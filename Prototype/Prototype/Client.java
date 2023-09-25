package Prototype;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		String cl1="amine1";
		Facture fc = new Facture(cl1) ;
        fc.setNumCommande(1);;
        Facture f2 = (Facture) fc.clone();
        f2.informations();
        String cl2="amine2";
        BonCommande bc = new BonCommande(cl2) ;
        bc.setNumCommande(2);;
        BonCommande bc2 = (BonCommande) bc.clone();
        bc2.informations();
        Notice n2=new Notice();
        Notice n22=(Notice) n2.clone();
        n2.informations();
	}

}
