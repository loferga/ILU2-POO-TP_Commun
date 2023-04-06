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
			boolean c1 = super.cal.estLibre(formulaire.getJour(), formulaire.getMois());
			boolean c2 = calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois());
			System.out.print(" cal1=" + c1 + " cal2=" + c2 + '\n');
			return (formulaire.getNumService() == 1 && super.cal.estLibre(formulaire.getJour(), formulaire.getMois()))
				|| (formulaire.getNumService() == 2 && calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois()));
		}
		
		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			int formNbPersonnes = formulaire.getNombrePersonnes();
			boolean a = nbChaise-1 <= formNbPersonnes && formNbPersonnes <= nbChaise;
			System.out.print(" nb=" + formulaire.getNombrePersonnes() + " rnb=" + nbChaise + " service="+ formulaire.getNumService() + " -> " + a + " - ");
			boolean b = estLibre(formulaire);
			return a && b;
		}

		@Override
		public ReservationRestaurant reserver(FormulaireRestaurant formulaire) {
			CalendrierAnnuel targetCal = formulaire.getNumService() == 1 ? super.cal : calendrierDeuxiemeService;
			targetCal.reserver(formulaire.getJour(), formulaire.getMois());
			return new ReservationRestaurant(
					formulaire.getJour(), formulaire.getMois(), formulaire.getNumService(), formulaire.getIdentificationEntite()
				);
		}

	}
	
	private CentraleReservation<Table, FormulaireRestaurant> centraleReservation = new CentraleReservation<>(new Table[20]);

	public void ajouterTable(int nbChaise) {
		Table t = new Table(nbChaise);
		t.setId(centraleReservation.ajouterEntite(t));
	}

	@Override
	public int[] donnerPossibilitees(FormulaireRestaurant formulaire) {
		int[] possibilites = centraleReservation.donnerPossibilites(formulaire);
		for (int i : possibilites)
			System.out.println(i + " - ");
		return possibilites;
	}

	@Override
	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		return centraleReservation.reserver(numEntite, formulaire);
	}

}