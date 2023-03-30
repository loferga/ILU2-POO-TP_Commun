package model.reservation;

public abstract class Reservation {
	
	protected int jour;
	protected int mois;
	
	protected Reservation(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
}