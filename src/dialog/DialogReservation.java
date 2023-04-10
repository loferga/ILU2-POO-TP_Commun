package dialog;

import control.ControlReserverTable;
import control.ControlVisualiserCarnetClientele;
import presentation.JFrameReservation;

public class DialogReservation {
	
	private ControlReserverTable controlReserverTable;
	private ControlVisualiserCarnetClientele controlVisualiserCarnetClientele;
	
	private int numClient;
	private int numService;
	private int nbPersonnes;
	private int jour;
	private int mois;
	private int numTable;
	private int[] proposition;
	
	private JFrameReservation presentationReservation;
	
	public DialogReservation(ControlReserverTable controlReserverTable, ControlVisualiserCarnetClientele controlVisualiserCarnetClientele) {
		this.controlReserverTable = controlReserverTable;
		this.controlVisualiserCarnetClientele = controlVisualiserCarnetClientele;
	}
	
	
	public void initDialog() {
		//Create presentation frame
		presentationReservation = new JFrameReservation();
		//Associate dialogue to presentation
		presentationReservation.setDialogue(this);
		//Initialize and enable presentation frame
		presentationReservation.initPresentation();
		presentationReservation.setVisible(true);
		
	}
	
	
	public void handleDateSelectedEvent(String date) {
		String[] split = date.split("-");
		this.jour = Integer.parseInt(split[2]);
		this.mois = Integer.parseInt(split[1]);
	}
	
	public void handleTimeSelectedEvent(String time) {
		String[] split = time.split("h");
		int f = Integer.parseInt(split[0]);
		if (f < 16) this.numService = 1;
		else this.numService = 2;
	}
	
	public void handleNumofPersonsSelectedEvent(String numPersons) {
		this.nbPersonnes = Integer.parseInt(numPersons);
		this.proposition = controlReserverTable.trouverPossibilite(jour, mois, nbPersonnes, numService);
		presentationReservation.initTableMap(proposition);
		presentationReservation.enableTableMap();

		
	}
	
	public void handleTableSelectedEvent(int numTable) {
		int nbProposition = 0;
		int[] propositionRetenue = new int[proposition.length-1];
		for(int i = 1 ; i<proposition.length -1; i++)
			if(proposition[i] != 0)
				propositionRetenue[nbProposition++] = proposition[i];
		this.numTable = propositionRetenue[numTable];
	}
	
	public void handleCancelEvent() {
		this.jour = -1;
		this.mois = -1;
		this.nbPersonnes = -1;
		this.numService = -1;
		this.numTable = -1;
	}
	
	public void handleUserConnected(int numClient) {
		this.numClient = numClient;
	}
	
	public void handleValidateEvent() {
		controlReserverTable.reserver(numClient, numTable, proposition[0]);
		String donnees = controlVisualiserCarnetClientele.visualiserCarnetClientel();
		presentationReservation.enableValidationInformation(donnees);
	}
	
}
