package model;

import model.formulaire.Formulaire;
import model.reservation.Reservation;

public class CentraleReservation <E extends EntiteReservable<F>, F extends Formulaire> {
	
	private E[] entites;
	private int nbEntites;
	
	public CentraleReservation(E[] entites) {
		this.entites = entites;
		nbEntites = 0;
	}
	
	public int ajouterEntite(E entite) {
		entites[nbEntites++] = entite;
		return nbEntites;
	}
	
	public int[] donnerPossibilites(F formulaire) {
		int[] dispos = new int[nbEntites];
		for (int i = 0; i<nbEntites; i++) {
			E e = entites[i];
			if (e.compatible(formulaire))
				dispos[i] = e.getId();
			else dispos[i] = 0;
		}
		return dispos;
	}
	
	public Reservation reserver(int id, F formulaire) {
		E aReserver = entites[id-1];
		formulaire.setIdentificationEntite(id);
		return aReserver.reserver(formulaire);
	}
	
}