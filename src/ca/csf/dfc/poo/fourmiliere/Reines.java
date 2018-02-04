/**
 * 
 */
package ca.csf.dfc.poo.fourmiliere;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author martin
 *
 */
public class Reines extends Fourmis {
	
	/**
	 * Donnée membre pour mettre la reine féconde ou pas
	 */
	private boolean m_EstFeconde = false;
	/**
	 * Donnée membre pour la durée de vie minimum
	 */
	private int m_DureeVieMin = 10;
	/**
	 * Donnée membre pour la durée de vie maximum
	 */
	private int m_DureeVieMax = 20;
	
	/**
	 * Méthode pour savoir si la reine est féconde
	 * @return
	 */
	public boolean isEstFeconde() {
		return this.m_EstFeconde;
	}

	/**
	 * Méthode pour setter la reine féconde
	 * @param p_estFeconde
	 */
	public void setEstFeconde(boolean p_estFeconde) {
		this.m_EstFeconde = p_estFeconde;
	}
	
	/**
	 * Méthode pour voir la durée de vie
	 */
	public int getDureeVie() {
		return super.getDureeVie();
	}
	
	/**
	 * Constructeur par initialisation avec une fourmililère en paramètre
	 * @param p_maFourmiliere
	 */
	public Reines(Fourmiliere p_maFourmiliere) {
		super("Reines");
		super.setDureeVie(ThreadLocalRandom.current().nextInt(this.m_DureeVieMin, this.m_DureeVieMax)*365);
		super.setMaFourmiliere(p_maFourmiliere);
	}
	
	/**
	 * Méthode pour les opérations journalière de la reine
	 */
	@Override
	public void OperationJournaliere(Fourmiliere f) {
		if (this.m_EstFeconde) {
			this.Pondre();
			this.Manger();
		}
		else {
			this.Manger();
		}
	}
	
	/**
	 * Méthode pour afficher les informations de la reine
	 */
	@Override
	public String toString() {
		String fécondé = "NON";
		if (this.m_EstFeconde) {
			fécondé = "OUI";
		}
		return  "Reine" + ", Jours vie restant: " + this.getDureeVie() + ", est fécondé: " + fécondé;
	}
	
	/**
	 * Méthode pour faire pondre la reine
	 */
	private void Pondre() {
		System.out.println("Je vais pondre une jolie fourmi!!");
		if (this.getMaFourmiliere() == null || !(this instanceof Reines) || !this.m_EstFeconde) {
			throw new IllegalArgumentException("La fourmilière ne peut-être nulle ou l'espèce n'est pas une reine fécondé!");
		}
		if (this.getMaFourmiliere().NbOuvrieres() <= 10/3.0*this.getMaFourmiliere().NbSoldates()) {
			System.out.println("J'ai pondu une ouvrière!!");
			this.getMaFourmiliere().listeFourmis.add(new Ouvrieres(this.getMaFourmiliere()));
		}
		else if (this.getMaFourmiliere().NbSoldates() <= 3*this.getMaFourmiliere().NbReines()) {
			System.out.println("J'ai pondu une soldate!!");
			this.getMaFourmiliere().listeFourmis.add(new Soldates(this.getMaFourmiliere()));
		}
		else {
			System.out.println("J'ai pondu une reine!!");
			this.getMaFourmiliere().listeFourmis.add(new Reines(this.getMaFourmiliere()));
		}
		if (this.getMaFourmiliere().getNbNourriture() > 0) {
			System.out.println("COOL asser de nourriture, je mange!");
			this.Manger();
		}
		else {
			System.out.println("Zut pas de nourriture, Je dois manger une ouvrieres!!");
			boolean manger = false;
			int f = 0;
			Fourmis temp = null;
			while (!manger || f < this.getMaFourmiliere().listeFourmis.size()) {
				System.out.println("Laquelle choisir!!");
				if (this.getMaFourmiliere().listeFourmis.get(f) instanceof Ouvrieres) {
					temp = this.getMaFourmiliere().listeFourmis.get(f);
					this.getMaFourmiliere().TuerUneFourmis(temp);
					this.getMaFourmiliere().listeFourmis.remove(f);
					manger = true;
				}
				else {
					System.out.println("Pas d'ouvrière présente dans la liste!");
					System.out.println(manger);
					f++;
				}
			}
			if (!manger) {
				System.out.println("AHHH non il y a pas d'ouvrieres! Je vais mourir!");
				this.getMaFourmiliere().TuerUneFourmis(this);
				this.getMaFourmiliere().listeFourmis.remove(this);
			}
		}
	}
	
	/**
	 * Méthode pour effectuer le vol nuptial de la reine.
	 */
	public void VolNuptialReine() {
		if (this.getMaFourmiliere().isVolNuptial() == true) {
			this.m_EstFeconde = true;
			Manger();
		}
	}
}
