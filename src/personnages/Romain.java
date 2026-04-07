package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		this.force = this.force - forceCoup ;
		int oldForce = force;
		force -= forceCoup;
		if (force < 1) 
		{
			force = 0;
			parler("J'abandonne !");
		}
		else
		{
			parler("aie !");
		}
		assert force < oldForce;
		assert isInvariantVerified();
	}
	
	private boolean isInvariantVerified()
	{
		return force >= 0;
	}
	
	public void sEquiper(Equipement equipement)
	{
		switch (nbEquipement)
		{
		case 2:
			System.out.println("Le soldat" + "nom" + "est deja bien protégé !");
			break;
		case 1:
			if(equipement[0].equals(equipement)) {
				System.out.prinln("Le soldat" + nom + "possède deja un" + equipement + ".");
			}
			else
			{
				equiperSolat(equipement);
			}
			break;
			default:
				equiperSoldat(equipement);
				break;
		}
	}
	
	private void equiperSoldat(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat" + "nom " + "s'équipe avec " + equipement);
	}
	
	public static void main(String arg[]) {
		Romain minus = new Romain("Minus",-6);
		
	}
}
