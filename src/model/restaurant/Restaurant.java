package model.restaurant;

import model.IEtablissement;
import model.formulaire.FormulaireRestaurant;
import model.reservation.Reservation;
import model.reservation.ReservationRestaurant;

public class Restaurant implements IEtablissement<FormulaireRestaurant> {
	
	private Table[] tables = new Table[20];

	public void ajouterTable(int nbChaise) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] donnerPossibilitees(FormulaireRestaurant formulaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		// recherche l'indice de la table ayant pour id *numEntite* dans le tableau *tables*
		int numTable = -1;
		for (int i = 0; i<numEntite && numTable == -1; i++)
			if (tables[i].getId() == numEntite)
				numTable = i;
		ReservationRestaurant reservation =
				new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), formulaire.getNumService(), numTable);
		return reservation;
	}

}