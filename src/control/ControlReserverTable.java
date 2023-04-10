package control;

import model.CarnetClientele;
import model.Client;
import model.formulaire.FormulaireRestaurant;
import model.reservation.Reservation;
import model.reservation.ReservationRestaurant;
import model.restaurant.Restaurant;

public class ControlReserverTable {
	
	private Restaurant restaurant;
	private CarnetClientele carnetClientele;
	
	private FormulaireRestaurant[] formulaires;
	
	public ControlReserverTable(Restaurant restaurant, CarnetClientele carnetClientele) {
		this.restaurant = restaurant;
		this.carnetClientele = carnetClientele;
		formulaires = new FormulaireRestaurant[20];
	}
	
	public int[] trouverPossibilite(int jour, int mois, int nbPersonnes, int numService) {
		FormulaireRestaurant formulaire = new FormulaireRestaurant(jour, mois, nbPersonnes, numService);
		boolean formulaireEnregistrer = false;
		int numeroFormulaire = -1;
		for (int i = 0; i < formulaires.length && !formulaireEnregistrer; i++) {
			if (formulaires[i] == null) {
				formulaires[i] = formulaire;
				formulaireEnregistrer = true;
				numeroFormulaire = i;
			}
		}
		int[] possibilites = restaurant.donnerPossibilitees(formulaire);
		int[] retour = new int[possibilites.length + 1];
		retour[0] = numeroFormulaire;
		for (int i = 1; i < possibilites.length + 1; i++) {
			retour[i] = possibilites[i - 1];
		}
		return retour;
	}
	
	public void reserver(int numClient, int numTable, int numeroFormulaire) {
		FormulaireRestaurant formulaireRestaurant = formulaires[numeroFormulaire];
		Reservation reservation = restaurant.reserver(numTable, formulaireRestaurant);
		formulaires[numeroFormulaire] = null;
		if (reservation instanceof ReservationRestaurant) {
			ReservationRestaurant reservationRestaurant = (ReservationRestaurant) reservation;
			Client client = carnetClientele.getClient(numClient);
			client.ajouterReservation(reservationRestaurant);
		}
	}
	
}