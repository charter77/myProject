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
	
	private int m_DureeVieMin = 1;
	private int m_DureeVieMax = 6;
	
	public Ouvrieres(Fourmiliere p_maFourmiliere) {
		super("Ouvrieres");
		super.setDureeVie(ThreadLocalRandom.current().nextInt(this.m_DureeVieMin, this.m_DureeVieMax)*365);
		super.setMaFourmiliere(p_maFourmiliere);
	}
	
	public int getDureeVie() {
		return super.getDureeVie();
	}
	
	@Override
	public void OperationJournaliere(Fourmiliere f) {
		if (this.getMaFourmiliere().getNbNourriture() > this.getMaFourmiliere().NbReines()
				+ this.getMaFourmiliere().NbOuvrieres() + this.getMaFourmiliere().NbSoldates()*2 ) {
			Manger();
		}
		else {
			Fourrager();
		}
	}
	
	public void Fourrager() {
		this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture() +10);
	}
	public void Manger() {
		this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture() -1);
	}
}
