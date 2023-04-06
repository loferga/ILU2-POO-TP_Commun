package model.reservation;

public class ReservationHotel extends Reservation {

	private int nbLitSimple;
	private int nbLitDouble;
	private int numChambre;
	
	public ReservationHotel(int jour, int mois, int nbLitSimple, int nbLitDouble, int numChambre) {
		super(jour, mois);
		this.nbLitSimple = nbLitSimple;
		this.nbLitDouble = nbLitDouble;
		this.numChambre = numChambre;
	}
	
	public void do_nothing() {
		nbLitSimple = (int) nbLitSimple;
		nbLitDouble = (int) nbLitDouble;
		numChambre = (int) numChambre;
	}
	
}