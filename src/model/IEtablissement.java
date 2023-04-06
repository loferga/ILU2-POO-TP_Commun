package model;

import model.formulaire.Formulaire;
import model.reservation.Reservation;

public interface IEtablissement <F extends Formulaire> {
	
	public int[] donnerPossibilitees(F formulaire);
	
	public Reservation reserver(int numEntite, F formulaire);
	
}