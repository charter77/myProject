/**
 * 
 */
package ca.csf.dfc.poo.fourmiliere;

/**
 * @author martin
 *
 */
public abstract class Fourmis implements Comparable<Fourmis>{
	/**
	 * Donnée membre pour la durée de vie d'une fourmi
	 */
	private int m_DureeVie;
	/**
	 * Donnée membre pour le Type de fourmi
	 */
	private String m_TypeFourmis;
	/**
	 * Donnée membre pour maFourmilière
	 */
	private Fourmiliere m_MaFourmiliere;
	
	/**
	 * Constructeur par initialisation avec le type de la fourmis
	 * @param p_typeFourmis
	 */
	protected Fourmis(String p_typeFourmis) {
		this.m_TypeFourmis = p_typeFourmis;
	}
	
	/**
	 * Méthode ui permet d'avoir la fourmilière assigné à la fourmi
	 * @return
	 */
	public Fourmiliere getMaFourmiliere() {
		return m_MaFourmiliere;
	}

	/**
	 * Méthode qui permet de setter la fourmilière dans laquel se trouve la fourmi
	 * @param p_maFourmiliere
	 */
	public void setMaFourmiliere(Fourmiliere p_maFourmiliere) {
		this.m_MaFourmiliere = p_maFourmiliere;
	}

	/**
	 * Méthode qui permet de setter la durée de vie
	 * @param p_dureeVie
	 */
	public void setDureeVie(int p_dureeVie) {
		this.m_DureeVie = p_dureeVie;
	}
	
	/**
	 * Méthode qui permet d'avoir la durée de vie
	 * @return
	 */
	public int getDureeVie() {
		return this.m_DureeVie;
	}
	/**
	 * Méthode qui force la création des opérations journalière de chque fourmi
	 * @param f
	 */
	public abstract void OperationJournaliere(Fourmiliere f);
	
	/**
	 * Méthode pour faire manger les foumis
	 */
	protected void Manger() {
		if (this.getMaFourmiliere().getNbNourriture() < 1 ) {
			this.getMaFourmiliere().TuerUneFourmis(this);
		}
		else {
			this.getMaFourmiliere().setNbNourriture(this.getMaFourmiliere().getNbNourriture() -1);
		}
	}
	
	/**
	 * Méthode pour afficher les informations de la foumi
	 */
	@Override
	public String toString() {
		return this.m_TypeFourmis + ", Jours Vie restant: " + this.m_DureeVie;
	}
	
	/**
	 * Méthode ppour comparer 2 fourmis
	 */
	@Override
	public int compareTo(Fourmis p_autreFourmis) {
		// TODO Auto-generated method stub
		//this.m_MaFourmiliere.equals(p_fourmis);
		return p_autreFourmis.getDureeVie() - this.getDureeVie();
	}
}
