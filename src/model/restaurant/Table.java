package model.restaurant;

import model.CalendrierAnnuel;
import model.EntiteReservable;
import model.formulaire.FormulaireRestaurant;
import model.reservation.Reservation;

public class Table extends EntiteReservable<FormulaireRestaurant> {
	
	private CalendrierAnnuel calendrierDeuxiemeService; // calendrier du second service
	private int nbChaise;
	
	public Table(int nbChaise) {
		super();
		calendrierDeuxiemeService = new CalendrierAnnuel();
		this.nbChaise = nbChaise;
	}
	
	@Override
	public boolean compatible() {
		// TODO
		return false;
	}

	@Override
	public Reservation reserver() {
		// TODO Auto-generated method stub
		return null;
	}

}
