package personnages;

public class Romain {
	private String nom ;
	private int force ;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0 ;
	
	public Romain(String nom, int force) {
		super();
		assert force > 0 ;
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
		return "Le romain " + nom + " : ";
	}
	
	/* public void recevoirCoup(int forceCoup) {
		assert force>0 ;
		int forceInit = force;
		force -= forceCoup ;
		if (force>0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		assert force < forceInit;
	} */
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aïe");
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 2 : 
			System.out.println("Le soldat " + nom + " est déja bien protégé !");
			break ;
		case 1 :
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déja un " + equipement + ".");
				break;
			} 
		default :
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
			break ;
		}
	}
	

	private int CalculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

			
	public static void main(String[] args) {
		//TP1
		/* Romain victimus = new Romain("Victimus",10);
		victimus.parler("Bonjour, je suis une victime.");
		victimus.recevoirCoup(5); */
		
		//TP2
		Romain minus = new Romain("Minus",6);
		System.out.println("Les équipements possibles sont :");
		for (Equipement equipement : Equipement.values()) {
			System.out.println("- " + equipement);
		}
		Equipement casque1 = Equipement.CASQUE ;
		Equipement casque2 = Equipement.CASQUE ;
		Equipement casque3 = Equipement.CASQUE ;
		Equipement bouclier = Equipement.BOUCLIER;
		minus.sEquiper(casque1);
		minus.sEquiper(casque2);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque3);
	}
}