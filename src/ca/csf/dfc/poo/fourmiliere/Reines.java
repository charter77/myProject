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
public class Reines extends Fourmis {
	
	private boolean m_EstFeconde = false;
	private int m_DureeVieMin = 10;
	private int m_DureeVieMax = 20;
	
	public boolean isEstFeconde() {
		return this.m_EstFeconde;
	}

	public void setEstFeconde(boolean p_estFeconde) {
		this.m_EstFeconde = p_estFeconde;
	}

	public Reines(Fourmiliere p_maFourmiliere) {
		super("Reines");
		super.setDureeVie(ThreadLocalRandom.current().nextInt(this.m_DureeVieMin, this.m_DureeVieMax)*365);
		super.setMaFourmiliere(p_maFourmiliere);
	}
	
	public int getDureeVie() {
		return super.getDureeVie();
	}
	
	@Override
	public void OperationJournaliere(Fourmiliere f) {
		if (this.m_EstFeconde) {
			this.getMaFourmiliere().listeFourmis.add(Pondre());
			Manger();
		}
		else {
			this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture()-1);
		}
	}
	
	public void Manger() {
		boolean manger = false;
		if (this.getMaFourmiliere().getNbNourriture() > 0) {
			this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture()-1);
			manger = true;
		}
		else if (this.getMaFourmiliere().getNbNourriture() == 0) {
			ArrayList<Fourmis> maListeFourmis = this.getMaFourmiliere().listeFourmis;
			int f = 0;
			while (!manger || f < maListeFourmis.size()) {
				if (maListeFourmis.get(f) instanceof Ouvrieres) {
					maListeFourmis.remove(f);
					manger = true;
				}
				else {
					f++;
				}
			}
			if (!manger) {
				this.getMaFourmiliere().setNbReine(this.getMaFourmiliere().getNbReine() -1);
				maListeFourmis.remove(this);
			}
		}
	}
	
	@Override
	public String toString() {
		String fécondé = "NON";
		if (this.m_EstFeconde) {
			fécondé = "OUI";
		}
		return  "Reine" + ", Jours vie: " + this.getDureeVie() + ", est fécondé: " + fécondé;
	}
	
	public Fourmis Pondre() {
		Fourmis especeFourmisPondre = new Ouvrieres(this.getMaFourmiliere());
		/*if (this.m_EstFeconde) {
			int qtyReines = this.getMaFourmiliere().NbReines();
			int ratioOuvrieres = this.getMaFourmiliere().NbOuvrieres() / qtyReines;
			int rationSoldates = this.getMaFourmiliere().NbSoldates() / qtyReines;
			if (qtyReines < 1) {
				especeFourmisPondre = new Reines(this.getMaFourmiliere());
			}
			else if (rationSoldates < ratioOuvrieres) {
				especeFourmisPondre = new Soldates(this.getMaFourmiliere());
			}
			else if (ratioOuvrieres < rationSoldates) {
				especeFourmisPondre = new Ouvrieres(this.getMaFourmiliere());
			}
		}*/
		return especeFourmisPondre;
	}
	
	public void VolNuptial() {
		if (this.getMaFourmiliere().isVolNuptial() == true) {
			this.m_EstFeconde = true;
			Manger();
		}
	}
}
