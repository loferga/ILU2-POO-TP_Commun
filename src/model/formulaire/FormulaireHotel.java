package model.formulaire;

public class FormulaireHotel extends Formulaire {
	
	private int nbLitSimple;
	private int nbLitDouble;
	
	public FormulaireHotel(int jour, int mois, int nbLitSimple, int nbLitDouble) {
		super(jour, mois);
		this.nbLitSimple = nbLitSimple;
		this.nbLitDouble = nbLitDouble;
	}

	public int getNbLitSimple() {
		return nbLitSimple;
	}

	public int getNbLitDouble() {
		return nbLitDouble;
	}

}