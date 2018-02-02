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
	private boolean m_VolNuptial = false;
	private Fourmiliere m_estEnGuerreAvec = null;
	private int m_NbReines;
	private int m_NbOuvrieres;
	private int m_NbSoldates;
	private int m_NbNourriture;
	private Especes m_EspeceFourmis;
	private int m_JourDeAnnee = 1;
	private int m_JourDuVolNuptial;

	public static int NB_JOUR_ANNEE = 365;
	
	ArrayList<Fourmis> listeFourmis = new ArrayList<Fourmis>();
	
	private ArrayList<Fourmis> listeFourmisParAge(ArrayList<Fourmis> p_listToSort){
		p_listToSort.sort(Comparator.comparingInt(Fourmis::getDureeVie).reversed());
		return p_listToSort;
	}
	public ArrayList<Fourmis> getListeFourmis() {
		return listeFourmis;
	}
	public int getJourDuVolNuptial() {
		return m_JourDuVolNuptial;
	}
	public void setJourDuVolNuptial(int p_jourDuVolNuptial) {
		m_JourDuVolNuptial = p_jourDuVolNuptial;
	}
	public int getNbReine() {
		return m_NbReines;
	}
	public void setNbReine(int p_nbReine) {
		this.m_NbReines = p_nbReine;
	}
	public int getNbOuvrieres() {
		return m_NbOuvrieres;
	}
	public void setNbOuvrieres(int p_nbOuvrieres) {
		m_NbOuvrieres = p_nbOuvrieres;
	}
	public int getNbSoldates() {
		return m_NbSoldates;
	}
	public void setNbSoldates(int p_nbSoldates) {
		m_NbSoldates = p_nbSoldates;
	}
	public int getNbNourriture() {
		return m_NbNourriture;
	}
	public void setNbNourriture(int p_nbNourriture) {
		this.m_NbNourriture = p_nbNourriture;
	}
	public Especes getEspeceFourmis() {
		return m_EspeceFourmis;
	}
	public int getNbJourAvantVol() {
		return m_JourDeAnnee;
	}
	public void setNbJourAvantVol(int p_nbJourAvantVol) {
		this.m_JourDeAnnee = p_nbJourAvantVol;
	}
	public boolean isVolNuptial() {
		return m_VolNuptial;
	}
	public void setVolNuptial(boolean p_volNuptial) {
		m_VolNuptial = p_volNuptial;
	}
	public Fourmiliere getEstEnGuerreAvec() {
		return m_estEnGuerreAvec;
	}
	public void setEstEnGuerreAvec(Fourmiliere p_estEnGuerreAvec) {
		m_estEnGuerreAvec = p_estEnGuerreAvec;
	}
	
	public Fourmiliere(int p_NbReine, int p_NbNourriture, Especes p_EspeceFourmis) {
		this.m_NbReines = p_NbReine; 
		this.m_NbNourriture = p_NbNourriture;
		this.m_EspeceFourmis = p_EspeceFourmis;
		for (int i = 0; i < p_NbReine; i++) {
			Reines r = new Reines(this);
			r.setEstFeconde(true);
			//r.setMaFourmiliere(this);
			this.listeFourmis.add(r);
			this.m_NbReines++;
		}
		for (int j = 0; j < p_NbReine * 1; j++) {
			Ouvrieres o = new Ouvrieres(this);
			//o.setMaFourmiliere(this);
			this.listeFourmis.add(o);
			this.m_NbOuvrieres++;
		}
		for (int k = 0; k < p_NbReine * 1; k++) {
			Soldates s = new Soldates(this);
			//s.setMaFourmiliere(this);
			this.listeFourmis.add(s);
			this.m_NbSoldates++;
		}
		//Collections.shuffle(this.listeFourmis);
	}
	
	public void AjouterUneFourmi(Fourmis p_Fourmis) {
		for (Fourmis fourmis : listeFourmis) {
			if (fourmis instanceof Reines) {
				listeFourmis.add(p_Fourmis);
			}
			if (fourmis instanceof Ouvrieres) {
				listeFourmis.add(p_Fourmis);
			}
			if (fourmis instanceof Soldates) {
				listeFourmis.add(p_Fourmis);
			}
		}
	}
	
	public void TuerUneFourmis(Fourmis p_Fourmis) {
		if (this.listeFourmis.size() > 0) {
			listeFourmis.remove(p_Fourmis);
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
	
	public int getNombreDefourmisTotale (){
	  int result = this.NbReines() + this.NbOuvrieres() + this.NbSoldates();
	  return result;
	}
	
	public int NbReines() {
		int r = 0;
		for(Fourmis f:listeFourmis) {
			if (f instanceof Reines) {
				r++;
			}
		}
		return r;
	}
	
	public int NbOuvrieres() {
		int o = 0;
		for(Fourmis f:listeFourmis) {
			if (f instanceof Ouvrieres) {
				o++;
			}
		}
		return o;
	}
	
	public int NbSoldates() {
		int s = 0;
		for(Fourmis f:listeFourmis) {
			if (f instanceof Soldates) {
				s++;
			}
		}
		return s;
	}
	
	public void ValiderMomentVolNuptial() {
		if (this.m_JourDeAnnee == this.NB_JOUR_ANNEE) {
			this.m_VolNuptial = true;
		}
	}
	
	public void VolNuptial() {
		for (Fourmis f : listeFourmis) {
			if (f instanceof Reines) {
				if (!f.getMaFourmiliere().m_VolNuptial) {
					f.getMaFourmiliere().m_VolNuptial = true;
				}
			}
		}this.m_VolNuptial = true;
	}
	
	public void Guerre(Fourmiliere p_fourmiliere) {
		this.setEstEnGuerreAvec(p_fourmiliere);
	}
	
	public void OperationJournaliere() {
		this.definirJourNuptial();
		for (int i = this.listeFourmis.size()-1; i >=0; i--) {
			Fourmis f = listeFourmis.get(i);
			
			f.OperationJournaliere(this);
			f.setDureeVie(f.getDureeVie() - 1);
			if (f.getDureeVie() <= 0) {
				this.TuerUneFourmis(f);
			}
		}
	}
	
	public void definirJourNuptial() {
		this.m_VolNuptial = false;
		this.m_JourDeAnnee++;
		if (this.m_JourDeAnnee == 1) {
			this.m_JourDuVolNuptial = ThreadLocalRandom.current().nextInt(364)+1;
		}
		if (this.m_JourDeAnnee == this.m_JourDuVolNuptial) {
			this.m_VolNuptial = true;
		}
		if (this.m_JourDeAnnee == 365) {
			this.m_JourDeAnnee = 0;
		}
	}
	
	@Override
	public String toString() {
		listeFourmisParAge(this.listeFourmis);
		System.out.println("Informations pour la fourmilière " + this.getEspeceFourmis().toString());
		ArrayList<Fourmis> listeReines = new ArrayList<Fourmis>();
		ArrayList<Fourmis> listeOuvrieres = new ArrayList<Fourmis>();
		ArrayList<Fourmis> listeSoldates = new ArrayList<Fourmis>();
		for (Fourmis fourmi : listeFourmis) {
			if (fourmi instanceof Reines) {
				listeReines.add(fourmi);
			}
			if (fourmi instanceof Ouvrieres) {
				listeOuvrieres.add(fourmi);
			}
			if (fourmi instanceof Soldates) {
				listeSoldates.add(fourmi);
			}
		}
		System.out.println("Nombre de reines: " + listeReines.size());
		for (Fourmis fourmis : listeReines) {
			System.out.println(fourmis);
		}
		System.out.println("Nombre d'ouvrières: " + listeOuvrieres.size());
		for (Fourmis fourmis : listeOuvrieres) {
			System.out.println(fourmis);
		}
		System.out.println("Nombre de soldates: " + listeSoldates.size());
		for (Fourmis fourmis : listeSoldates) {
			System.out.println(fourmis);
		}
		String enGuerre = "NON";
		if (this.m_estEnGuerreAvec != null) {
			enGuerre = this.m_estEnGuerreAvec.toString();
		}
		return "Fourmiliere en guerre: " + enGuerre + "\nQuantité de nourriture: "
		+ this.m_NbNourriture + "\n";	
	}
}
