/**
 * 
 */
package ca.csf.dfc.poo.fourmiliere;

/**
 * @author martin
 *
 */
public abstract class Fourmis implements Comparable<Fourmis>{
	private int m_DureeVie;
	private String m_TypeFourmis;
	private Fourmiliere m_MaFourmiliere;

	protected Fourmis(String p_typeFourmis) {
		this.m_TypeFourmis = p_typeFourmis;
	}
	
	public Fourmiliere getMaFourmiliere() {
		return m_MaFourmiliere;
	}

	public void setMaFourmiliere(Fourmiliere p_maFourmiliere) {
		this.m_MaFourmiliere = p_maFourmiliere;
	}

	public void setDureeVie(int p_dureeVie) {
		this.m_DureeVie = p_dureeVie;
	}

	public int getDureeVie() {
		return this.m_DureeVie;
	}

	public abstract void OperationJournaliere(Fourmiliere f);
	
	public abstract void Manger();
	
	@Override
	public String toString() {
		return this.m_TypeFourmis + ", Jours Vie: " + this.m_DureeVie;
	}
	
	@Override
	public int compareTo(Fourmis p_fourmis) {
		// TODO Auto-generated method stub
		this.m_MaFourmiliere.equals(p_fourmis);
		return 0;
	}
}
