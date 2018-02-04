package ca.csf.dfc.poo.fourmiliere;

public enum Especes {
	JAUNES("Jaunes"), ROUGES("Rouges"), NOIRS("Noirs"), BRUNES("Brunes"), VERTES("Vertes");
	/**
	 * Donnée membre espèce
	 */
	private String m_espece;
	
	/**
	 * Constructeur par initialisation
	 * @param p_espece
	 */
	private Especes(String p_espece) {
		this.m_espece = p_espece;
	}
	/**
	 * Méthode pour afficher l'espèce
	 */
	public String toString() {
		return this.m_espece;
	}
}
