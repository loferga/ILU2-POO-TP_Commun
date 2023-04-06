package model.restaurant;

import model.CalendrierAnnuel;
import model.CentraleReservation;
import model.EntiteReservable;
import model.IEtablissement;
import model.formulaire.FormulaireRestaurant;
import model.reservation.Reservation;
import model.reservation.ReservationRestaurant;

public class Restaurant implements IEtablissement<FormulaireRestaurant> {
	
	public class Table extends EntiteReservable<FormulaireRestaurant> {
		
		private CalendrierAnnuel calendrierDeuxiemeService; // calendrier du second service
		private int nbChaise;
		
		public Table(int nbChaise) {
			super();
			calendrierDeuxiemeService = new CalendrierAnnuel();
			this.nbChaise = nbChaise;
		}
		
		public int getNbChaise() {
			return nbChaise;
		}
		
		@Override
		public boolean estLibre(FormulaireRestaurant formulaire) {
			return (formulaire.getNumService() == 1 && super.cal.estLibre(formulaire.getJour(), formulaire.getMois()))
				|| (formulaire.getNumService() == 2 && calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois()));
		}
		
		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			int formNbPersonnes = formulaire.getNombrePersonnes();
			return nbChaise-1 <= formNbPersonnes && formNbPersonnes <= nbChaise
				&& estLibre(formulaire);
		}
		
		@Override
		public ReservationRestaurant reserver(FormulaireRestaurant formulaire) {
			return new ReservationRestaurant(
					formulaire.getJour(), formulaire.getMois(), formulaire.getNumService(), formulaire.getIdentificationEntite()
				);
		}
		
	}
	
	public static final int TABLE_MAX_SIZE = 20;
	
	private CentraleReservation<Table, FormulaireRestaurant> centraleReservation =
			new CentraleReservation<>(new Table[TABLE_MAX_SIZE]);
	
	public void ajouterTable(int nbChaise) {
		Table t = new Table(nbChaise);
		t.setId(centraleReservation.ajouterEntite(t));
	}
	
	@Override
	public int[] donnerPossibilitees(FormulaireRestaurant formulaire) {
		return centraleReservation.donnerPossibilites(formulaire);
	}
	
	@Override
	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		return centraleReservation.reserver(numEntite, formulaire);
	}
	
}