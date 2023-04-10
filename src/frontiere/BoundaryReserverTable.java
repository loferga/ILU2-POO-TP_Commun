package frontiere;

import java.util.Scanner;

import control.ControlReserverTable;

public class BoundaryReserverTable {
	
	private Scanner scan;
	private ControlReserverTable controlReserverTable;
	
	public BoundaryReserverTable(ControlReserverTable controlReserverTable) {
		this.controlReserverTable = controlReserverTable;
		this.scan = new Scanner(System.in);
	}
	
	public void reserverTable(int numClient) {
		System.out.println("Quand souhaitez vous réserver ?");
		System.out.println("Quel mois ?");
		int mois = scan.nextInt();
		System.out.println("Quel jour ?");
		int jour = scan.nextInt();
		System.out.println("Pour combien de personnes ?");
		int nbPersonnes = scan.nextInt();
		System.out.println("Pour quel service ?");
		int nbService = scan.nextInt();
		int[] possibilites = controlReserverTable.trouverPossibilite(jour, mois, nbPersonnes, nbService);
		for (int i = 1; i<possibilites.length; i++)
			System.out.println("numéro de table : " + possibilites[i]);
		System.out.println("Choisissez votre table");
		int table = scan.nextInt();
		controlReserverTable.reserver(numClient, table, possibilites[0]);
	}
	
}