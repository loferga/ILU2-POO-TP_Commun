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
		chaine.append("Le " + super.jour + "/" + super.mois + "\n");
		chaine.append("Table " + numTable + " pour ");
		if (numService == 1)
			chaine.append("le premier service.");
		else
			chaine.append("le deuxième service.");

		return chaine.toString();
	}

}
