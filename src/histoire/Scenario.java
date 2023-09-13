package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Chef;
import personnages.Village;

public class Scenario {

	public static void main(String[] args) {
		//TP1
		Druide panoramix = new Druide("Panoramix", 5,10);
		Gaulois asterix = new Gaulois("Astérix",8);
		Gaulois obelix = new Gaulois("Obélix",20);
		Romain minius = new Romain("Minius", 30);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste!");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minius.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minius);
		asterix.frapper(minius);
		asterix.frapper(minius);
		

	}

}
