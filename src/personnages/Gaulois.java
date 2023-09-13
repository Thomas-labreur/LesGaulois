package personnages;

public class Gaulois {
	private String nom ;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1 ;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le gaulois "+ nom + " : ";
	} 

	/* public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom() + ".");
		romain.recevoirCoup(force * effetPotion / 3);
	} */

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRomain = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRomain != null && i < tropheesRomain.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRomain[i];
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	} 
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion ;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	public static void main(String[] args) {
		//TP1
		Gaulois asterix = new Gaulois("Astérix",15);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		Romain victimus = new Romain("Victimus",10);
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
		asterix.boirePotion(panoramix.getForcePotion());
		asterix.parler("Bonjour, je vais taper Victimus.");
		asterix.frapper(victimus);
		System.out.println("La force de " + victimus.getNom() + " est désormais de " + victimus.getForce() + ".");
	}
}