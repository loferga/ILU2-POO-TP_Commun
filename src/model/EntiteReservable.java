package model;

import model.formulaire.Formulaire;
import model.reservation.Reservation;

public abstract class EntiteReservable<F extends Formulaire> {
	
	protected CalendrierAnnuel cal;
	private int id;
	
	public EntiteReservable() {
		cal = new CalendrierAnnuel();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean estLibre(F formulaire) {
		return cal.estLibre(formulaire.getJour(), formulaire.getMois());
	}
	
	public abstract boolean compatible(F formulaire);
	
	public abstract Reservation reserver(F formulaire);
	
}
