package objets;

public class Chaudron {
	private int quantitePotion ;
	private int forcePotion ;
	
	public void remplirChaudron(int quantite, int forcePotion) {
        this.quantitePotion = quantite;
        this.forcePotion = forcePotion;
    }
	
	public boolean resterPotion() {
		return this.quantitePotion > 0;
		
	}
	
	public int prendreLouche() {
		
		int forceDeLaLouche = this.forcePotion; 
        
        this.quantitePotion--; 
        
        if (this.quantitePotion <= 0) {
            this.quantitePotion = 0;
            this.forcePotion = 0;
        }
        
        return forceDeLaLouche;
		
	}
	

}
