package personnages;

import objets.Equipement;

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

	/*
	 * public void recevoirCoup(int forceCoup) { assert forceCoup > 0; this.force =
	 * this.force - forceCoup ; int oldForce = force; force -= forceCoup; if (force
	 * < 1) { force = 0; parler("J'abandonne !"); } else { parler("aie !"); } assert
	 * force < oldForce; assert isInvariantVerified(); }
	 */

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		}
		else
		{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			System.out.println("\nMais heureusement, grace à mon équipement sa force est diminué de ");
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte = +resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null)
			{
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				equipements[i] = null;
				nbEquipementEjecte++;
			}
		}
		return equipementEjecte;
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat" + "nom" + "est deja bien protégé !");
			break;
		case 1:
			if (equipements[0].equals(equipement)) {
				System.out.println("Le soldat" + nom + "possède deja un" + equipement + ".");
			} else {
				equiperSoldat(equipement);
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

	public static void main(String[] arg) {
		new Romain("Minus", -6);

	}

	public int getForce() {
		return force;
	}
}
