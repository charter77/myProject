/**
 * 
 */
package ca.csf.dfc.poo.fourmiliere;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author martin
 *
 */
public class Ouvrieres extends Fourmis {
	
	/**
	 * Donnée membre pour la durée de vie minimum
	 */
	private int m_DureeVieMin = 1;
	/**
	 * Donnée membre pour la durée de vie maximum
	 */
	private int m_DureeVieMax = 6;
	
	/**
	 * Constructeur par initialisation
	 * @param p_maFourmiliere
	 */
	public Ouvrieres(Fourmiliere p_maFourmiliere) {
		super("Ouvrieres");
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
	 * Méthode pour les opérations journalière pour l'ouvrière
	 */
	@Override
	public void OperationJournaliere(Fourmiliere f) {
		if (this.getMaFourmiliere().getNbNourriture() > 0) {
			Manger();
		}
		else {
			Fourrager();
		}
	}
	
	/**
	 * Méthode pour fourrager, pour amasser de la nourriture dans la fourmilière
	 */
	private void Fourrager() {
		this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture() +10);
	}
	
}
