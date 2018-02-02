/**
 * 
 */
package ca.csf.dfc.poo.fourmiliere;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author martin
 *
 */
public class Soldates extends Fourmis {
	
	private int m_DureeVieMin = 2;
	private int m_DureeVieMax = 3;
	
	public Soldates(Fourmiliere p_maFourmiliere) {
		super("Soldates");
		super.setDureeVie(ThreadLocalRandom.current().nextInt(this.m_DureeVieMin, this.m_DureeVieMax)*365);
		super.setMaFourmiliere(p_maFourmiliere);
	}
	
	public int getDureeVie() {
		return super.getDureeVie();
	}
	
	@Override
	public void OperationJournaliere(Fourmiliere f) {
		if (this.getMaFourmiliere().getEstEnGuerreAvec() == null) {
			System.out.println("Il est temps de patrouiller ouvrière");
			this.Manger();
		}		
		else {
			System.out.println("Allons à la guerre soldate");
			this.Manger();
			this.Attaquer();
		}
		/*	if (this.getMaFourmiliere().getNbNourriture() >= 2 ) {
				this.Manger();
			}
			else {
				this.getMaFourmiliere().listeFourmis.remove(this);
				System.out.println("La soldate à manqué de nourriture, donc BYE BYE!!");
			}
		}
		else {
			if (this.getMaFourmiliere().getNbNourriture() > 0) {
				this.Manger();
				this.Attaquer();
			}
		}*/
	}
	
	/*public void Patrouiller() {
		Manger();
	}*/
	
	public void Attaquer() {
		ArrayList<Fourmis> listeFourmisAttaque = this.getMaFourmiliere().getEstEnGuerreAvec().getListeFourmis();
		int nbFourmis = listeFourmisAttaque.size();
		if (nbFourmis == 0 ) {
			this.getMaFourmiliere().listeFourmis.remove(this);
		}
		else {
			this.getMaFourmiliere().getEstEnGuerreAvec().getListeFourmis().remove(ThreadLocalRandom.current().nextInt(0, nbFourmis));
		}
	}
	
	public void Manger() {
		if (this.getMaFourmiliere().getEstEnGuerreAvec() == null) {
			this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture() -2);			
		}
		else {
			this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture() -1);
		}
	}
}
