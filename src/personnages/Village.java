package personnages;


public class Village {
	private String nom ;
	private Chef chef ;
	private Gaulois[] villageois ;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMax) {
		super();
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMax];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois ;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numeroHabitant) {
		return villageois[numeroHabitant];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for(int i=0 ; i<nbVillageois ; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		//TP2
		Village village = new Village("Village des Irréductible",30);
		/* Gaulois gaulois = village.trouverHabitant(30); IMPOSSIBLE, LE TABLEAU VA DE 0 A 29 */
		Chef abraracourix = new Chef("Abraracourcix",6,1,village);
		village.setChef(abraracourix);
		Gaulois asterix = new Gaulois("Astérix",6);
		village.ajouterHabitant(asterix);
		/* Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois); 
		CELA RENVOIE NULL CAR ASTERIX EST EN POSITION 0 ET IL N'Y A RIEN EN POSITION 1 DU TABLEAU*/
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();

		
		
	}

}