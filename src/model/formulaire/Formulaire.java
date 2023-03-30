package model.formulaire;

public abstract class Formulaire {
	
	private int jour;
	private int mois;
	private int idEntite;
	
	protected Formulaire(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	public int getJour() {
		return jour;
	}
	
	public int getMois() {
		return mois;
	}
	
	public void setIdentificationEntite(int id) {
		idEntite = id;
	}
	
	public int getIdentificationEntite() {
		return idEntite;
	}
	
}