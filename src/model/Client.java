package model;

import model.reservation.Reservation;

public class Client {
	
	private String nom;
	private String prenom;
	private String adresseMail;
	private String mdp;
	private Reservation[] reservations;
	private int nbReservations = 0;

	public Client(String nom, String prenom, String adresseMail, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.mdp = mdp;
		reservations = new Reservation[100];
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public boolean connecterClient(String mdp) {
		return mdp.equals(this.mdp);
	}
	
	public void ajouterReservation(Reservation reservation) {
		reservations[nbReservations++] = reservation;
	}

	// UNIQUEMENT POUR VERIFICATION
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Client :\n");
		chaine.append("nom=" + nom + ", prenom=" + prenom);
		chaine.append(", adresseMail=" + adresseMail + ", mdp=" + mdp);
		chaine.append("\nReservation :\n");
		for (int i = 0; i<nbReservations; i++)
			chaine.append(reservations[i]);
		return chaine.toString();
	}
}