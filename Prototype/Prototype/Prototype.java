package Prototype;

// Classe abstraite Prototype qui implémente l'interface Cloneable
public abstract class Prototype implements Cloneable {

	// Implémentation de la méthode clone() de l'interface Cloneable
	@Override
	protected Prototype clone() throws CloneNotSupportedException {
		// Appel de la méthode clone() de la classe Object pour créer une copie de l'objet
		Prototype prototype=(Prototype) super.clone();
		// Conversion de l'objet cloné en un objet de type Prototype
		return prototype;
	}

	// Méthode abstraite informations() qui sera implémentée par les classes dérivées
	public abstract void informations();
}
