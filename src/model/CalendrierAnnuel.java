package model;

public class CalendrierAnnuel {
	
	private enum Mois {
		
		// une enum est aussi une class donc est une classe interne, un modèle équivalent de l'enum avec une class serait:
		/*
		 * public class Mois {
		 * 		public final Mois JANVIER = new Mois("Janvier", 31);
		 * 		public final Mois FEVRIER = new Mois("Février", 28);
		 * 		...
		 */
		
		JANVIER("Janvier", 31), FEVRIER("Février", 28), MARS("Mars", 31), AVRIL("Avril", 30), MAI("Mai", 31), JUIN("Juin", 30), JUILLET("Juillet", 31),
		AOUT("Août", 31), SEMPTEMBRE("Septembre", 30), OCTOBRE("Octobre", 31), NOVEMBRE("Novembre", 30), DECEMBRE("Décembre", 31);
		
		private String nom;
		private boolean[] jours;
		
		private Mois(String nom, int nbJours) {
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
		mois = Mois.values();
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