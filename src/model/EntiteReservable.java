package model;

import model.formulaire.Formulaire;
import model.reservation.Reservation;

public abstract class EntiteReservable<F extends Formulaire> {
	
	private CalendrierAnnuel cal;
	private int id;
	
	public EntiteReservable() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean estLibre(int jour, int mois) {
		return cal.estLibre(jour, mois);
	}
	
	public abstract boolean compatible();
	
	public abstract Reservation reserver();
	
}
