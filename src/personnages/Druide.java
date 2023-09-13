package personnages;
import java.util.Random;

public class Druide {
	private String nom ;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1 ;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax= effetPotionMax ;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax +".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForcePotion() {
		return forcePotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		Random random = new Random();
		int valeur ;
		do {
			valeur = random.nextInt(effetPotionMax+1);
		} while (valeur < effetPotionMin );
		if (valeur >= 7) {
			parler("J'ai préparé une super potion de force " + valeur + ".");
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + valeur + ".");
		}
		forcePotion = valeur ;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		//TP1
		Druide panoramix = new Druide("Panoramix", 5,10);
		Gaulois asterix = new Gaulois("Astérix",15);
		Gaulois obelix = new Gaulois("Obélix",20);
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		
	}
}