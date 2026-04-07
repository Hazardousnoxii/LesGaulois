package personnages;

public class Village {
	
	private String nom ;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	public Village(String nom, int nbVillageoisMax, Gaulois chef) {
		this.nom = nom;
		villageois =new Gaulois[nbVillageoisMax];	
		this.chef = chef;
		chef.setVillage(this);
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		gaulois.setVillage(this);
		nbVillageois++;
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		Gaulois gauloischerche = null;
		if (numVillageois > 0 && numVillageois < nbVillageois + 1)
		{
			gauloischerche = villageois[numVillageois - 1];
		}
		else
		{
			System.out.println("Il n'y a pas autant d'habitants dans la village");
		}
		return gauloischerche;
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les gaulois :");
		for (int i = 0 ; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public static void main(String arg[]) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix",6);
		Village village = new Village("Village des irreductibles",30,abraracourcix);
		
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelix = new Gaulois("Obelix",25);
		Gaulois doublepolemix = new Gaulois("Doublepolémix",4);
		village.ajouterVillageois(obelix);
		village.ajouterVillageois(asterix);
		
		village.trouverVillageois(30);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillage();
		asterix.sePresenter();
		obelix.sePresenter();
		doublepolemix.sePresenter();
	}
}
