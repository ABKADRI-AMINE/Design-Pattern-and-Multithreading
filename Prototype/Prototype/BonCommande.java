package Prototype;

public class BonCommande extends Prototype {

	private int numCommande;
	private String client;
	
	public BonCommande(String client) {
		this.client=client;
	}
	
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	
	@Override
	public void informations() {
		System.out.println("Un Bon-command de numCommande:"+this.numCommande+" pour client:"+this.client);
		
	}
	

}
