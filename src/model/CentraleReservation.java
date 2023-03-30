package model;

import model.formulaire.Formulaire;

public class CentraleReservation <E extends EntiteReservable, F extends Formulaire> {
	
	private E[] entites;
	private int nbEntites;
	
	public CentraleReservation(E[] entites) {
		this.entites = entites;
	}
	
	public void ajouterEntite(E enite) {
		
	}
	
	public void donnerPossibilites(F formulaire) {
		
	}
	
	public void reserver(int id, F formulaire) {
		
	}
	
}