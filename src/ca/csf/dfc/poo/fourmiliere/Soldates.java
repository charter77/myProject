/**
 * 
 */
package ca.csf.dfc.poo.fourmiliere;

import java.util.concurrent.ThreadLocalRandom;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author martin
 *
 */
public class Soldates extends Fourmis {
	/**
	 * Donnée membre pour la durée de vie minimum
	 */
	private int m_DureeVieMin = 2;
	/**
	 * Donnée membre pour la durée de vie maximum
	 */
	private int m_DureeVieMax = 3;
	
	/**
	 * Constructeur par initialisation avec une fourmiliere en parametre
	 * @param p_maFourmiliere
	 */
	public Soldates(Fourmiliere p_maFourmiliere) {
		super("Soldates");
		super.setDureeVie(ThreadLocalRandom.current().nextInt(this.m_DureeVieMin, this.m_DureeVieMax)*365);
		super.setMaFourmiliere(p_maFourmiliere);
	}
	/**
	 * Méthode pour avoir la durée de vie
	 */
	public int getDureeVie() {
		return super.getDureeVie();
	}
	
	/**
	 * Méthode pour les opérations journalière de la soldate
	 */
	@Override
	public void OperationJournaliere(Fourmiliere f) {
		if (this.getMaFourmiliere().getEstEnGuerreAvec() == null) {
			//System.out.println("Il est temps de patrouiller soldate");
			this.Manger();
		}		
		else {
			System.out.println("Allons à la guerre soldate");
			this.Manger();
			this.Attaquer();
		}
	}
	
	/**
	 * Méthode pour faire attaquer la soldate
	 */
	private void Attaquer() {
		ArrayList<Fourmis> listeFourmisAttaque = this.getMaFourmiliere().getEstEnGuerreAvec().getListeFourmis();
		int nbFourmis = listeFourmisAttaque.size();
		if (nbFourmis == 0 ) {
			this.getMaFourmiliere().listeFourmis.remove(this);
		}
		else {
			this.getMaFourmiliere().getEstEnGuerreAvec().getListeFourmis().remove(ThreadLocalRandom.current().nextInt(0, nbFourmis));
		}
	}
	
	/**
	 * Méthode pour faire manger la soldate
	 */
	@Override
	public void Manger() {
		if (this.getMaFourmiliere().getNbNourriture() < 1 && this.getMaFourmiliere().getEstEnGuerreAvec() != null) {
			this.getMaFourmiliere().TuerUneFourmis(this);
		}
		else if (this.getMaFourmiliere().getNbNourriture() < 2 && this.getMaFourmiliere().getEstEnGuerreAvec() == null) {
			this.getMaFourmiliere().TuerUneFourmis(this);
		}
		else {
			this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture() -2);			
		}
	}
}
