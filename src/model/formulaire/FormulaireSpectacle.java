package model.formulaire;

public class FormulaireSpectacle extends Formulaire {
	
	private int numZone;
	private int numChaise;

	public FormulaireSpectacle(int jour, int mois, int numZone, int numChaise) {
		super(jour, mois);
		this.numZone = numZone;
		this.numChaise = numChaise;
	}

	public int getNumZone() {
		return numZone;
	}

	public int getNumChaise() {
		return numChaise;
	}

}
