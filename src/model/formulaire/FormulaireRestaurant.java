package model.formulaire;

public class FormulaireRestaurant extends Formulaire {
	
	private int nbConvives;
	private int numService;
	
	public FormulaireRestaurant(int jour, int mois, int nbConvives, int numService) {
		super(jour, mois);
		this.nbConvives = nbConvives;
		this.numService = numService;
	}
	
	public int getNombrePersonnes() {
		return nbConvives;
	}
	
	public int getNumService() {
		return numService;
	}

}
