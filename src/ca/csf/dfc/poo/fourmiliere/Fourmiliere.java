/**
 * 
 */
package ca.csf.dfc.poo.fourmiliere;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author martin
 *
 */
public class Fourmiliere {
	/**
	 * Valide que le vol nuptial est complété
	 */
	private boolean m_VolNuptial = false;
	/**
	 * Permet de setter la fourmilière en guerre
	 */
	private Fourmiliere m_estEnGuerreAvec = null;
	/**
	 * Nombre de reines dans la fourmilière
	 */
	private int m_NbReines;
	/**
	 * Nombre d'ouvrières dans la fourmilière
	 */
	private int m_NbOuvrieres;
	/**
	 * Nombre de soldates dans la fourmilière
	 */
	private int m_NbSoldates;
	/**
	 * Nombre de nourritures dans la fourmilière
	 */
	private int m_NbNourriture;
	/**
	 * Espèce de la fourmis fourmis d'un ENUM
	 */
	private Especes m_EspeceFourmis;
	/**
	 * Jour de l'année
	 */
	private int m_JourDeAnnee = 0;
	/**
	 * Jour du vol nuptial
	 */
	private int m_JourDuVolNuptial;
	
	/**
	 * Liste de toutes les fourmis
	 */
	ArrayList<Fourmis> listeFourmis = new ArrayList<Fourmis>();
	
	/**
	 * Construit la liste des fourmis par âge de vie
	 * @param p_listToSort
	 * @return p_listToSort
	 */
	private ArrayList<Fourmis> listeFourmisParAge(ArrayList<Fourmis> p_listToSort){
		p_listToSort.sort(Comparator.comparingInt(Fourmis::getDureeVie).reversed());
		return p_listToSort;
	}
	/**
	 * Méthode pour avoir la liste des fourmis
	 * @return listeFourmis
	 */
	public ArrayList<Fourmis> getListeFourmis() {
		return this.listeFourmis;
	}
	/**
	 * Méthode pour avoir le jour du vol nuptial
	 * @return m_JourDuVolNuptial
	 */
	public int getJourDuVolNuptial() {
		return this.m_JourDuVolNuptial;
	}
	/**
	 * Méthode pour setter le jour du vol nuptial
	 * @param p_jourDuVolNuptial
	 */
	public void setJourDuVolNuptial(int p_jourDuVolNuptial) {
		this.m_JourDuVolNuptial = p_jourDuVolNuptial;
	}
	/**
	 * Méthode pour avoir le nombre de reines
	 * @return m_NbReines
	 */
	public int getNbReine() {
		return this.m_NbReines;
	}
	/**
	 * Méthode pour setter le nombre de reine
	 * @param p_nbReine
	 */
	public void setNbReine(int p_nbReine) {
		this.m_NbReines = p_nbReine;
	}
	/**
	 * Méthode pour avoir le nombre d'ouvrière
	 * @return m_NbOuvrieres
	 */
	public int getNbOuvrieres() {
		return this.m_NbOuvrieres;
	}
	/**
	 * Méthode pour setter le nombre d'ouvrière
	 * @param p_nbOuvrieres
	 */
	public void setNbOuvrieres(int p_nbOuvrieres) {
		this.m_NbOuvrieres = p_nbOuvrieres;
	}
	/**
	 * Méthode pour avoir le nombre de soldate
	 * @return m_NbSoldates
	 */
	public int getNbSoldates() {
		return this.m_NbSoldates;
	}
	/**
	 * Méthode pour setter le nombre de soldate
	 * @param p_nbSoldates
	 */
	public void setNbSoldates(int p_nbSoldates) {
		this.m_NbSoldates = p_nbSoldates;
	}
	/**
	 * Méthode pour avoir le nombre de nourriture
	 * @return m_NbNourriture
	 */
	public int getNbNourriture() {
		return this.m_NbNourriture;
	}
	/**
	 * Méthode pour setter le nombre de nourriture
	 * @param p_nbNourriture
	 */
	public void setNbNourriture(int p_nbNourriture) {
		this.m_NbNourriture = p_nbNourriture;
	}
	/**
	 * Méthode pour avoir l'espèce des fourmis
	 * @return m_EspeceFourmis
	 */
	public Especes getEspeceFourmis() {
		return this.m_EspeceFourmis;
	}
	/**
	 * Méthode pour avoir le jour de l'année
	 * @return m_JourAnnee
	 */
	public int getJourDeAnnee() {
		return this.m_JourDeAnnee;
	}
	/**
	 * Méthodde pour setter le jour de l'année
	 * @param p_nbJourAvantVol
	 */
	public void setJourDeAnnee(int p_nbJourAvantVol) {
		this.m_JourDeAnnee = p_nbJourAvantVol;
	}
	/**
	 * Méthode pour indiquer que le vol nuptial a eu lieu
	 * @return m_VolNuptial
	 */
	public boolean isVolNuptial() {
		return this.m_VolNuptial;
	}
	/**
	 * Méthode pour setter le vol nuptial
	 * @param p_volNuptial
	 */
	public void setVolNuptial(boolean p_volNuptial) {
		this.m_VolNuptial = p_volNuptial;
	}
	/**
	 * Méthode pour connaître la fourmiliere en guerre avec
	 * @return m_estEnGuerreAvec
	 */
	public Fourmiliere getEstEnGuerreAvec() {
		return this.m_estEnGuerreAvec;
	}
	/**
	 * Méthode pour setter en guerre avec quel fourmilière
	 * @param p_estEnGuerreAvec
	 */
	public void setEstEnGuerreAvec(Fourmiliere p_estEnGuerreAvec) {
		this.m_estEnGuerreAvec = p_estEnGuerreAvec;
	}
	
	/**
	 * Constructeur par initialisation
	 * @param p_NbReine
	 * @param p_NbNourriture
	 * @param p_EspeceFourmis
	 */
	public Fourmiliere(int p_NbReine, int p_NbNourriture, Especes p_EspeceFourmis) {
		this.m_NbReines = p_NbReine; 
		this.m_NbNourriture = p_NbNourriture;
		this.m_EspeceFourmis = p_EspeceFourmis;
		for (int i = 0; i < p_NbReine; i++) {
			Reines r = new Reines(this);
			r.setEstFeconde(true);
			this.listeFourmis.add(r);
			this.m_NbReines++;
		}
		for (int k = 0; k < p_NbReine * 3; k++) {
			Soldates s = new Soldates(this);
			this.listeFourmis.add(s);
			this.m_NbSoldates++;
		}
		for (int j = 0; j < p_NbReine * 10; j++) {
			Ouvrieres o = new Ouvrieres(this);
			this.listeFourmis.add(o);
			this.m_NbOuvrieres++;
		}
		Collections.shuffle(this.listeFourmis);
	}
	
	/**
	 * Méthode pour tuer  une fourmis selon l'espèce
	 * @param p_Fourmis
	 */
	public void TuerUneFourmis(Fourmis p_Fourmis) {
		if (this.listeFourmis.size() > 0) {
			this.listeFourmis.remove(p_Fourmis);
			if (p_Fourmis instanceof Reines) {
				this.m_NbReines--;
			}
			if (p_Fourmis instanceof Ouvrieres) {
				this.m_NbOuvrieres--;
			}
			if (p_Fourmis instanceof Soldates) {
				this.m_NbSoldates--;
			}
		}
	}
	
	/**
	 * Méthode pour avoir le nombre total de fourmis
	 * @return result
	 */
	public int getNombreDefourmisTotale (){
	  int result = this.NbReines() + this.NbOuvrieres() + this.NbSoldates();
	  return result;
	}
	
	/**
	 * Méthode pour avoir le total de reine
	 * @return r
	 */
	public int NbReines() {
		int r = 0;
		for(Fourmis f: this.listeFourmis) {
			if (f instanceof Reines) {
				r++;
			}
		}
		return r;
	}
	
	/**
	 * Méthode pour avoir le total d'ouvrière
	 * @return o
	 */
	public int NbOuvrieres() {
		int o = 0;
		for(Fourmis f: this.listeFourmis) {
			if (f instanceof Ouvrieres) {
				o++;
			}
		}
		return o;
	}
	
	/**
	 * Méthode pour avoir le total de soldate
	 * @return s
	 */
	public int NbSoldates() {
		int s = 0;
		for(Fourmis f: this.listeFourmis) {
			if (f instanceof Soldates) {
				s++;
			}
		}
		return s;
	}
	
	/**
	 * Méthode pour setter le vol nuptial des reines de la fourmilière0
	 */
	public void VolNuptialFourmiliere() {
		this.m_VolNuptial = true;
		for (Fourmis f : this.listeFourmis) {
			if (f instanceof Reines) {
				if (!((Reines) f).isEstFeconde()) {
					((Reines) f).setEstFeconde(true);
				}
			}
		}
	}
	
	/**
	 * Méthode pour rentrer en guerre avec un autre fourmilière
	 * @param p_fourmiliere
	 */
	public void Guerre(Fourmiliere p_fourmiliere) {
		this.setEstEnGuerreAvec(p_fourmiliere);
	}
	
	/**
	 * Méthod pour exécuter les opérationsJournalière de chaque fourmi de la fourmilière
	 */
	public void OperationJournaliere() {
		this.definirJourNuptial();
		for (int i = this.listeFourmis.size()-1; i >=0; i--) {
			Fourmis f = this.listeFourmis.get(i);
			if (f.getDureeVie() > 1) {
				f.OperationJournaliere(this);				
				f.setDureeVie(f.getDureeVie() - 1);				
			}
			else {
				this.TuerUneFourmis(f);
			}
		}
	}
	
	/**
	 * Méthode pour faire avancer l'année et valider le jour nuptial
	 */
	public void definirJourNuptial() {
		this.m_JourDeAnnee++;
		if (this.m_JourDeAnnee == 1) {
			this.m_JourDuVolNuptial = ThreadLocalRandom.current().nextInt(1, 365);
		}
		if (this.m_JourDeAnnee == this.m_JourDuVolNuptial) {
			VolNuptialFourmiliere();
		}
		if (this.m_JourDeAnnee == 365) {
			this.m_JourDeAnnee = 0;
			this.m_VolNuptial = false;
		}
	}
	
	/**
	 * Méthode pour afficher les informations relative à la fourmilière
	 */
	@Override
	public String toString() {
		listeFourmisParAge(this.listeFourmis);
		System.out.println("Informations pour la fourmilière " + this.getEspeceFourmis().toString());
		int num = 1;
		for (Fourmis fourmi : this.listeFourmis) {
			System.out.println("Foumis " + num + ": " + fourmi);
			num++;
		}
		System.out.println("Nombre de reines: " + this.NbReines());
		System.out.println("Nombre d'ouvrières: " + this.NbOuvrieres());
		System.out.println("Nombre de soldates: " + this.NbSoldates());
		String enGuerre = "NON";
		if (this.m_estEnGuerreAvec != null) {
			enGuerre = "OUI";
		}
		String volNuptialFait = "NON";
		if (this.isVolNuptial() == true) {
			volNuptialFait = "OUI";
		}
		return "Quantité de nourriture: " + this.m_NbNourriture + "\nFourmiliere en guerre: " + enGuerre + "\n" 
		+ "Jour de l'année: " + this.m_JourDeAnnee + "\n" + "Jour du vol nuptial: " 
		+ this.m_JourDuVolNuptial + "\n" + "Vol nuptial effectué? " + volNuptialFait;	
	}
}
