package test_fonctionnel;

import personnages.Gaulois;

public class test_gaulois {
	
	void main() {
		
		Gaulois asterix = new Gaulois("Astérix",8);
		
		Gaulois obelix = new Gaulois("Obélix",16);
		
		asterix.parler("Bonjour Obélix.") ;
		
		obelix.parler("Bonjour Asterix, Ca te dirais d'aller chasser des sangliers ?") ;
		
		asterix.parler("Oui très bonne idée");
		
		
	}

}
