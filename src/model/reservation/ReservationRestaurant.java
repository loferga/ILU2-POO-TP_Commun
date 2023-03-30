package model.reservation;

public class ReservationRestaurant extends Reservation {
	
	private int numService;
	private int numTable;

	public ReservationRestaurant(int jour, int mois, int numService, int numTable) {
		super(jour, mois);
		this.numService = numService;
		this.numTable = numTable;
	}
	
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Le " + super.jour + "/" + super.mois + " : ");
		chaine.append("table n°" + numTable + " pour ");
		if (numService == 1)
			chaine.append("le premier service.\n");
		else
			chaine.append("le deuxième service.\n");

		return chaine.toString();
	}

}
