package personnages;

public class Gaulois {
	
	private String nom ;
	private int force ;
	private int effetPotion = 1 ;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village ;
		
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"") ;
	}
	
	private String prendreParole(){
		return "Le Gaulois " + nom + " : " ;
 	}
	
	public void sePresenter()
	{
		StringBuilder chaine = new StringBuilder("Bonjour, je m'appelle " + "nom " + ".");
		if (village == null)
		{
			chaine.append("Je voyage de village en village");
		}
		else
		{
			if (village.getChef().equals(this))
			{
				chaine.append("Je suis le chef");
			}
			else
			{
				chaine.append("J'habite");
			}
			chaine.append("le village " + village.getNom() + ".");
		}
		parler(chaine.toString());
	}
	
	/* public void sePresenter() {
		if (village == null)
		{
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
        }
		else
		{
			if (this == village.getChef()) {
				parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village : " + village.getNom() + ".");
            }
			else
			{
				parler("Bonjour, je m'appelle " + nom + ". J'habite le village : " + village.getNom() + ".");
			}
		}
		
	}
	*/
	
	@Override
	public String toString() {
		return nom;
	}
	
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force*this.effetPotion) / 3);
		this.effetPotion--;
		
		if (this.effetPotion < 1) {
            this.effetPotion = 1;
        }
	}
	
	public void boirePotion(int forcePotion) {
        this.effetPotion = forcePotion;
    }
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		asterix.sePresenter();
	}	
}
