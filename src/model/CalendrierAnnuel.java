package model;

public class CalendrierAnnuel {
	
	private class Mois {
		
		private String nom;
		private boolean[] jours;
		
		public Mois(String nom, int nbJours) {
			this.nom = nom;
			jours = new boolean[nbJours];
		}
		
		private boolean estLibre(int jour) {
			int ij = jour-1; // indice jour
			if (ij < 0 || jours.length < ij) return false;
			return !jours[ij];
		}
		
		private void reserver(int jour) {
			int ij = jour-1; // indice jour
			if (jours[ij]) throw new IllegalStateException();
			jours[ij] = true;
		}
		
		@Override
		public String toString() {
			return nom;
		}
		
	}
	
	private Mois[] mois;
	
	public CalendrierAnnuel() {
		mois = new Mois[] {
				new Mois("Janvier", 31),
				new Mois("Février", 28),
				new Mois("Mars", 31),
				new Mois("Avril", 30),
				new Mois("Mai", 31),
				new Mois("Juin", 30),
				new Mois("Juillet", 31),
				new Mois("Août", 31),
				new Mois("Septembre", 30),
				new Mois("Octobre", 31),
				new Mois("Novembre", 30),
				new Mois("Décembre", 31)
		};
	}
	
	public boolean estLibre(int jour, int mois) {
		return this.mois[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) throws IllegalStateException {
		try {
			this.mois[mois-1].reserver(jour);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}
	
}